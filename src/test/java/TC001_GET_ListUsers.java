import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_ListUsers {

    @Test
    void listUsers(){
        //specify base uri
        RestAssured.baseURI="https://reqres.in/api";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET, "/users?page=2");

        //print response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //validate status code
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode,200);

        //validate status line
        String statusLine = response.getStatusLine();
        System.out.println("Status Line is: "+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

}
