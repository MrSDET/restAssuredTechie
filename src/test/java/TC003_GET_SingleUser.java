import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_SingleUser {

    @Test
    void singleUser(){
        //specify base uri
        RestAssured.baseURI="https://reqres.in/api";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET, "/users/12");

        //print response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        //capture headers
        String contentType = response.header("Content-Type");
        String reportTo=response.header("Report-To");
        String contentEncoding=response.header("Content-Encoding");
        String vary=response.header("Vary");
        String server=response.header("Server");

        System.out.println("content type is: "+contentType);
        System.out.println("content encoding is: "+contentEncoding);
        System.out.println("report to is: "+reportTo);
        System.out.println("vary is: "+vary);
        System.out.println("Server is: "+server);

        //validation
        Assert.assertEquals(contentType,"application/json; charset=utf-8");
        Assert.assertEquals(contentEncoding,"gzip");
        Assert.assertEquals(vary,"Accept-Encoding");
        Assert.assertEquals(server,"cloudflare");

    }
}
