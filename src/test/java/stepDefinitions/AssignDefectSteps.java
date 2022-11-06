package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import runners.WebDriverRunner;

import static pages.Logins.testerPassword;
import static pages.Logins.testerUsername;

public class AssignDefectSteps {
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() throws InterruptedException {
        Boolean isPendingDefectsVisible = WebDriverRunner.driver.findElement(By.xpath("//*[@id=\"root\"]/table")).isDisplayed();
        Thread.sleep(100);
        Assert.assertEquals(isPendingDefectsVisible, true);

        System.out.println("actual:: " + isPendingDefectsVisible + " expected:: true");
    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[last()]/td/button")).click();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        String h4CssValue = WebDriverRunner.driver.findElement(By.cssSelector("h4")).getCssValue("font-weight");
        Assert.assertEquals(h4CssValue, "700");
        System.out.println(h4CssValue);
    }

    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        WebDriverRunner.driver.findElement(By.xpath("//input[@list='employees']")).sendKeys("ryeGuy");

        System.out.println("keys sent");
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        WebDriverRunner.driver.findElement(By.xpath("//button[contains(text(),'Assign')]")).click();
        System.out.println("assigned clicked");
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list()  {
        Boolean isDefectDisplayed = WebDriverRunner.driver.findElements(By.cssSelector("h4")).isEmpty();
        Assert.assertEquals(isDefectDisplayed, false);

        System.out.println("is Defect displayed? :: " + isDefectDisplayed + "  expected:: false");
    }

    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page()  {
        WebDriverRunner.Navigation.Logout.click();
        WebDriverRunner.Logins.username.sendKeys(testerUsername);
        WebDriverRunner.Logins.password.sendKeys(testerPassword);
        WebDriverRunner.Logins.loginButton.click();

        System.out.println("Logged in as Tester");
    }

    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        System.out.println("tester sees the pending effect == MANUAL TEST");
    }
}
