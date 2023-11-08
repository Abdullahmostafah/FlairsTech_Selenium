package TestCases;

import Pages.AdminPage;
import Pages.LoginPage;
import Pages.SearchPage;
import TestBases.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BaladTaskOrange extends TestBase {

    LoginPage login;
    AdminPage admin;
    SearchPage search;

    @Test
    public void performMyTest() throws InterruptedException {
        // Login with the provided credentials
        login = new LoginPage();
        login.userNameField.sendKeys(login.username);
        login.passWordField.sendKeys(login.password);
        login.loginButton.click();

        // Scroll to the end of the page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Navigate to the Admin page in the side panel
        admin = new AdminPage();
        admin.adminButton.click();

        // Add a new user
        admin.addButton.click();
        admin.roles.click();
        admin.dropDownRoles.click();
        admin.status.click();
        admin.selectStatus.click();
        admin.employeeNameField.sendKeys(admin.employeeName);
        Thread.sleep(2000);
        admin.employeeNameField.sendKeys(Keys.ARROW_DOWN);
        admin.employeeNameField.sendKeys(Keys.ENTER);
        admin.usernameField.sendKeys(admin.userName);
        admin.PWField.sendKeys(admin.requiredPW);
        admin.confirmPWField.sendKeys(admin.requiredPW);
        admin.saveBtn.click();

        //Delete a user
        search = new SearchPage();
        search.searchName.sendKeys(admin.userName);
        search.searchBtn.click();
        search.deleteBtn.click();
        search.confirmDeletionBtn.click();

    }

}
