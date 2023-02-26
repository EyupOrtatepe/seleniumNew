package grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q4 extends TestBase {

    @Test
    public void test01(){

        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.

        iframeTest();

        //- Text Box’a “Merhaba Dunya!” yazin.

        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);

        WebElement textArea = driver.findElement(By.tagName("p"));
        textArea.clear();
        bekle(3);
        textArea.sendKeys("Merhaba Dunya!");
        bekle(3);

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.

        driver.switchTo().parentFrame();
        WebElement elementalElementi = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println("elementalElementi = " + elementalElementi.getText());
        Assert.assertTrue(elementalElementi.isDisplayed());


    }
    public String iframeTest(){
        WebElement yazi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(yazi.isDisplayed());
        String getYazi = yazi.getText();
        System.out.println(getYazi);


        return getYazi;
    }

}
