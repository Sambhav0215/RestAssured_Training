package Day04;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReponseValidate {

    // ##1 Using Matchers
    @Test
    public void testReponseValidate(){

        given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                .pathParams("paths","users")
                .queryParam("page",2)

                .when()
                .get("https://reqres.in/api/{paths}")

                .then()
                .statusCode(200)
                .body("support.text",equalTo("Become a better CTO. A playbook of painful stories and practical advice from a two-time startup CTO."))
                .log().all();
    }


    // ##1 Using TestNG Assertions
    @Test
    public void testReponseValidateByTestNG(){

        Response res  = given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                .pathParams("paths","users")
                .queryParam("page",2)

                .when()
                .get("https://reqres.in/api/{paths}");

        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getContentType(),"application/json; charset=utf-8");


    }



//  ##3 By using JSONObject
    @Test
    public void testReponseValidateBYJsonObj(){

        Response res = given()
                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")

                .pathParams("paths","users")
                .queryParam("page",2)

                .when()
                .get("https://reqres.in/api/{paths}");

        JSONObject jo = new JSONObject(res.asString());
        boolean status = false;
        for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
            String name = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();

            if(name.equals("Tobias") || name.equals("Lindsay")){
                status = true;
                break;
            }
        }

        Assert.assertEquals(status,true);


    }



}
