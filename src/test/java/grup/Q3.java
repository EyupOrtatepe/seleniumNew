package grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q3 extends TestBase {

    @Test
    public void test01(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame']")));
        driver.findElement(By.xpath("//a[.='Our Products']")).click();

        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[.='Cameras']")).click();

        //4. Popup mesajini yazdirin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='modal-content']"))).getText());


        //5. “close” butonuna basin
        driver.findElement(By.xpath("//button[.='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[.='WebdriverUniversity.com (IFrame)']")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expected = "http://webdriveruniversity.com/index.html";
        String actual = driver.getCurrentUrl();
        bekle(5);

        Assert.assertEquals(expected,actual);
    }

}
