package petstore.scenarios;

import io.gatling.javaapi.core.*;
import petstore.actions.ClickOnEnterTheStore;
import petstore.actions.ClickOnFishCategory;
import petstore.actions.OpenPetStorePage;

import static io.gatling.javaapi.core.CoreDsl.*;

public class OpenFishCategoryScenario {
    public ScenarioBuilder executeScenario(){
        OpenPetStorePage openPetStorePage = new OpenPetStorePage();
        ClickOnEnterTheStore openCategoryPage = new ClickOnEnterTheStore();
        ClickOnFishCategory openFishCategoryPage = new ClickOnFishCategory();
        ScenarioBuilder scn = scenario("Open Fish Category")
                .exec(openPetStorePage.executeAPI())
                .pause(1, 3)
                .exec(openCategoryPage.executeAPI())
                .pause(1, 3)
                .exec(openFishCategoryPage.executeAPI());
        return scn;
    }
}
