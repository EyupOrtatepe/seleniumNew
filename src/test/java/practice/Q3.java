package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    public static void main(String[] args)  {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //    Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //    Under the ORIGINAL CONTENTS
        //    click on Alerts
        driver.findElement(By.id("alerts")).click();

        //    print the URL
        System.out.println("CurrentUrl = " + driver.getCurrentUrl());

        //    navigate back
        driver.navigate().back();

        //    print the URL
        System.out.println("CurrentUrl = " + driver.getCurrentUrl());

        //    Click on Basic Ajax
        driver.findElement(By.xpath("//*[text()='Basic Ajax']")).click();

        //    print the URL
        System.out.println("CurrentUrl = " + driver.getCurrentUrl());

        //    enter value 20 and ENTER
        driver.findElement(By.cssSelector("input[onblur='checkGT30(this.value)']")).sendKeys("20"+ Keys.ENTER);


        //    and then verify Submitted Values is displayed open page
        WebElement submittedValuesElement = driver.findElement(By.xpath("//*[text()='Submitted Values']"));

        if(submittedValuesElement.isDisplayed()){
            System.out.println("Display test PASSED");
        } else{
            System.out.println("Display test FAILED");
        }

        //    close driver
        driver.close();



    }


}
