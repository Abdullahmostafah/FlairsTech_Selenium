package Pages;

import TestBases.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPage extends TestBase {

    public String initialTextFieldCounter;
    public Integer initialCount = null;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//span[text()='Admin']")
    public WebElement adminButton;

    @FindBy (className = "orangehrm-horizontal-padding")
    public WebElement recordsCountTextField;

    @FindBy(xpath = "//*[text()=' Add ']")
    public WebElement addButton;

    // User Management Page
    @FindBy(xpath = "(//div/div/div[@class='oxd-select-text-input'])[1]")
    public WebElement roles;

    @FindBy(xpath = "//div[contains(text(),'Admin')]    ")
    public WebElement dropDownRoles;


    @FindBy(xpath = "(//div/div/div[@class='oxd-select-text-input'])[2]")
    public WebElement status;

    @FindBy(xpath = "//*[text()='Enabled']")
    public WebElement selectStatus;

    @FindBy(xpath = "//*[@placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement usernameField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement PWField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPWField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBtn;

    // Admin Page
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement searchName;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBtn;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement deleteBtn;

    @FindBy(xpath = "//*[text()=' Yes, Delete ']")
    public WebElement confirmDeletionBtn;


    public void searchEmployeeHint(String characterToSearch) throws InterruptedException {
        employeeNameField.sendKeys(characterToSearch);
        Thread.sleep(1500);
        employeeNameField.sendKeys(Keys.DOWN);
        employeeNameField.sendKeys(Keys.ENTER);
    }

    public Integer getRecordsCount(String textToExtract){
        // Extract the number using regex
        initialCount =  extractNumber(textToExtract);
        if (initialCount != null) {
            System.out.println("The number of records found is: " + initialCount);
        } else {
            System.out.println("No number found in the text: " + null);
        }
        return initialCount;
    }

    private Integer extractNumber(String textToExtract) {
        // Regular expression to find the number in the text
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(textToExtract);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1)); // Return the first found number
        }
        return null; // Return null if no number is found
    }}