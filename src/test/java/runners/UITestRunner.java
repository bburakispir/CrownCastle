package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty","html:target/cucumber",
            "json:target/cucumber.json"},
            features = "src/test/resources/ui_Features",
            glue = "ui_automation.step_definitions",
            tags = "@CrownCastleCheckerGame",
            dryRun = false
    )
    public class UITestRunner {

    }
