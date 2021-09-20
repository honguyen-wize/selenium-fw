package samples.selenium_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioComponent {

    @Test
    public void radioTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //region check Enable
        WebElement cb_roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        WebElement returnDateEl = driver.findElement(By.id("Div1"));
        String returnDateStype = returnDateEl.getAttribute("style");

        Boolean isReturnDateEnable = returnDateStype.contains("opacity: 1") ? true : false;
        Assert.assertFalse(isReturnDateEnable);

        cb_roundTrip.click();

        returnDateStype = returnDateEl.getAttribute("style");
        isReturnDateEnable = returnDateStype.contains("opacity: 1") ? true : false;
        Assert.assertTrue(isReturnDateEnable);
        //endregion

    }
}
