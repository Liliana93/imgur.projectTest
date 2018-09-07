Feature: UI testing

  //@UITest

  Scenario: Access youTube page
    Given user accesses the YouTube Page

  @UITest
  Scenario: Send a message
    Given user accesses the Login Page
    When user enters "valid login" and "valid password"
    And clicks on submit button
    Then user is logged in
    When user clicks on compose button
    And user enters the recipient "example@gmail.com"
    And user enters the subject "first message"
    And user enters the message "Hello!"
    And user clicks on compose button