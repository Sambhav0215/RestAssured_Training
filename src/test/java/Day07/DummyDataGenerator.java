package Day07;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DummyDataGenerator {

    @Test
    public void testDummyData(){

        Map<String,String> data = new HashMap<>();

        Faker faker =  new Faker();


        data.put("name",faker.name().fullName());
        data.put("role",faker.job().title());

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all();

    }

}
