package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDefinitions"})

public class WebDriverRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeMethod // This method will run before each Cucumber scenario
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod // This method will run after each Cucumber scenario
    public void cleanup() {
        driver.quit();
    }

}
