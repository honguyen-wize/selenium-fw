package samples.page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageFactoryDemo {
    private WebDriver driver;

    @FindBy(id = "user_email")
    private WebElement inputUsername;

    @FindBy(id = "user_password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[contains(@class,'btn-default')]")
    private WebElement btnLogin;

    @FindBy(className = "panel-body")
    private WebElement divLoginMessage;

    private void setWebDriver(){
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverMAC");// for MAC OS
        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverWindows.exe"); // for Windows OS
    }

    @BeforeMethod(alwaysRun = true)
    public void setupPage(){

        setWebDriver();

        driver = new ChromeDriver();
        driver.get("https://home.openweathermap.org/users/sign_in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(driver, this);
    }

    public void inputUsernamePassword(String username, String pass){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(pass);
    }

    public void login(){
        btnLogin.click();
    }

    public String getLoginMessage(){
        return divLoginMessage.getText();
    }

    @Test
    public void loginSuccessfully(){
        inputUsernamePassword("wizetest1@gmail.com", "autotest");
        login();
        Assert.assertEquals(getLoginMessage(),"Signed in successfully.");
    }

}
