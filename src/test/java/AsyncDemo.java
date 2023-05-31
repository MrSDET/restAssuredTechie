import org.asynchttpclient.Dsl;
import org.asynchttpclient.ListenableFuture;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutionException;


public class AsyncDemo {

    @Test
    void asyncDemo() throws ExecutionException, InterruptedException {

        ListenableFuture<Response> responseFuture = Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users?delay=5").execute();

        Response response=responseFuture.get();

        String responseBody = response.getResponseBody();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}
