Feature: UI testing

  @UITest
  Scenario: Access youTube page
    Given user accesses the YouTube Page

    Scenario: Send a message
      Given user accesses the Login Page
      When user enters "valid login" and "valid password"
      And clicks on submit button