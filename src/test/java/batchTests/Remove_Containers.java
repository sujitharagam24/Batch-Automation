package batchTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Remove_Containers {
    /**
     * Be careful running this code. It will remove the containers!!!!
     */

    private static final String param = "mDpmoOweKhS9lxz1iIlHAZx1MeFF9dZNVG5AQJSp308PIrgXTaleTw==";

    @BeforeAll
    public static void setup(){
                RestAssured.baseURI = "https://func-batch-containers.azurewebsites.net/api";
    }

    @Test
    public void deleteContainerByIndex(){
        Response response;
        String jobID = "";
        int index = 6;

        /**
         * Send JobList Request
         * Start deleting by given index. Ex: 2 --> 3rd container in the job list
         */
            response = given().
                    log().all().
                    queryParam("code", param).
                    when().get("/ListJobs").
                    then().statusCode(200).
                    extract().response();
            List<Map<String, String>> jsonResponse = response.jsonPath().getList("jobs");
            jobID = jsonResponse.get(index).get("Name");
            System.out.println(jobID);

        /**
         * Delete
         */

        if(!jobID.equals("sbc-email") || !jobID.equals("sbc-ftp")){
            given().
                    log().all().
                    queryParam("code", param).
                    queryParam("jobRequestId", jobID).
                    when().get("/DeleteJob").
                    prettyPeek().
                    then().statusCode(200);
            System.out.println(jobID + " --> has been deleted");
        }else{
            System.out.println("Please, make sure index number!!!");
        }

    }

    @Test
    public void deleteContainerByName(){
        String jobID = "NPP888_2022-01-26T20-36-14";

        /**
         * Delete
         */

        if(!jobID.equals("sbc-email") || !jobID.equals("sbc-ftp")){
            given().
                    log().all().
                    queryParam("code", param).
                    queryParam("jobRequestId", jobID).
                    when().get("/DeleteJob").
                    prettyPeek().
                    then().statusCode(200);
            System.out.println(jobID + " --> has been deleted");
        }else{
            System.out.println("Please, make sure index number!!!");
        }

    }

}
