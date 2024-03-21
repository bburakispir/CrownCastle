Feature: Checkers Game Automation

Background:
  Given I navigate to "https://www.gamesforthebrain.com/game/checkers/"

  @CrownCastleCheckerGame
  Scenario: Verify Checkers Game Functionality
    Then the site is up
    When I make five legal moves as orange
    And I restart the game
    Then the game restarts successfully