package samples.selenium_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxComponent {
    @Test
    public void check() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //region Checkbox
        int expectedCheckboxNumber = 6;
        WebElement seniorCitizenDiscountCheckbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        Assert.assertFalse(seniorCitizenDiscountCheckbox.isSelected());
        seniorCitizenDiscountCheckbox.click();
        Assert.assertTrue(seniorCitizenDiscountCheckbox.isSelected(),"The checkbox should be selected");

        Assert.assertEquals(allCheckboxes.size() , expectedCheckboxNumber ,"The number of checkbox is not correct.");
        //endregion

        Thread.sleep(1000);
        driver.quit();

    }
}
