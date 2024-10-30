package TestBases;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties = new Properties();
    public static SoftAssert softAssert = new SoftAssert();

    public TestBase() {
        try {
            File file = new File("src/test/resources/config.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void openWebSite(){
        driver.get(properties.getProperty("url"));
    }

    public static void  initiateBrowser(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void configureChromeBrowser() {
        driver = new ChromeDriver();
        initiateBrowser();
    }

    public static void configureFireFoxBrowser() {
        driver = new FirefoxDriver();
        initiateBrowser();
    }

}
