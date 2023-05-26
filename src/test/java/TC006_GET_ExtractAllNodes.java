import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.Map;

public class TC006_GET_ExtractAllNodes {

    @Test
    void extractAllNodes(){
        //specify base uri
        RestAssured.baseURI="https://reqres.in/api";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET, "/users/12");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: "+responseBody);

        JsonPath jsonpath=response.jsonPath();
        String id=jsonpath.get("id");
        String email = jsonpath.get("email");
        String firstname = jsonpath.get("first_name");
        String lastname = jsonpath.get("last_name");
        String avatar = jsonpath.get("avatar");
        System.out.println(id);
        System.out.println(email);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(avatar);

        Map<Object, Object> map = jsonpath.getMap("support");

        for(Object m:map.keySet()){
            System.out.println(m);
        }

        for(Object v:map.values()){
            System.out.println(v);
        }
    }
}
