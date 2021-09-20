package samples.selenium_action_windows_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowsComponent {

    @Test
    public void windowsTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        // open the child window
        driver.findElement(By.cssSelector(".blinkingText")).click();

        // get parent_id and child_id
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        //switch to child window
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        // extract email from the child window
        driver.findElement(By.cssSelector(".im-para.red")).getText();
        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        //switch to parent windows
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId); // set the extracted email to username field in the parent window
    }
}
