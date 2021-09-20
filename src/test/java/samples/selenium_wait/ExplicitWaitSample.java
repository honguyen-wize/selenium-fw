package samples.selenium_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ExplicitWaitSample {

    @Test
    public void explicitWaitTest() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Add items to cart
        String[] itemsNeeded= {"Cucumber", "Beetroot"};
        addItems(driver,itemsNeeded);

        // open checkout page
        WebElement imgCart = driver.findElement(By.cssSelector("img[alt='Cart']"));
        WebElement btnCheckout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));

        imgCart.click();
        btnCheckout.click();
        Thread.sleep(2000);

        // Place order
        WebElement txtPromotionCode = driver.findElement(By.cssSelector("input.promoCode"));
        WebElement btnApply = driver.findElement(By.cssSelector("button.promoBtn"));
        txtPromotionCode.sendKeys("honguyen");
        btnApply.click();

        // promoInfo wait for âbout 4s to display => explicit wait of 5s => OK to find
        WebElement spanInfoEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        System.out.println(spanInfoEl.getText());





    }

    public static  void addItems(WebDriver driver, String[] itemsNeeded)
    {
        int j=0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0;i<products.size();i++)
        {
            String[] name = products.get(i).getText().split("-");
            String formattedName=name[0].trim();
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formattedName))
            {
                j++;
                //click on Add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemsNeeded.length)
                {
                    break;
                }
            }
        }

    }
}
