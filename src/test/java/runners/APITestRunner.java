package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty","html:target/cucumber",
                    "json:target/cucumber.json"},
            features = "src/test/resources/api_Features",
            glue = "api_automation.step_definitions",
            tags = "@CrownCastleCardGame",
            dryRun = false
    )
    public class APITestRunner {

    }

