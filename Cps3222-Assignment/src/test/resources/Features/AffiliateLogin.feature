Feature: Affiliate Login
  Scenario: Successful Affiliate Login
    Given I am an affiliate trying to log in
    When I login using valid credentials
    Then I should be taken to my account admin page

  Scenario: Unsuccessful Affiliate Login
    Given I am an affiliate trying to log in
    When I login using invalid credentials
    Then I should see an error message
    And I should remain on the login page
