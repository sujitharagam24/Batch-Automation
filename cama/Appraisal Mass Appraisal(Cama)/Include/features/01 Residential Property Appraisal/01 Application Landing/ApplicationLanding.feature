Feature: Navigation - Menu - Links
As a user I want navigation links that will eventually take me to these areas.

Dashboard, 
Logout

Use the text as tooltips for the navigation buttons.

  Background: 
    Given I am a user of the system
    When I open URL to the main page


  Scenario: Dashboard Link
    Then I see the Dashboard link on the Navigation Bar


  Scenario: Logout link
    Then I see the Logout link on the Navigation Bar

