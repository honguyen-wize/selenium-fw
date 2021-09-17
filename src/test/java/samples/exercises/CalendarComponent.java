package samples.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarComponent {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

        //May 21
        String monthText = "May";
        String dayText = "21";

        // open the calendar
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

        // move to the right month
        while(!driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText().contains(monthText))
        {
            driver.findElement(By.cssSelector(".datepicker-days .next")).click();
        }

        // Select the right day
        List<WebElement> dates = driver.findElements(By.className("day"));
        for(int i = 0; i < dates.size(); i++)
        {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase(dayText))
            {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }

    }
}
