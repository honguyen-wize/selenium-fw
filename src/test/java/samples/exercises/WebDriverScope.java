package samples.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WebDriverScope {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // count all links in foo
        WebElement footerEl = driver.findElement(By.id("gf-BIG"));
        int linkNo = footerEl.findElements(By.tagName("a")).size();
        System.out.println(linkNo);

        //open new tabs by clicking links in the 1st column
        WebElement firstFooterColEl = footerEl.findElement(By.xpath("//table//tr/td[1]/ul"));
        List<WebElement> links1stFooterCol = firstFooterColEl.findElements(By.tagName("a"));
        for(int i = 1; i < links1stFooterCol.size(); i++){
            String clickLinkTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
            links1stFooterCol.get(i).sendKeys(clickLinkTab);
        }

        // switch to opened tabs
        Set<String> windowHandlers = driver.getWindowHandles();
        Iterator<String> it = windowHandlers.iterator();
        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

//        // count all links in the 1st column
//        List<WebElement> allLinksEls = footerEl.findElements(By.tagName("a"));
//        for (WebElement link : allLinksEls){
//            System.out.println(link.getText());
//        }
    }
}
