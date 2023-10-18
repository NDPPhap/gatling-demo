package petstore.actions;

// required for Gatling HTTP DSL
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ClickOnEnterTheStore {
    public HttpRequestActionBuilder executeAPI(){
        HttpRequestActionBuilder request = http("Open Category Page")
                .get("actions/Catalog.action")
                .check(status().is(200));
        return request;
    }
}
