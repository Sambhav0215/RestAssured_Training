package Day03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class QueryAndPathParameters {

    @Test
    public void testQueryAndPathParameters(){

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")
                .pathParams("path","users")
                .queryParam("page",2)
                .queryParam("id",5)
                .when()
                .get("https://reqres.in/api/{path}")

                .then()
                .statusCode(200)
                .log().all();

    }


}
