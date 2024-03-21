Feature: Card Game Automation

  Background:
    Given I get a new deck

  @CrownCastleCardGame
  Scenario: Verify Card Game Functionality
    When I shuffle the deck
    And I deal three cards to each player
    Then I check for blackjack