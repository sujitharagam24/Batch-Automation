package batchTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class MonitorCheck {
    /**
     *   1. Change the following scope name, Scope name and SystemDate
     *   2. Open configuration.properties file and make sure ssms_URL is 'jdbc:sqlserver://srv-array-sql01.database.windows.net;Database= + scopeOfWork'
     *   Ex: If you are running DW1, ssmsDB_url should be 'jdbc:sqlserver://srv-array-sql01.database.windows.net;Database=modPIMS-DW1'
     */
    private static String job = "NPP871_2022-01-26T21-21-34";
    private static final String param = "mDpmoOweKhS9lxz1iIlHAZx1MeFF9dZNVG5AQJSp308PIrgXTaleTw==";

    @BeforeAll
    public static void setup(){
       RestAssured.baseURI = "https://func-batch-containers.azurewebsites.net/api";
    }

    @Test
    public void monitorJobCheck(){
        given().
                log().all().
                queryParam("code", param).
                queryParam("jobRequestId", job).
                when().get("/MonitorJob").
                prettyPeek().
                then().statusCode(200).
                extract().response();
    }

}
