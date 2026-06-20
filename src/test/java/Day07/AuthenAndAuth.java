package Day07;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthenAndAuth {
    @Test
    public void testBasicAuth(){

        given()
                .auth().basic("postman","password")
//                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }

    @Test
    public void testDigestAuth(){

        given()
                .auth().digest("postman","password")
//                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }


    @Test
    public void testPreemtiveAuth(){

        given()
                .auth().preemptive().basic("postman","password")
//                .header("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }


    @Test
    public void testApiKeyAuth(){

        given()
                .queryParam("x-api-key","free_user_3EL4FeP7G9SNVZlTS3D8roEauh9")


                .when()
                .get("https://reqres.in/api/users")

                .then()
                .log().all();

    }



    @Test(enabled = false)
    public void testBearerTokenAuth(){   // this method will not work now because we dont have any bearer token now.. this is only for notes purpose

        given()
                .header("Authorization","Bearer hjhdgd42g2GD#")   // like this we can implement bearer token by using header


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }




    @Test(enabled = false)
    public void testOAuth1(){   // this method will not work now because we don't have any Oauth token now.. this is only for notes purpose

        given()
                .auth().oauth("ConsumerKey","ConsumerSecrat","accesstoken","tokenSecrat")


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }


    @Test(enabled = false)
    public void testOAuth2(){   // this method will not work now because we don't have any OAuth2 token now.. this is only for notes purpose

        given()
                .auth().oauth2("hjhdgd42g2GDgtdrthdtrtKUYI54215Khh")   // like this we can implement bearer token by using header


                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()

                .log().all();


    }





}
