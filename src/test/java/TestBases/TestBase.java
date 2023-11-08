package TestBases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

public class TestBase {
    protected static WebDriver driver;
    public static String Base_URL= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void initBrowser(){
        // Set up the Chrome WebDriver and navigate to the login page of OrangeHRM
        driver= new ChromeDriver();
        driver.navigate().to(Base_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
