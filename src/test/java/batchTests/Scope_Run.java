package batchTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Utilities.DBUtility;

import static io.restassured.RestAssured.given;
import static java.lang.String.valueOf;

public class Scope_Run {

    /**
     * 1. Change the following scope name
     * 2. Open configuration.properties file and make sure ssmsDB_url is 'jdbc:sqlserver://srv-array-sql01.database.windows.net;Database='
     */
    private static String path = "OR3";

    /**
     * THERE IS NO NEED TO CHANGE ANY OF THE FOLLOWINGS.
     *
     * The following 3 variables should be updated depending on each job and scope
     * Job needs to run by order
     * Scope needs to static
     * System dates should be updated depending on each job
     */
    private static String job = "";
    public static String scopeOfWork = "";
    private static String systemDate = "";

    /**
     * The following variables are final (don't need to change)
     */
    private static final String param = "mDpmoOweKhS9lxz1iIlHAZx1MeFF9dZNVG5AQJSp308PIrgXTaleTw==";
    private static final String databaseServer = "srv-array-sql01";
    public static final String database = "modPIMS-"+path;
    private static final int memoryInGbPlatform = 4;
    private static final int cpuCoresPlatform = 2;
    private static final int cpuCoresBatch = 1;
    private static final String imageTag = "Cobol";

    public static void main(String[] args) throws InterruptedException {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader reader = new BufferedReader((new FileReader("src/test/resources/"+path+".csv")));
            while ((line = reader.readLine()) != null) {
                String[] jobs = line.split(splitBy);
                scopeOfWork = jobs[0];
                job = jobs[1];
                systemDate = jobs[2];

                System.out.println("Scope: '" + scopeOfWork+"'");
                System.out.println("Job Name: '"+job+"'");
                System.out.println("System Date: '"+ systemDate+"'");

                /**
                Connect to modPIMS database and run the following query before each job kick off
                 */
                String sql = "delete from NP.NPTTABL1 where TABL_ID = 'SYSDTE';\n" +
                        "insert into NP.NPTTABL1 (TABL_ID, TABL_SEQ, TABL_DATA, TABL_POST_KEY, TABL_POST_USERID) values ('SYSDTE', '', '" + systemDate + "', sysDateTime(), '');";
                DBUtility.establishConnection();
                DBUtility.runSQLQuery(sql);
               // System.out.println("Connected to "+ database + ". Executed: \n" + sql);
                RestAssured.baseURI = "https://func-batch-containers.azurewebsites.net/api";
                createJobRequestID();
                monitorJob();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        DBUtility.closeConnections();
    }

    /**
     * Hello Function
     */
    static void helloFunction(){
       Response response = given().
                queryParam("code",param).
                when().get("/HelloFunction").
                then().statusCode(200).extract().response();

        System.out.println(response);
    }

    /**
     * Send a request to create a jobRequestID
     * Parse through response body
     * Get jobRequestID
     */
    static void createJobRequestID(){
        given().
                queryParam("code",param).
                queryParam("job", job).
                queryParam("databaseServer", databaseServer).
                queryParam("database", database).
                queryParam("scopeOfWork", scopeOfWork).
                queryParam("systemDate", systemDate).
                queryParam("memoryInGbPlatform", memoryInGbPlatform).
                queryParam("cpuCoresPlatform", cpuCoresPlatform).
                queryParam("cpuCoresBatch", cpuCoresBatch).
                queryParam("imageTag", imageTag).
                when().get("/RequestJob").
                prettyPeek().
                then().
                statusCode(200);
    }

    /**
     * Monitor a Job
     */
    static void monitorJob() throws InterruptedException {
        Response response;
        String jobID = "";
        String batchContainerStatus = "";

        /**
         * Get jobRequestID
         * Send request until the job container is created
         */
        String jobName;
        do {
            response = given().
                    log().all().
                    queryParam("code", param).
                    when().get("/ListJobs").
                    then().statusCode(200).
                    extract().response();
            List<Map<String, String>> jsonResponse = response.jsonPath().getList("jobs");
            jobID = jsonResponse.get(jsonResponse.size() - 1).get("Name");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime today = LocalDateTime.now();
            jobName = job + "_" + dateFormat.format(today);
        } while (!jobID.startsWith(jobName));

        /**
         * monitorJob request
         */
        do{
            response = given().
                    log().all().
                    queryParam("code",param).
                    queryParam("jobRequestId", jobID).
                    when().get("/MonitorJob").
                    prettyPeek().
                    then().statusCode(200).
                    extract().response();
            batchContainerStatus = response.jsonPath().getString("batchContainerStatus");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("batchContainerStatus:::::::::: " + batchContainerStatus);
        }while(batchContainerStatus == null || !batchContainerStatus.equals("Terminated"));
        System.out.println("jobRequestId::::::" + jobID);

        /**
         * Capture Log request
         */
        given().
                log().all().
                queryParam("code",param).
                queryParam("jobRequestId", jobID).
                queryParam("subfolderPath", scopeOfWork).
                when().get("/CaptureLogs").
                prettyPeek().
                then().statusCode(200);

        /**
         * Delete the job container
         */
        given().
                log().all().
                queryParam("code",param).
                queryParam("jobRequestId", jobID).
                when().get("/DeleteJob").
                prettyPeek().
                then().statusCode(200);
    }
}
