package day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;
import static org.hamcrest.CoreMatchers.is;

public class Test1 {

    @BeforeAll
    public static void SpartansTest(){
        RestAssured.baseURI = "http://52.201.244.7:8000";
        RestAssured.basePath = "/api";
    }

    @Test
    public void negativePathParamTest(){
        given()
                .auth().basic("admin", "admin")
                .accept(ContentType.JSON)
                .pathParam("id", 23)
                .log().all().
        when()
                .get("/spartans/{id}").
        then()
                .assertThat()
                .statusCode(is(200))
                .contentType(ContentType.JSON)
        ;
    }

    @AfterAll
    public static void tearDown(){
        reset();
    }

}
