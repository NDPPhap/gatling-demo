package petstore.simulations;

// required for Gatling core structure DSL
import io.gatling.javaapi.core.*;
import static io.gatling.javaapi.core.CoreDsl.*;

// required for Gatling HTTP DSL
import io.gatling.javaapi.http.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import petstore.scenarios.OpenFishCategoryScenario;

public class OpenFishCategorySimulation extends Simulation {
    HttpProtocolBuilder httpProtocol = 
    http.baseUrl("https://petstore.octoperf.com/")
    .inferHtmlResources()
    .nameInferredHtmlResourcesAfterPath();
    OpenFishCategoryScenario openFishCategoryScenario = new OpenFishCategoryScenario();
    ScenarioBuilder scn = openFishCategoryScenario.executeScenario();

    {
        setUp(scn.injectOpen(rampUsers(1).during(10)).protocols(httpProtocol));
    }
}