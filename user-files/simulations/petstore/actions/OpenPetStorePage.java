package petstore.actions;

// required for Gatling HTTP DSL
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class OpenPetStorePage {
    public HttpRequestActionBuilder executeAPI() {
        HttpRequestActionBuilder request = http("Open Pet Store Page")
                .get("/")
                .check(status().is(200));
        return request;
    }
}
