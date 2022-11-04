Feature: Test Cases

  Scenario: Add A Test Case
    Given The tester is on the test case dashboard
    When The tester types "My Test Case Description" into Description field
    When The tester types into steps field
    When The tester presses the submit button
    Then The test case should appear at the bottom of the table
    Then The test case result should say "UNEXECUTED"
    When The tester presses on details
    Then A test case modal should appear showing the case ID
    Then The performed by field should say "No One"
    When The tester presses the close button
    Then The Modal Should be closed

