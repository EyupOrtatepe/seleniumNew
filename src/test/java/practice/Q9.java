package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q9 {

    @BeforeClass
    public static void setup(){
        System.out.println("Before class");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("After Class");
    }
    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void ahmet(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("Ahmet");

    }
    @Test
    public void sahmet(){

        System.out.println("sAhmet");

    }
    @Test
    public void mahmet(){

        System.out.println("mAhmet");

    }



}
