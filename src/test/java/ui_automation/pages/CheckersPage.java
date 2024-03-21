package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;
import ui_automation.utilities.WaitHelper;


public class CheckersPage {

    public CheckersPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }

    @FindBy(id = "message")
    private WebElement message;
    @FindBy(linkText = "Restart...")
    private WebElement restartButton;
    @FindBy(id = "board")
    private WebElement gameBoard;


    public void clickSquare(int row, int col) {
        String squareName = "space" + row + col;
        WebElement square = gameBoard.findElement(By.name(squareName));
        square.click();
    }

    public void clickRestartButton() {restartButton.click();}

    public boolean waitForMakeAMoveText() {
            return WaitHelper.waitForTextVisibility(message,"Make a move.",30);
    }

    public boolean isGameBoardDisplayed() {return gameBoard.isDisplayed();}

    }

