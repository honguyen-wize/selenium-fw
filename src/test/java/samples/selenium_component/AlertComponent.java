package samples.selenium_component;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertComponent {

    @Test
    public void alertTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String name = "Ho Nguyen";
        String alertText = "";

        WebElement txtNameEL = driver.findElement(By.id("name"));
        WebElement btnAlertEl = driver.findElement(By.id("alertbtn"));
        WebElement btnConfirmEl = driver.findElement(By.id("confirmbtn"));

        // input name and open alert
        txtNameEL.sendKeys(name);
        btnAlertEl.click();
        Alert currentAlert = driver.switchTo().alert();

        // check Alert
        alertText = currentAlert.getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(name));
        currentAlert.accept();

        // Open and Dismiss Confirm Alert
        txtNameEL.sendKeys(name);
        btnConfirmEl.click();
        alertText = currentAlert.getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(name));
        currentAlert.dismiss();

    }

}
