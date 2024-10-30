@Sanity
Feature: Admin Panel User Management

  Scenario Outline: Add, Verify, and Delete a User
    Given I am on the login page
    When I log in with username "<username>" and password "<password>"
    And I navigate to the Admin tab
    Then I note the initial record count
    When I add a new user with username "<employeeUsername>" and password "<employeePassword>"
    Then the record count should increase by 1
    When I search for "<employeeUsername>"
    And I delete the user
    Then the record count should decrease by 1

    Examples:
      | username | password |  employeePassword | employeeUsername |
      | Admin    | admin123 | Abdullah123       | Abdullah Mostafa |