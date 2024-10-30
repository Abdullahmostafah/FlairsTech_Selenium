package StepDefinitions;

import Pages.AdminPage;
import TestBases.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Optional;

public class AdminPanelSteps extends TestBase {
    AdminPage adminPage;
    Integer recordsAfterCreation;
    Integer expectedCountAfterCreation;
    Integer recordsAfterDeletion;
    Integer expectedCountAfterDeletion;

    @When("I add a new user with username {string} and password {string}")
    public void i_add_a_new_user(String employeeUsername, String employeePassword) throws InterruptedException {
        adminPage = new AdminPage();
        adminPage.addButton.click();
        adminPage.searchEmployeeHint("a");
        adminPage.usernameField .sendKeys(employeeUsername);
        adminPage.PWField.sendKeys(employeePassword);
        adminPage.confirmPWField.sendKeys(employeePassword);
        adminPage.status.click();
        adminPage.selectStatus.click();
        adminPage.roles.click();
        adminPage.roles.sendKeys(Keys.DOWN);
        adminPage.roles.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        adminPage.dropDownRoles.click();
        adminPage.saveBtn.click();
    }

    @Then("the record count should increase by 1")
    public void the_record_count_should_increase_by_1(){
        String recordsAfterCreationText = adminPage.recordsCountTextField.getText();
        recordsAfterCreation = adminPage.getRecordsCount(recordsAfterCreationText);
        expectedCountAfterCreation = adminPage.initialCount ;
        softAssert.assertEquals(recordsAfterCreation, expectedCountAfterCreation, "username is not added");
        softAssert.assertAll();
    }

    @When("I search for {string}")
    public void i_search_for_user(String employeeUsername) throws InterruptedException {
        Thread.sleep(1000);
        adminPage.searchName.sendKeys(employeeUsername);
        adminPage.searchBtn.click();
    }

    @And("I delete the user")
    public void i_delete_the_user(){
        adminPage.deleteBtn.click();
        adminPage.confirmDeletionBtn.click();
    }

    @Then("the record count should decrease by 1")
    public void the_record_count_should_decrease_by_1() throws InterruptedException {
        String recordsAfterDeletionText = adminPage.recordsCountTextField.getText();
        recordsAfterDeletion = adminPage.getRecordsCount(recordsAfterDeletionText);
        expectedCountAfterDeletion = expectedCountAfterCreation;
        softAssert.assertEquals(recordsAfterCreation, expectedCountAfterCreation, "No Records found");
        softAssert.assertAll();
    }
}

