package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {
    public static void main(String[] args) throws InterruptedException {
        ///* ...Exercise4...
        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        //Click on  Calculater under Micro Apps
        //Type any number in the first input
        //Type any number in the second input
        //Click on Calculate
        //Get the result
        //Print the result
        //     */
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click();
        driver.findElement(By.id("number1")).sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("100");
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(5000);
        System.out.println("result  = " + driver.findElement(By.id("answer")).getText());
        driver.close();
    }
}
