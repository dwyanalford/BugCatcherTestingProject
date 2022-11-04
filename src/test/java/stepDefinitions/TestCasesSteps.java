package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import runners.WebDriverRunner;

public class TestCasesSteps {
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        WebDriverRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=8");
        WebDriverRunner.loginPage.username.sendKeys("ryeGuy");
        WebDriverRunner.loginPage.password.sendKeys("coolbeans");
        WebDriverRunner.loginPage.loginButton.click();
        Thread.sleep(1200);
        WebDriverRunner.driver.findElement(By.xpath("//nav/a[2]")).click();
        System.out.println("Logged in as Tester and on Tester dashboard");

    }

    @When("The tester types {string} into Description field")
    public void the_tester_types_into_description_field(String testDescription) throws InterruptedException {
        Thread.sleep(1200);
        WebDriverRunner.driver.findElement(By.xpath("//textarea[@name=\"desc\"]")).sendKeys(testDescription);

    }

    @When("The tester types into steps field")
    public void the_tester_types_into_steps_field() throws InterruptedException {
        Thread.sleep(1200);
        WebDriverRunner.driver.findElement(By.xpath("//textarea[@name=\"steps\"]")).sendKeys(
                "1. My Test Case Step One  2. My Test Case Step Two.");


    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        WebDriverRunner.driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(1200);

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
        Thread.sleep(1200);
        WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[last()]/td[4]")).click();
    }

    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() throws InterruptedException {
        // get text of case ID field and show text
        Thread.sleep(1200);
        Boolean caseInfo = WebDriverRunner.driver.findElement(By.xpath("//div[@role=\"dialog\"]/h3")).isDisplayed();
        Assert.assertEquals(caseInfo, true);
        System.out.println("Is Case ID displayed? :: " +caseInfo);
    }

    @Then("The performed by field should say {string}")
    public void the_performed_by_field_should_say_no_one(String expectedPerformedBy) {
        // get text of performed by field and show text
        String actualPerformedBy = WebDriverRunner.driver.findElement(By.xpath("//div[@role=\"dialog\"]/p[last()]")).getText();
        Assert.assertEquals(actualPerformedBy, expectedPerformedBy);
        System.out.println("actual text: " + actualPerformedBy + "  expected text: " +expectedPerformedBy);

    }

    @When("The tester presses the close button")
    public void the_tester_presses_the_close_button() {
        WebDriverRunner.driver.findElement(By.xpath("//div[@role=\"dialog\"]/button")).click();
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() throws InterruptedException {
        Thread.sleep(1500);
        // if the Tester dashboard is active again we should be able to select an element on the page, if so, then the modal must be closed.
        Boolean isTesterDashboardActiveAgain = WebDriverRunner.driver.findElement(By.cssSelector("h1")).isDisplayed();
        Assert.assertEquals(isTesterDashboardActiveAgain, true);
        System.out.println("Is Modal closed? :: " + isTesterDashboardActiveAgain);
    }
}
