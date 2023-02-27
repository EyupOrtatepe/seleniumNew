package day09_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_javascriptExecutorClick extends TestBase {
    @Test
    public void test01(){


        driver.get("https:///www.wisequarter.com");

        driver.navigate().refresh();

        WebElement otomasyonElementi = driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);
        bekle(2);

        jse.executeScript("arguments[0].click();",otomasyonElementi);
        bekle(2);
        jse.executeScript("alert('yasasinnnn');");
        bekle(2);




    }



}
