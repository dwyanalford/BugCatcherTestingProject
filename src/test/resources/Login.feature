
Feature: Login

  Scenario: Login Correct Username Wrong Password
    Given The employee is on the login page
    When The employee types in "g8tor" into the username input
    When The employee types in "chomp!8" into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying "they have the wrong password"

  Scenario: Login Wrong Username
    Given The employee is on the login page
    When The employee types in "sicEmDawgs" into the username input
    When The employee types in "natchamps" into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying "no user with that username found"

  Scenario Outline: Login with correct credentials
    Given The employee is on the login page
    When  The employee types in "<username>" into the username input
    When The employee types in "<password>" into the password input
    When The employee clicks on the login button
    Then the employee should be on the "<role>" page
    Then The employee should see their name "<fname>" "<lname>" on the home page

    Examples:
      | username   | password | role    | fname   | lname     |
      | g8tor      | chomp!   | Manager | Patty   | Pastiche  |
      | ryeGuy     | coolbeans| Tester  | Fakey   | McFakeFace|
      | cavalier89 | alucard  | Tester  | Dracula | Fangs     |