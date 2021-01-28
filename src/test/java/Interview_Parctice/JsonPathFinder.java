package Interview_Parctice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;

public class JsonPathFinder {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://34.228.7.129:8000";
        basePath = "/api";
    }



    @AfterAll
    public static void tearDown(){
        reset();
    }
    @DisplayName("Extracting data out of spartan Json Object")
    @Test
    public void test1SpartanPayload(){
        // send a request to get one spartan
        // by providing path params with valid Id
        // save it into response object
        // NEW: Create an object method jsonPath() on response object
        // extract id, name, gender, phone
        // and save it into variable of correct type

        Response response = given()
                                    .auth().basic("admin", "admin")
                                    .pathParam("id", 12).
                            when()
                                    .get("/spartans/{id}")
                                    .prettyPeek()
                            ;
//        response.prettyPrint();
        JsonPath jp = response.jsonPath();
        int myId = jp.getInt("id");
        String name = jp.getString("name");
        String gender = jp.getString("gender");
        long phoneNumber = jp.getLong("phone");
        System.out.println("myId = " + myId);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phoneNumber = " + phoneNumber);
    }

    @DisplayName("Extracting data from Json Array response")
    @Test
    public void getAllSpartanExtractData(){
//        Response response = get("/spartans");
//        JsonPath jp = response.jsonPath();
          JsonPath jp = given().auth().basic("admin", "admin").get("/spartans").jsonPath();
          System.out.println(jp.getString("name[0]"));

        System.out.println("jp.getLong(\"phone[0]\") = "
                + jp.getLong("phone[0]"));

        System.out.println("jp.getString(\"gender[7]\") = "
                + jp.getString("gender[7]"));

        // getting the name field from the Json Array response
        // and saving it as a list
        // the json path for all names in json response is "name"
        List<String> allnames = jp.getList("name");
        for(String eachName : allnames){
            System.out.println(eachName);
        }

        List<Long> allPhones = jp.getList("phone");
        System.out.println("allPhones = " + allPhones);

    }

    @DisplayName("Testing /spartan/search and extracting data")
    @Test
    public void testSearch(){
        JsonPath jp = given()
                .auth().basic("admin", "admin")
                .queryParam("nameContains", "de")
                .queryParam("gender", "Male").
        when()
                .get("/spartans/search")
                .jsonPath()
        ;

        System.out.println("First Guy name: "
                            +jp.getString("content[0].name"));
        System.out.println("The Third guy name: "+
                jp.getString("content[1].name"));
        System.out.println("allNames "+jp.getList("content.name"));
        System.out.println("allPhone = " + jp.getList("content.phone"));
        System.out.println("value of field empty "+jp.getBoolean("pageable.sort.empty"));

    }
}
