package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logins {

    @FindBy(name ="username")
    public WebElement username;

    @FindBy(name = "pass")
    public WebElement password;

    @FindBy(xpath="//button[text()='Login']")
    public WebElement loginButton;

    public static String loginURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=8";

    public static String testerUsername = "ryeGuy";

    public static String testerPassword = "coolbeans";

    public static String managerUsername = "g8tor";

    public static String managerPassword = "chomp!";

        public Logins(WebDriver driver) {
            // PageFactory: A feature of Selenium that reduces the need to use findElement by introducing the @FindBy annotation
            PageFactory.initElements(driver, this); // This will go and utilize the @FindBy annotations and get
            // the elements automatically for us
        }
}
