package academy.tests;

import common.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
        public WebDriver driver;
        public static Logger logger = LogManager.getLogger(BaseTest.class.getName());
        String baseURL = resourceBundle.getString("base.url");

        @BeforeTest
        public void initialize(){
        driver = initializeDriver();
        logger.info("Driver is initialized");
    }

    @Test (dataProvider = "getData")
    public void checkCredential(String email, String password) {
        driver.get(baseURL);
        logger.info("Starting checking Credential");
        // land on the home page and click login button
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();

        // input credential
        logger.info("Input credential");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(email);
        loginPage.getPass().sendKeys(password);
        loginPage.getLoginButton().click();
        logger.info("Successfully check Credential");
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "abc@gmail.com";
        data[0][1] = "123456";
        data[1][0] = "honguyen@gmail.com";
        data[1][1] = "987654";

        return data;
    }

    @AfterTest
    public void teardown(){
        driver.close();
        logger.info("Close the driver");
    }
}
