package ui_automation.step_definitions;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ui_automation.utilities.BrowserFactory;
import ui_automation.utilities.Driver;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver=null;

        @Before
        public void setUp(Scenario scenario) {
            driver= BrowserFactory.createInstance();
            Driver.getInstance().setDriver(driver);
            driver = Driver.getInstance().getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        @After
        public void tearDown(Scenario scenario) {
            if (scenario.isFailed()) {
                try {
                    final byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png", scenario.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Driver.getInstance().removeDriver();

        }
    }

