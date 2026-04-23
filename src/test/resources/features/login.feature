Feature: ParaBank Login Functionality

  Background:
    Given user is on the ParaBank login page "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC"

  Scenario Outline: Login with multiple credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then login should be "<result>"

  Examples:
    | username | password | result |
    | john | demo | success |
    | invalid |  | failure |
    |  | demo | failure |
    |  |  | failure |
