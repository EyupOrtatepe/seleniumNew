package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q10 {
    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement searchBox ;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Before
    public void before(){
        driver.get("http://www.google.com");
    }
    @Test
    public void test01(){

       driver.findElement(By.xpath("//div[text()='Alles accepteren']")).click();
       searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
       searchBox.sendKeys("The Lord of the Rings"+ Keys.ENTER);

       WebElement result1 = driver.findElement(By.id("result-stats"));
       System.out.println("result1 = " + result1.getText());
    }
    @Test
    public void test02(){

        searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("Brave Heart"+ Keys.ENTER);

        WebElement result1 = driver.findElement(By.id("result-stats"));
        System.out.println("result1 = " + result1.getText());

    }
    @Test
    public void test03(){
        searchBox = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        searchBox.sendKeys("Harry Potters"+ Keys.ENTER);

        WebElement result1 = driver.findElement(By.id("result-stats"));
        System.out.println("result1 = " + result1.getText());
    }


}
