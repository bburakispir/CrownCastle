package ui_automation.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitHelper {

    private static final Logger oLog = LogManager.getLogger(WaitHelper.class);

    public static void wait(int secs) {
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static boolean waitForTextVisibility(WebElement element, String text, int timeToWaitInSec) {
        oLog.info("Waiting For Text Visibility");
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

}
