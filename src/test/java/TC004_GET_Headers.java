import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_GET_Headers {

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

        //capture all headers
        Headers allheaders = response.headers();

        for (Header header:allheaders){
            System.out.println(header.getName()+"     :"+header.getValue());
        }
    }
}
