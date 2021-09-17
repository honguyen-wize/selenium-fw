package samples.java_stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TableFilter {
    public static void main(String[] arg) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String itemToSearch = "erry";

        // input Rice into Search box
        driver.findElement(By.id("search-field")).sendKeys(itemToSearch);

        // get items in the table
        List<WebElement> actualTableItems=driver.findElements(By.xpath("//tr/td[1]"));

        // filter item name containing itemToSearch
        List<WebElement> filteredList= actualTableItems.stream().filter(veggie->veggie.getText().contains(itemToSearch)).
                collect(Collectors.toList());

        Assert.assertEquals(actualTableItems.size(), filteredList.size());
    }
}
