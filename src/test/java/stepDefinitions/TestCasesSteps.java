package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import runners.WebDriverRunner;

import static pages.Logins.*;

public class TestCasesSteps {
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        WebDriverRunner.driver.get(loginURL);
        WebDriverRunner.Logins.username.sendKeys(testerUsername);
        WebDriverRunner.Logins.password.sendKeys(testerPassword);
        WebDriverRunner.Logins.loginButton.click();
        Thread.sleep(100);
        WebDriverRunner.Navigation.TestCases.click();
        System.out.println("Logged in as Tester and on Tester dashboard");
    }

    @When("The tester types {string} into Description field")
    public void the_tester_types_into_description_field(String testDescription) throws InterruptedException {
        Thread.sleep(100);
        WebDriverRunner.driver.findElement(By.xpath("//textarea[@name=\"desc\"]")).sendKeys(testDescription);

    }

    @When("The tester types into steps field")
    public void the_tester_types_into_steps_field() throws InterruptedException {
        Thread.sleep(100);
        WebDriverRunner.driver.findElement(By.xpath("//textarea[@name=\"steps\"]")).sendKeys(
                "1. My Test Case Step One  2. My Test Case Step Two.");


    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        WebDriverRunner.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(100);

    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        String actualTestDescription = WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
        Assert.assertEquals(actualTestDescription, "My Test Case Description");
        System.out.println("actual text:: " + actualTestDescription + " expected text:: My Test Case Description");

    }

    @Then("The test case result should say {string}")
    public void the_test_case_result_should_say(String expectedResultText) {
        String actualResultText = WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[last()]/td[3]")).getText();
        Assert.assertEquals(actualResultText, expectedResultText);
        System.out.println("actual text:: " + actualResultText + " expected text:: " +expectedResultText);
    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details() throws InterruptedException {
        Thread.sleep(100);
        WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[last()]/td[4]")).click();
        System.out.println("presses on details");
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() throws InterruptedException {
        // get text of case ID field and show text
        Thread.sleep(100);
        Boolean caseInfo = WebDriverRunner.driver.switchTo().activeElement().isDisplayed();
        Assert.assertEquals(caseInfo, true);
        System.out.println("Is Case ID displayed? :: " +caseInfo);

    }

    @Then("The performed by field should say {string}")
    public void the_performed_by_field_should_say_no_one(String expectedPerformedBy) {
        // get text of performed by field and show text
        String actualPerformedBy = WebDriverRunner.driver.findElement(By.xpath("//div[@role='dialog']/p[last()]")).getText();
        Assert.assertEquals(actualPerformedBy, expectedPerformedBy);
        System.out.println("actual text: " + actualPerformedBy + "  expected text: " +expectedPerformedBy);

    }

    @When("The tester presses the close button")
    public void the_tester_presses_the_close_button() {
        WebDriverRunner.driver.findElement(By.xpath("//div[@role='dialog']/button")).click();
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() throws InterruptedException {
        Thread.sleep(100);
        // if the Tester dashboard is active again we should be able to select an element on the page, if so, then the modal must be closed.
        Boolean isTesterDashboardActiveAgain = WebDriverRunner.driver.findElement(By.cssSelector("h1")).isDisplayed();
        Assert.assertEquals(isTesterDashboardActiveAgain, true);
        System.out.println("Is Modal closed? :: " + isTesterDashboardActiveAgain);
    }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        WebDriverRunner.driver.findElement(By.xpath("//div[@role='dialog']/button/a")).click();

    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        Boolean isCaseWindowOpened = WebDriverRunner.driver.switchTo().activeElement().isDisplayed();
        Assert.assertEquals(isCaseWindowOpened, true);
        System.out.println("Did Case window open? :: " + isCaseWindowOpened);
    }

    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() throws InterruptedException {
        //check to see if textarea is disabled, if yes then fields are uneditable
        Thread.sleep(100);
        Boolean isTextAreaEnabled = WebDriverRunner.driver.findElement(By.xpath("//fieldset[1]/textarea[1]")).isEnabled();
        Assert.assertEquals(isTextAreaEnabled, false);

        System.out.println("Is textarea enabled: " + isTextAreaEnabled + "  expected :: false");

    }

    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        WebDriverRunner.driver.findElement(By.cssSelector("button")).click();
    }

    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() throws InterruptedException {
        Thread.sleep(100);
        Boolean isTextAreaEnabled = WebDriverRunner.driver.findElement(By.xpath("//fieldset[1]/textarea[1]")).isEnabled();
        Assert.assertEquals(isTextAreaEnabled, true);

        System.out.println("Is textarea now enabled: " + isTextAreaEnabled + "  expected :: true");

    }

    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        WebDriverRunner.TestersDashboard.testDescriptionInput.sendKeys(
                "This is a new description for this test case");
    }

    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        WebDriverRunner.TestersDashboard.testStepsInput.sendKeys(
                "This is a new step for this case"
        );
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        WebDriverRunner.TestersDashboard.testAutomatedCheckbox.click();
    }

    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        WebDriverRunner.TestersDashboard.testPerformedByDropDown.click();
        WebDriverRunner.TestersDashboard.testPerformedByRyeGuy.click();
    }

    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        WebDriverRunner.TestersDashboard.testResultDropdown.click();
        WebDriverRunner.TestersDashboard.testFailSelection.click();

    }

    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        WebDriverRunner.TestersDashboard.testSummaryInput.sendKeys(
                "Here is a new Summary for this test case"
        );
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        WebDriverRunner.TestersDashboard.testCaseSaveButton.click();

    }

    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() throws InterruptedException {
        Thread.sleep(100);

        //if we can get text from alert, then the alert is there
        String alertText = WebDriverRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Are you sure you want to update the test case?");

        System.out.println(alertText);

    }

    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() throws InterruptedException {
        Thread.sleep(100);
        WebDriverRunner.driver.switchTo().alert().accept();

    }

    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() throws InterruptedException {
        Thread.sleep(100);
        String alertSavedMessage = WebDriverRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alertSavedMessage, "Test Case has been Saved");
        WebDriverRunner.driver.switchTo().alert().accept();
        System.out.println("actual :: " + alertSavedMessage + "expected :: Test case has been Saved");
    }

    @When("The tester clicks on the reset button")
    public static void the_tester_clicks_on_the_reset_button() {
        String x = WebDriverRunner.TestersDashboard.testDescriptionInput.getText();
        WebDriverRunner.TestersDashboard.testCaseResetButton.click();
        System.out.println("value of x is:: " + x);
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        System.out.println("This will be a manual test");
    }
}


