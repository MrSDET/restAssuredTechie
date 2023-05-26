import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC007_GET_Authentication {

    @Test
    void authentication(){

        RestAssured.baseURI="https://reqres.in";

        //authentication
        PreemptiveBasicAuthScheme basicAuthScheme=new PreemptiveBasicAuthScheme();
        basicAuthScheme.setUserName("eve.holt@reqres.in");
        basicAuthScheme.setPassword("pistol");

        RestAssured.authentication=basicAuthScheme;

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "eve.holt@reqres.in");
        requestParams.put("password", "pistol");
        //content type
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/api/register");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}
