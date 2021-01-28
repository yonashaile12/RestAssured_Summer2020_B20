package Interview_Parctice;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class GitHubRestAPI {

    @DisplayName("Test GitHu GET /users/{username}")
    @Test
    public void testGitHub(){
       given()
               .pathParam("username", "yonashaile12").
        when()
                .get("https://api.github.com/users/{username}").
        then()
               .assertThat()
               .statusCode(is(200) )
               .contentType(ContentType.JSON)
               .header("server", "GitHub.com")
               .body("login", is("yonashaile12"))
               ;

    }
}
