Feature: Login functionality

  @login
  Scenario: login correct password
    Given enter page and click login
    When enter valid username and password
    Then click login and check message

  @login
  Scenario: login-with incorrect password
    Given enter page and click login
    When enter valid username and without password
    Then click login and check pwd Error message
  @login
  Scenario: login-without username and password
    Given enter page and click login
    When ignore username and password
    Then click login and check username and pwd Error message

