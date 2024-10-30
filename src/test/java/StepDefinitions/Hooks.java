package StepDefinitions;

import TestBases.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestBase {

    @Before
    public void launchBrowser() {

        switch (properties.getProperty("browser")) {
            case "chrome" -> {
                configureChromeBrowser();
            }
            case "firefox" -> {
                configureFireFoxBrowser();
            }
            default -> throw new IllegalArgumentException("Browser not supported: " + properties.getProperty("browser"));
        }
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }}

}
