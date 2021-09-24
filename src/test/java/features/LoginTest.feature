# new feature
# Tags: optional

Feature: Login Test

  Scenario Outline: Login successfully
    Given Initialize the browser
    And Navigate to "https://qaclickacademy.com/" site
    And Click on Login link in the home page and land on Secure sign in page
    When User enters "<username>" and "<password>" and logs in
    Then Verify the user is successfully login

    Examples:
    |username             |password   |
    |test@gmail.com       |123456     |
    |honguyen@gmail.com   |111222     |