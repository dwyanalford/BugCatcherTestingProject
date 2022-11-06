package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation {

    // Navigation Links

    @FindBy(xpath = "//div/nav/a[1]")
    public WebElement Matrices;

    @FindBy(xpath = "//div/nav/a[2]")
    public WebElement TestCases;

    @FindBy(xpath = "//div/nav/a[3]")
    public WebElement ReportADefect;

    @FindBy(xpath = "//div/nav/a[4]")
    public WebElement DefectOverview;

    @FindBy(xpath = "//div/nav/a[5]")
    public WebElement Logout;

    @FindBy(xpath = "//div/nav/a[6]")
    public WebElement Home;

    public Navigation(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
