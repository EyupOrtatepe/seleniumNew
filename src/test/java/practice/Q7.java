package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q7 {

        //Automation Exercise Category Testi
        //1- Bir test class'i olusturun ilgili ayarlari yapin
        WebDriver driver;
    @Before

    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        //6- Sayfayi kapatin
        driver.close();
    }
    @Test
    public void test(){

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> listOfCategoryElements = driver.findElements(By.className("panel-title"));
        //4- Category bolumunde 3 element oldugunu test edin
        int expectedNumberOfCategoryElements = 3;
        int actualNumberOfCategoryElements = listOfCategoryElements.size();

        Assert.assertEquals(expectedNumberOfCategoryElements,actualNumberOfCategoryElements);
        //5- Category isimlerini yazdirin
        for (WebElement each : listOfCategoryElements) {
            System.out.println(each.getText());
        }

    }







}
