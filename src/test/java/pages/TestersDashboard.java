package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestersDashboard {

    @FindBy(xpath = "//fieldset[1]/textarea[1]")
    public WebElement testDescriptionInput;

    @FindBy(xpath = "//fieldset[1]/textarea[2]")
    public WebElement testStepsInput;

    @FindBy(xpath = "//fieldset[1]/input[1]")
    public WebElement testAutomatedCheckbox;

    @FindBy(xpath = "//fieldset[1]/select")
    public WebElement testPerformedByDropDown;

    @FindBy(xpath = "//fieldset[1]/select/option[2]")
    public WebElement testPerformedByRyeGuy;

    @FindBy(xpath = "//fieldset[2]/select")
    public WebElement testResultDropdown;

    @FindBy(xpath = "//fieldset[2]/select/option[2]")
    public WebElement testFailSelection;

    @FindBy(xpath = "//fieldset[2]/textarea")
    public WebElement testSummaryInput;

    @FindBy(xpath = "//button[2]")
    public WebElement testCaseSaveButton;

    @FindBy(xpath = "//button[1]")
    public WebElement testCaseResetButton;

    public TestersDashboard(WebDriver driver) {
        // PageFactory: A feature of Selenium that reduces the need to use findElement by introducing the @FindBy annotation
        PageFactory.initElements(driver, this); // This will go and utilize the @FindBy annotations and get
        // the elements automatically for us
    }


}
