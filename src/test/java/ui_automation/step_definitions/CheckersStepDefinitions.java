package ui_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui_automation.pages.CheckersPage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.WaitHelper;

import static org.junit.Assert.assertTrue;

public class CheckersStepDefinitions {

    CheckersPage checkersPage = new CheckersPage();

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) {
        Driver.getInstance().getDriver().get(url);
    }

    @Then("^the site is up$")
    public void theSiteIsUp() {
        assertTrue(Driver.getInstance().getDriver().getTitle().contains("Checkers"));
    }

    @When("^I make five legal moves as orange$")
    public void iMakeFiveLegalMovesAsOrange() {
        int[][] clickOrange = {{6,2}, {4,2},{0,2},{2,2},{1,1}};
        int[][] destinationOrange ={{7,3},{5,3},{1,3},{3,3},{3,3}};
        for (int i = 0; i < 5; i++) {
                checkersPage.clickSquare(clickOrange[i][0], clickOrange[i][1]);
                checkersPage.clickSquare(destinationOrange[i][0], destinationOrange[i][1]);
                WaitHelper.wait(2);
                checkersPage.waitForMakeAMoveText();
            }
        }


    @When("^I restart the game$")
    public void iRestartTheGame() {
        checkersPage.clickRestartButton();
    }

    @Then("^the game restarts successfully$")
    public void theGameRestartsSuccessfully() {
        assertTrue(checkersPage.isGameBoardDisplayed());
    }
}
