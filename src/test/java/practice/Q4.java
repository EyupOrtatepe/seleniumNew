package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    public static void main(String[] args) throws InterruptedException {
        ///* ...Exercise3...

        //    fill the firstname
        //    fill the lastname
        //    check the gender
        //    check the experience
        //    fill the date
        //    choose your profession -> Automation Tester
        //    choose your tool -> Selenium Webdriver
        //    choose your continent -> Antartica
        //    choose your command  -> Browser Commands
        //    click submit button
        // */
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();

        driver.navigate().refresh();

        //    fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ali");

        //    fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yilmaz");
        //    check the gender
        driver.findElement(By.xpath("//input[@name='sex']")).click();
        //    check the experience
        driver.findElement(By.xpath("//input[@value='5']")).click();
        //    fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("18-02-2023");
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");
        Thread.sleep(3000);
        //    choose your profession -> Automation Tester
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        //    choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //    choose your continent -> Antartica
        driver.findElement(By.xpath("//option[text()='Antartica']")).click();
        //    choose your command  -> Browser Commands
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        jse.executeScript("window.scrollBy(0,350)");
        //    click submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        //driver.findElement(By.id("submit")).click();




    }
}
