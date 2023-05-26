import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Create {

    @Test
    void create() {
        //specify base uri
        RestAssured.baseURI = "https://reqres.in/api";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Request Payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Navnath");
        requestParams.put("job", "Automation Test Engineer");
        //content type
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST, "/users");

        //print response
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //validate status code
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is: "+statusCode);
        Assert.assertEquals(statusCode,201);

        String jobParam = response.jsonPath().get("job");
        System.out.println("Job Param from Response is: "+jobParam);
        Assert.assertEquals(jobParam,"Automation Test Engineer");
    }
}
