package batchTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class JobLists {
    private static final String param = "mDpmoOweKhS9lxz1iIlHAZx1MeFF9dZNVG5AQJSp308PIrgXTaleTw==";

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://func-batch-containers.azurewebsites.net/api";
    }

    @Test
    public void jobLists() {
        /**
         * Send JobList Request
         * Start deleting by given index. Ex: 2 --> 3rd container in the job list
         */
        given().
                log().all().
                queryParam("code", param).
                when().get("/ListJobs").
                prettyPeek().
                then().
                statusCode(200);
    }
}
