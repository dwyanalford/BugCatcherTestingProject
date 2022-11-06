
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

  Scenario: Edit Existing Case
    Given The tester is on the test case dashboard
    When The tester presses on details
    Then A test case modal should appear showing the case ID
    When The Tester clicks on edit within the modal
    Then The Tester should be on the case editor for that case
    Then The fields should be uneditable
    When The tester clicks on the edit button
    Then The test case fields should be editable
    When The tester types in a new description into the description text area
    When The tester types in a new steps into the steps text area
    When The tester clicks on the automated check mark
    When The tester selects ryeGuy for performed from drop down
    When The tester selects FAIL for test result from drop down
    When The tester types in a new summary into the summary text area
    When The tester clicks save on test case page
    Then A confirmation prompt should appear
    When The tester clicks on Ok
    Then An alert says the test case has been saved
    Then The fields should be uneditable

  Scenario: Reset Test Case
    Given The tester is on the test case dashboard
    When The tester presses on details
    Then A test case modal should appear showing the case ID
    When The Tester clicks on edit within the modal
    Then The fields should be uneditable
    Then The tester clicks on the edit button
    Then The test case fields should be editable
    When The tester types in a new description into the description text area
    When The tester types in a new steps into the steps text area
    When The tester clicks on the automated check mark
    When The tester selects ryeGuy for performed from drop down
    When The tester selects FAIL for test result from drop down
    When The tester types in a new summary into the summary text area
    When The tester clicks on the reset button
    Then The fields should be populated to their old values
    Then The fields should be uneditable