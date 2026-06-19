package Day02;

//import com.fasterxml.jackson.databind.util.JSONPObject;
import groovy.json.JsonToken;
import org.testng.annotations.Test;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


// ##1 By using Hashmap Collection
public class DiffPostPayload {

    int id;

    @Test(priority = 1)
    public void createUserByHashMap(){

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

//  ##2 By Using org.JSON package
    @Test(priority = 2)
    public void createUser(){


        JSONObject data = new JSONObject();

        data.put("name","John Doe");
        data.put("role","QA");

        id = given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")
                .contentType("application/json")
                .body(data.toString())

                .when()
                .post("https://reqres.in/api/users")

                .then()
                .statusCode(201)
                .log().all()
                .extract()
                .jsonPath()
                .getInt("id");



    }


    @Test(priority = 3)
    public void createUserByExternalJSONFile() throws FileNotFoundException {

        File data = new File("src/main/java/org/example/data.json");



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






}
