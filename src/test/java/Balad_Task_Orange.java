import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Balad_Task_Orange {
    public static void main(String[] args) throws InterruptedException {
        // Set up the Chrome WebDriver and navigate to the login page of OrangeHRM
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

        // Login with the provided user credentials
        WebElement userName = driver.findElement(By.name("username"));
        WebElement passWord = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userName.sendKeys("Admin");
        passWord.sendKeys("admin123");
        loginButton.click();
        Thread.sleep(2000);


        // Create a new instance of the JavascriptExecutor interface
        // Scroll to the end of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        // Navigate to the Admin page in the side panel
        WebElement adminButton = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
        adminButton.click();


        // Click on the Add button to add a new user
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"));
        addButton.click();


        // Fill in the user details in the form fields and save the new user
        //roles
        WebElement roles = driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[1]"));
        roles.click();
        WebElement dropDownRoles = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + "Admin" + "')]"));
        dropDownRoles.click();

        // Status Selection
        WebElement status = driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//i)[2]"));
        status.click();
        WebElement selectStatus = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + "Enabled" + "')]"));
        selectStatus.click();

        // Employee
        WebElement name =driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        //Very Important note
        String inputName = "Manasa  A"; // could be disappear so try  another existing name and replace it
        name.sendKeys(inputName);
        Thread.sleep(2000);
        name.sendKeys(Keys.ARROW_DOWN);
        name.sendKeys(Keys.ENTER);


        // username
        WebElement inputUsername = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"));
        String inputUser = "Abdullah";
        inputUsername.sendKeys(inputUser);


        //password
        String requiredPW = "p1p1p1p1";
        WebElement inputPW = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        inputPW.sendKeys(requiredPW);
        WebElement confirmPW = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
        confirmPW.sendKeys(requiredPW);

        //save
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
        saveBtn.click();
        Thread.sleep(1000);


        //search for name
        WebElement searchName= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
        searchName.sendKeys(inputUser);
        WebElement searchBtn =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"));
        searchBtn.click();
        Thread.sleep(1000);


        WebElement deleteBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]"));
        deleteBtn.click();
        WebElement confirmDeletionBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
        confirmDeletionBtn.click();


        //Close Browser
        Thread.sleep(2000);
        driver.quit();
    }




}
