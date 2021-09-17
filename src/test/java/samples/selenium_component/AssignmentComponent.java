package samples.selenium_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AssignmentComponent {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");

        String fromSearchText = "Sin";
        String fromFullText = "Singapore, SG - Seletar Airport (XSP)";
        String toSearchText = "Kul";
        String toFullText = "Kuala Lumpur, MY - Kuala Lumpur (KUL)";

        WebElement txtFromEl = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]"));
        WebElement txtToEl = driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]"));
        WebElement dpdDepartEL = driver.findElement(By.cssSelector(".homeCalender"));
        WebElement linkMoreOptionEl = driver.findElement(By.partialLinkText("Class of travel, Airline preference"));
        WebElement dpdTravelClass = driver.findElement(By.xpath("//*[text()='Class of travel']/following-sibling::select"));
        WebElement btnSeachFlights = driver.findElement(By.xpath("//button[text()='Search flights']"));

        // Input from and to text box
        txtFromEl.sendKeys(fromSearchText);
        Thread.sleep(2000);
        List<WebElement> fromOptions = driver.findElements(By.xpath("//*[text()='Suggestions']/following-sibling::li/p"));
        for(WebElement option: fromOptions){
            if(option.getText().equalsIgnoreCase(fromFullText)){
                option.click();
                break;
            }
        }

        txtToEl.sendKeys(toSearchText);
        Thread.sleep(2000);
        List<WebElement> toOptions = driver.findElements(By.xpath("//*[text()='Suggestions']/following-sibling::li/p"));
        for(WebElement option: toOptions){
            if(option.getText().equalsIgnoreCase(toFullText)){
                option.click();
                break;
            }
        }

        // Input Depart on
        dpdDepartEL.click();
        WebElement datePickerStartDay = driver.findElement(By.xpath("//*[contains(@class,'DayPicker-Day--start')]/following-sibling::*[1]"));
        datePickerStartDay.click();

        //Check link More Option
        linkMoreOptionEl.click();
        Select dpdSelectTravelClass = new Select(dpdTravelClass);
        dpdSelectTravelClass.deselectByVisibleText("Premium Economy");

        // Submit Search
        btnSeachFlights.click();
    }
}
