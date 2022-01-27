package batchTests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Utilities.DBUtility;

import static io.restassured.RestAssured.given;
public class TestScope {
    /**
     * The following 3 variables should be updated depending on each job and scope
     * Job needs to run by order
     * Scope needs to static
     * System dates should be updated depending on each job
     */
    private static String job = "";
    private static String scopeOfWork = "";
    private static String systemDate = "";
    private static String path = "DW2";
    /**
     * The following variables are final (don't need to change)
     */
    private static final String param = "mDpmoOweKhS9lxz1iIlHAZx1MeFF9dZNVG5AQJSp308PIrgXTaleTw==";
    private static final String databaseServer = "srv-array-sql01";
    private static final String database = "modPIMS-"+scopeOfWork;
    private static final int memoryInGbPlatform = 4;
    private static final int cpuCoresPlatform = 2;
    private static final int cpuCoresBatch = 1;
    private static final String imageTag = "Cobol";

    /**
     * Connect to the Database
     * Run SQL before each job run
     */

    public static void main(String[] args) throws InterruptedException {
        String line = "";
        try(BufferedReader read = new BufferedReader(new FileReader("src/test/resources/"+path+".csv"))){
            while ((line = read.readLine()) != null) {
                String[] jobs = line.split(",");
                scopeOfWork = jobs[0];
                job = jobs[1];
                systemDate = jobs[2];
                //if(DBUtility.)

                String sql = "delete from NP.NPTTABL1 where TABL_ID = 'SYSDTE';\n" +
                        "insert into NP.NPTTABL1 (TABL_ID, TABL_SEQ, TABL_DATA, TABL_POST_KEY, TABL_POST_USERID) values ('SYSDTE', '', '" + systemDate + "', sysDateTime(), '');";
                DBUtility.establishConnection();
                DBUtility.runSQLQuery(sql);

                RestAssured.baseURI = "https://func-batch-containers.azurewebsites.net/api";

                createJobRequestID();
                monitorJob();
                DBUtility.closeConnections();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Hello Function
     */

    public static void helloFunction(){
        given().
                queryParam("code",param).
                when().get("/HelloFunction").
                then().statusCode(200);
    }

    /**
     * Send a request to create a jobRequestID
     * Parse through response body
     * Get jobRequestID
     */
    public static void createJobRequestID(){
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
    public static void monitorJob() throws InterruptedException {
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
        do {
            response = given().
                    log().all().
                    queryParam("code", param).
                    queryParam("jobRequestId", jobID).
                    when().get("/MonitorJob").
                    prettyPeek().
                    then().statusCode(200).
                    extract().response();
            batchContainerStatus = response.jsonPath().getString("batchContainerStatus");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("batchContainerStatus:::::::::: " + batchContainerStatus);
        } while (batchContainerStatus == null || !batchContainerStatus.equals("Terminated"));
        System.out.println("jobRequestId::::::" + jobID);

        /**
         * Capture Log request
         */

        given().
                log().all().
                queryParam("code", param).
                queryParam("jobRequestId", jobID).
                queryParam("subfolderPath", scopeOfWork).
                when().get("/CaptureLogs").
                prettyPeek().
                then().statusCode(200);

        /**
         * Delete the job container
         */
        Thread.sleep(2);
        given().
                log().all().
                queryParam("code", param).
                queryParam("jobRequestId", jobID).
                when().get("/DeleteJob").
                prettyPeek().
                then().statusCode(200);

        /**
         * Closing DB connection
         */
        DBUtility.closeConnections();
    }
}
