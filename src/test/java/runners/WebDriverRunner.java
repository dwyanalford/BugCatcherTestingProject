package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Logins;
import pages.Navigation;
import pages.TestersDashboard;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDefinitions"},
        tags = "")

    public class WebDriverRunner extends AbstractTestNGCucumberTests {
        public static WebDriver driver;
        public static TestersDashboard TestersDashboard;
        public static Navigation Navigation;
        public static Logins Logins;

    @BeforeMethod // This method will run before each Cucumber scenario
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        Logins = new Logins(driver);
        TestersDashboard = new TestersDashboard(driver);
        Navigation = new Navigation(driver);

    }

    @AfterMethod // This method will run after each Cucumber scenario
    public void cleanup() {
        driver.quit();
    }

}
