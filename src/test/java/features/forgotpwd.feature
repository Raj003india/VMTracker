Feature: ForgotPassword functionality



  #error message not visible clearly
  @forgot
  Scenario: forgot pwd without Emailid
    Given enter page and click forgotpwd
    When click forgotpwd link and without emailid
    Then validate the Error

 #error message not visible clearly
  @forgot
  Scenario: Successful login
    Given enter page and click forgotpwd
    When click forgotpwd link and withinvalid emailid
    Then Validate the Error Message

  @forgot
  Scenario: Successful sent request for changepwd
    Given enter page and click forgotpwd
    When click another window and get name of that window
    Then check the Email id details and close that particular window