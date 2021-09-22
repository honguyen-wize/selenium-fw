package academy.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import common.BaseTest;
import pages.LandingPage;

public class HomePageTest extends BaseTest {
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseTest.class.getName());
    String baseURL = resourceBundle.getString("base.url");

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        logger.info("Driver is initialized");
    }

    @Test
    public void checkLandingPage() throws InterruptedException {
        driver.get(baseURL);
        logger.info("Starting checking LandingPage");
        // land on the home page and click login button
        LandingPage landingPage = new LandingPage(driver);
        System.out.println(landingPage.getPagetitle());
        Assert.assertTrue(landingPage.getPagetitle().contains("Academy"));

        logger.info("Successfully check Landing Page");
    }

    @Test
    public void checkLandingPageFailed() throws InterruptedException {
        driver.get(baseURL);
        logger.info("Starting checking LandingPage");
        // land on the home page and click login button
        LandingPage landingPage = new LandingPage(driver);
        System.out.println(landingPage.getPagetitle());
        Assert.assertTrue(landingPage.getPagetitle().contains("Academy123456"));

        logger.info("Successfully check Landing Page");
    }

    @AfterTest
    public void teardown(){
        driver.close();
        logger.info("Close the driver");
    }

}
