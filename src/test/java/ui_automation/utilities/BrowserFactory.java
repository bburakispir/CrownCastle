package ui_automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {
        public static WebDriver createInstance() {

            WebDriver driver = null;
            try {

                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return driver;
        }
    }