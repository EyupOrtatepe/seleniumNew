package grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.List;

public class Q5 extends TestBaseClass {

    @Test
    public void test01(){
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@name='url']"));

        Select select = new Select(ddm);

        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //3- dropdown menude 40 eleman olduğunu doğrulayın

        int expected = 40;
        int actual = options.size();

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void test02(){
        //1- dropdown menuden elektronik bölümü seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@name='url']"));

        Select select = new Select(ddm);
        select.selectByVisibleText("Electronics");

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone" + Keys.ENTER);

        String sonuc = driver
                .findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                .getText();

        String [] parts = sonuc.split(" ");
        int sonucSayisi = Integer.parseInt(parts[3].replaceAll(",",""));
        System.out.println("Bulunan Sonuc Sayisi = " + sonucSayisi);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin

        String expected = "iphone";
        Assert.assertTrue(sonuc.contains(expected));

        //4- ikinci ürüne relative locater kullanarak tıklayin

        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='a-section a-spacing-base'][1]"));
        WebElement secondProduct = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(firstProduct));
        secondProduct.click();
        bekle(3);

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        String title = driver.getTitle();
        System.out.println("title = " + title);
        WebElement price = driver.findElement(By.xpath("//td[@class='a-span12']"));
        String fiyat = price.getText();
        System.out.println("price = " + price);

        
        driver.findElement(By.id("submit.add-to-cart")).click();
        bekle(3);

    }
}
