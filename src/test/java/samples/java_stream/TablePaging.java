package samples.java_stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class TablePaging {
    public static void main(String[] arg) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");


        String itemName = "Carrot";
        List<String> price;
        WebElement nextEl = driver.findElement(By.cssSelector("a[aria-label='Next']"));

        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            //get price of itemName
            price = rows.stream().filter(s -> s.getText().equalsIgnoreCase(itemName))
                    .map(s -> getPrice(s)).collect(Collectors.toList());

            if(price.size() < 1) // not found
            {
                nextEl.click();
            } else {
                System.out.println("Price of " + itemName + ": " + price.get(0));
            }

        } while (price.size() < 1);

    }

    private static String getPrice(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::*[1]")).getText();
        return priceValue;
    }
}
