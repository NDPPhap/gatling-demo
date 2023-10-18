package petstore.actions;

// required for Gatling HTTP DSL
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class ClickOnFishCategory {
    public HttpRequestActionBuilder executeAPI(){
        HttpRequestActionBuilder request = http("Open Fish Category Page")
                .get("/actions/Catalog.action?viewCategory=&categoryId=FISH")
                .check(status().is(200));
        return request;
    }
}