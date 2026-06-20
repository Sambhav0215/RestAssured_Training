package Day06;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


public class SchemaValidator {

    @Test
    public void testSchemaValidator(){



            given()
                    .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                    .pathParams("paths","users")
                    .queryParam("page",2)

                    .when()
                    .get("https://reqres.in/api/{paths}")

                    .then()
                    .assertThat().body(
                            io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(
                                    new File("src/test/java/Day06/response.json")
                            ))
                    .log().all();
    }




}
