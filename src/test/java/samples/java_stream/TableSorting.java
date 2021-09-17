package samples.java_stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TableSorting {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click to sort in the UI
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // get sorted elements in the UI
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // get the sorted list using java code
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare sorted list in UI vs sorted list in code
        Assert.assertTrue(originalList.equals(sortedList));
    }

}
