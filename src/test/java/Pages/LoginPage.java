package Pages;

import TestBases.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    public String username = "Admin";
    public String password = "admin123";

    @FindBy(name="username")
    public WebElement userNameField;
    @FindBy(name="password")
    public WebElement passWordField;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;

}
