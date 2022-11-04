package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import runners.WebDriverRunner;

public class MatrixSteps {
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() throws InterruptedException {
        WebDriverRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=8");
        Thread.sleep(1000);
        WebDriverRunner.loginPage.username.sendKeys("g8tor");
        WebDriverRunner.loginPage.password.sendKeys("chomp!");
        WebDriverRunner.loginPage.loginButton.click();
        System.out.println("Login Success for Manager");
    }

    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.tagName("button")).click();
    }

    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("//div/input")).sendKeys("New Matrix Title");
        System.out.println("Title added");
    }

    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("//tr/td[1]/input")).sendKeys("New Story");
        Select selectDropdown = new Select(WebDriverRunner.driver.findElement(By.xpath("//tr/td[2]/select")));
        selectDropdown.getFirstSelectedOption();
        WebDriverRunner.driver.findElement(By.xpath("//tr/td[3]/input")).sendKeys("Some Note");
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("//fieldset/button")).click();

    }

    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/button")).click();
        Thread.sleep(250);
        WebDriverRunner.driver.switchTo().alert().accept();
        System.out.println("Matrix successfully created");
    }

    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("//nav/a[1]")).click();
        Thread.sleep(250);
        Boolean isMatricesDisplayed = WebDriverRunner.driver.findElement(By.xpath("//ul")).isDisplayed();

        Assert.assertEquals(isMatricesDisplayed, true);

        System.out.println("Is Matrices displayed? ::  " +isMatricesDisplayed);

    }

    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() throws InterruptedException {
        Thread.sleep(250);
        // select matrices in the menu
        WebDriverRunner.driver.findElement(By.xpath("//nav/a[1]")).click();
        Thread.sleep(250);
        // select 'show' button
        WebDriverRunner.driver.findElement(By.xpath("(//div/ul/li[1]/div/span)/button")).click();
    }

    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() throws InterruptedException {
        Thread.sleep(250);
        // edit button
        WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/button")).click();
        Thread.sleep(250);
        // add new defect number
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[2]/li[last()]/input")).sendKeys("905");
        // add defect
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[2]/li[last()]/button")).click();
        Thread.sleep(250);
        // remove defect
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[2]/li[1]/button")).click();
    }

    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.findElement(By.xpath("//ul/li[1]/div/div/div/button")).click();
    }

    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() throws InterruptedException {
        Thread.sleep(250);
        WebDriverRunner.driver.switchTo().alert().accept();
        System.out.println("Matrix saved successfully");
    }

    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() throws InterruptedException {
        Thread.sleep(250);
        // add new test case number
        WebDriverRunner.driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/button")).click();
        Thread.sleep(250);
        // add new test case number
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]/input")).sendKeys("855");
        // hit add button
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]/button")).click();
        Thread.sleep(250);
        // remove test case id
        WebDriverRunner.driver.findElement(By.xpath("/html/body/div/ul/li[1]/div/div/div/ul[1]/li[1]/button")).click();

        System.out.println("Test case ID removed and added");
        Thread.sleep(250);
    }
}
