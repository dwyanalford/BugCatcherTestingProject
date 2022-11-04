package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import runners.WebDriverRunner;

import java.net.Socket;

public class LoginSteps {

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() throws InterruptedException {
        WebDriverRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=8");
        Thread.sleep(250);
    }

    @When("The employee types in {string} into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input(String username) {
        System.out.println("enters the username: " + username);
        WebDriverRunner.loginPage.username.sendKeys(username);
    }

    @When("The employee types in {string} into the password input")
    public void the_employee_types_in_chomp_into_the_password_input(String password) {
        System.out.println("enters the password: " + password);
        WebDriverRunner.loginPage.password.sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() throws InterruptedException {
        System.out.println("user clicked on the button");
        WebDriverRunner.loginPage.loginButton.click();
        Thread.sleep(250);
    }
    @Then("The employee should see an alert saying {string}")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password(String expectedAlertMessage) {
        String actualAlertMessage = WebDriverRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage );
        System.out.println("actual:: " + actualAlertMessage + "  expected: " + expectedAlertMessage);
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String role) throws InterruptedException {
        Thread.sleep(250);
        String wordInTitle = WebDriverRunner.driver.findElement(By.cssSelector("h1")).getText().split(" ")[0];

        Assert.assertEquals(wordInTitle, role);
        System.out.println("actual:: " + wordInTitle + "  Expected:: " + role );
    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String fname, String lname) {
        String employeeName = WebDriverRunner.driver.findElement(By.xpath("//nav/p")).getText();

        Assert.assertEquals(employeeName, "Welcome " +fname+ " " +lname);
        System.out.println("Actual:: " + employeeName + "  Expected:: " + fname + " " + lname);
    }
}
