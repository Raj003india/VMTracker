Feature: Registration functionality
  @register
  Scenario: Register with invalid password
    Given enter page and check login
    When Enter only invalid password
    Then validate Error message for password

  @register
  Scenario: Register with invalid Email
    Given enter page and check login
    When Enter only invalid Email
    Then validate Error message for Email

    #bug login successfully with invalid phonenumber
  @register
  Scenario: Invalid phone_number
    Given enter page and check login
    When Enter only invalid phonenumber
    Then validate Error message for phonenumber

  @register
  Scenario: Enter existing  details
    Given enter page and check login
    When Enter existing  details validate error msg
    Then Validate_error

  @register
  Scenario: choose Russia country and register
    Given enter page and check login
    When Enter valid details and choose Russia country
    Then register the details successfully








