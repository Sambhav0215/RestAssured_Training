package Day01;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HttpsRequest {

    int id;

    @Test(priority = 1)
    public void createUser(){



        Map<String,String> data = new HashMap<>();

        data.put("name","Henry Clark");
        data.put("role","Leader");

         id = given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")
                .contentType("application/json")
                .body(data)

        .when()
                .post("https://reqres.in/api/users")

        .then()
                .statusCode(201)
                .log().all()
                .extract()
                .jsonPath()
                .getInt("id");




    }

    @Test(priority = 2,dependsOnMethods = "createUser")
    public void updateUser(){

        Map<String,String> data = new HashMap<>();

        data.put("name","Matt Luckey");
        data.put("role","QA Lead");

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")
                .contentType("application/json")
                .body(data)
        .when()
                .put("https://reqres.in/api/users/"+id)

        .then()
                .statusCode(200)
                .log().all();


    }

    @Test(priority=3)
    public void deleteUser(){
        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                .when()
                .delete("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(204)
                .log().all();
    }

    @Test(priority=6)
    public void getUsers(){

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

        .when()
                .get("https://reqres.in/api/users")

        .then()
                .statusCode(200)
                .body("page",equalTo(1))
                .log().all();


    }




}
