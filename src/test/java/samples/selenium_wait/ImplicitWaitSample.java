package samples.selenium_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitSample {

    @Test
    public void implicitWait() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Add items to cart
        String[] itemsNeeded= {"Cucumber", "Beetroot"};
        addItems(driver,itemsNeeded);

        // open checkout page
        WebElement imgCart = driver.findElement(By.cssSelector("img[alt='Cart']"));
        WebElement btnCheckout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));

        imgCart.click();
        btnCheckout.click();

        // Place order
        WebElement txtPromotionCode = driver.findElement(By.cssSelector("input.promoCode"));
        WebElement btnApply = driver.findElement(By.cssSelector("button.promoBtn"));
        txtPromotionCode.sendKeys("honguyen");
        btnApply.click();

        //spanInfo needs about 4s to be visible => implicit wait of 5s => OK to find
        WebElement spanInfo = driver.findElement(By.cssSelector(".promoInfo"));
        System.out.println(spanInfo.getText());

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
