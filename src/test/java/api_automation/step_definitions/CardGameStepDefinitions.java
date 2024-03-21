package api_automation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class CardGameStepDefinitions {

    protected static final String BASE_URL = "https://deckofcardsapi.com/api/deck";
    Response response;
    String deckId;
    @Given("^I get a new deck$")
    public void iGetANewDeck() {

        response = RestAssured.get(BASE_URL+"/new/shuffle/?deck_count=1");
        response.prettyPrint();
        deckId = response.jsonPath().getString("deck_id");
        Assert.assertNotNull("Deck ID is null", deckId);
    }

    @When("^I shuffle the deck$")
    public void iShuffleTheDeck() {
        response= RestAssured.given().get(BASE_URL+"/" + deckId + "/shuffle/");
        Assert.assertEquals(200,response.statusCode());
        response.prettyPrint();
    }

    @When("^I deal three cards to each player$")
    public void iDealThreeCardsToEachPlayer() {
        response=RestAssured.given().get(BASE_URL+"/" + deckId + "/draw/?count=6");
        response.prettyPrint();


        }
    @Then("^I check for blackjack$")
    public void iCheckForBlackjack() {
        // Implement logic to check for blackjack based on the cards drawn
    }
    }


