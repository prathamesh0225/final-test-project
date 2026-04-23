Feature: OpenCart Invoice
    Scenario: Invoice Generator
    Given user is on OpenCart login page
    When user enters username "demo"
    And user enters password "demo"
    And user clicks on login button
    Then user should see the dashboard
    Then user clicks orders in sales menu
    And user enter orderid "3419"
    And user clicks on filter button
    And user clicks action button
    And user clciks print invoice button 