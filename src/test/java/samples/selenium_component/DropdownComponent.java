package samples.selenium_component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropdownComponent {

    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //region Static dropdown

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //endregion


        //region Auto Select Dropdown

//        WebElement searchBox = driver.findElement(By.id("autosuggest"));
//        searchBox.sendKeys("Ind");
//
//        Thread.sleep(3000);
//
//        List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu-item']/a"));
//        String selectValue = "Indonesia";
//        for (WebElement option: options){
//            if(option.getText().equalsIgnoreCase(selectValue)){
//                option.click();
//                break;
//            }
//        }

        //endregion


    }



}
