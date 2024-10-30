package StepDefinitions;

import Pages.AdminPage;
import Pages.LoginPage;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends TestBase {
    LoginPage loginPage;
    AdminPage adminPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        openWebSite();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in(String username, String password) {
        loginPage.performingLogging(username, password);
    }

    @And("I navigate to the Admin tab")
    public void i_navigate_to_the_admin_tab() {
        adminPage.adminButton.click();
    }

    @Then("I note the initial record count")
    public void i_note_the_initial_record_cont(){
        adminPage.initialTextFieldCounter = adminPage.recordsCountTextField.getText();
        adminPage.getRecordsCount(adminPage.initialTextFieldCounter);
    }}