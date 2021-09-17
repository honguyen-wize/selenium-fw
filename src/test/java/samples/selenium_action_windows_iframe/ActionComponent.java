package samples.selenium_action_windows_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionComponent {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);

        WebElement txtSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement lnkNavAccount = driver.findElement(By.id("nav-link-accountList"));

        actions.moveToElement(txtSearchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        actions.moveToElement(lnkNavAccount).contextClick().build().perform();
    }

}
