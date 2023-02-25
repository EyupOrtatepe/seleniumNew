package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.id("ez-accept-all")).click();
        driver.navigate().refresh();
        //        fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("Sevil");
        //        fill the lastname
        driver.findElement(By.name("lastname")).sendKeys("Karan");
        //        check the gender
        driver.findElement(By.id("sex-1")).click();
        //        check the experience
        driver.findElement(By.id("exp-2")).click();
        //        fill the date
        driver.findElement(By.id("datepicker")).sendKeys("17.08.2022");
        //        choose your profession -> Automation Tester
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");
        driver.findElement(By.id("profession-1")).click();
        //        choose your tool -> Selenium Webdriver
        driver.findElement(By.id("tool-2")).click();
        //        choose your continent -> Antartica
        WebElement content= driver.findElement(By.id("continents"));
        Select kita=new Select(content);
        kita.selectByVisibleText("Antartica");
        //        choose your command  -> Browser Commands

        jse.executeScript("window.scrollBy(0,350)");
        WebElement browser= driver.findElement(By.id("selenium_commands"));
        new Select(browser).selectByVisibleText("Browser Commands");
        //        click submit button
        driver.findElement(By.id("submit")).click();
    }
}
