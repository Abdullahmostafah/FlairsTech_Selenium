package Pages;

import TestBases.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends TestBase {
    public AdminPage() {
        PageFactory.initElements(driver,this);
    }

    public String employeeName = "a";
    public String userName = "AbdullahMOstafaaa"; // Change it later
    public  String requiredPW = "p1p1p1p1";

    @FindBy (xpath = "//*[text()='Admin']")
    public WebElement adminButton;

    @FindBy(xpath = "//*[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    public WebElement roles;

    @FindBy(xpath = "//*[text()='ESS']")
    public WebElement dropDownRoles;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active']//i)[2]")
    public WebElement status;

    @FindBy(xpath = "//*[text()='Enabled']")
    public WebElement selectStatus;

    @FindBy(xpath = "//*[@placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    public WebElement PWField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    public WebElement confirmPWField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveBtn;

}
