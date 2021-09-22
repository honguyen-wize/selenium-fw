package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class LoginPage {

    public WebDriver driver;

    By emailSelector = new By.ByCssSelector("#user_email");
    By passwordSelector = new By.ByCssSelector("#user_password");
    By loginButtonSelector = new By.ByCssSelector("[value='Log In']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getEmail(){
        return driver.findElement(emailSelector);
    }

    public WebElement getPass(){
        return driver.findElement(passwordSelector);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButtonSelector);
    }

}
