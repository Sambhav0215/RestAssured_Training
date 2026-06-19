package Day03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class QueryAndPathParameters {

    @Test
    public void testQueryAndPathParameters(){

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                .pathParams("paths","users")
                .queryParam("page",2)
                .queryParam("id",5)

                .when()
                .get("https://reqres.in/api/{paths}")

                .then()
                .statusCode(200)
                .body("data.id", equalTo(5))
                .log().all();
    }


}
