import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ProxyDemo {

    @Test
    void proxyDemo(){
        RestAssured.proxy("127.0.1",8888);

    }
}
