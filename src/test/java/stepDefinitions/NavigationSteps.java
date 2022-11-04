package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import runners.WebDriverRunner;

public class NavigationSteps {
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        WebDriverRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=8");
        Thread.sleep(250);
        WebDriverRunner.loginPage.username.sendKeys("g8tor");
        WebDriverRunner.loginPage.password.sendKeys("chomp!");
        WebDriverRunner.loginPage.loginButton.click();
        System.out.println("Login Success");
    }

    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException {
        Thread.sleep(250);
        String managerPageURL = WebDriverRunner.driver.getCurrentUrl();
        Assert.assertEquals(managerPageURL, "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome");
        System.out.println("On Manager Page: " + managerPageURL);
    }

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        Boolean isNavThere = WebDriverRunner.driver.findElement(By.cssSelector("nav")).isDisplayed();
        Assert.assertEquals(isNavThere, true);
        System.out.println("Are Nav Displayed? :: " +isNavThere);
    }

    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        WebDriverRunner.driver.findElement(By.xpath("//div/nav/a[1]")).click();

    }

    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() throws InterruptedException {
        Thread.sleep(250);
        String pageTitle = WebDriverRunner.driver.getTitle();
        Assert.assertEquals(pageTitle, "Matrix Page");
    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        WebDriverRunner.driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() throws InterruptedException {
        Thread.sleep(250);
        String homeTitle = WebDriverRunner.driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(homeTitle, "Home");
        System.out.println("Actual :: " + homeTitle + ", Expected :: Home");
    }

    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        WebDriverRunner.driver.findElement(By.xpath("//div/nav/a[2]")).click();
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String managerLink) {
        WebDriverRunner.driver.findElement(By.linkText(managerLink)).click();
    }

    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String expectedPageTitle) {
       String actualPageTitle = WebDriverRunner.driver.findElement(By.xpath("//*[@id=\"root\"]/h1")).getText();
       Assert.assertEquals(actualPageTitle, expectedPageTitle);
        System.out.println("Actual :: " +actualPageTitle+ " Expected :: " +expectedPageTitle);
    }
}
