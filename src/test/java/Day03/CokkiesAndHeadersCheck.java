package Day03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CokkiesAndHeadersCheck {

    @Test
    public void testCookies(){

        given()

                .when()
                .get("https://google.com")
                .then()
                .cookie("AEC")

                .log().all();

    }

    @Test
    public void testHeaders(){

        given()

                .when()
                .get("https://google.com")
                .then()
                .header( "Content-Encoding","gzip")
                .and()
                .header("Server","gws")
                .log().headers();

    }
}
