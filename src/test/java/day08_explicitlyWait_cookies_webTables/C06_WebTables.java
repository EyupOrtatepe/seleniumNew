package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01(){
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> headers = driver.findElements(By.xpath("//div[@class='rt-thead -header']"));
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

        //  3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunHeader = driver.findElement(By.xpath("//div[text()='Last Name']"));
        System.out.println("3.sutunun basligini = " + ucuncuSutunHeader.getText());
        
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        for (WebElement tumDatalar : tumData) {
            System.out.println(tumDatalar.getText());
        }
        
        
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> cellList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        int cellSayisi=1;
        String hiclik = "";
        for (WebElement cell : cellList) {
            if(!cell.getText().equals(hiclik)){
                cellSayisi++;
            }
        }
        System.out.println("bos olmayan cell (data) sayisi : "+ cellSayisi);

        List<WebElement> eachData = driver.findElements(By.xpath("//div[@class='rt-tr -odd']/div"));
        List<WebElement> eachData1 = driver.findElements(By.xpath("//div[@class='rt-tr -even']/div"));
        int doluCell=eachData.size()+eachData1.size();
        System.out.println("Dolu Hucre Sayisi =" + doluCell);

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi = " + satirList.size());


        //  7. Tablodaki sutun sayisini yazdirin
        int sutunSayisi= headers.size();
        System.out.println("sutunSayisi = " + sutunSayisi);

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucunkuKolonElements = driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div[3]"));
        for (WebElement ucunkuKolonElement : ucunkuKolonElements) {
            System.out.println("ucunkuKolonElementleri = " + ucunkuKolonElement.getText());
        }

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement salaryKierra = driver.findElement(By.xpath("((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[5]"));
        System.out.println("Kierra nin salary si = " + salaryKierra.getText());

        System.out.println("Kierra's Salary= "+driver.findElement(By.xpath("//div[@class='rt-tr-group'][3]/div/div[5]")).getText());
        

        // 10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde

        //     bana datayi yazdirsin

        System.out.println(dataYazdir(2, 4));


    }
    public String dataYazdir (int satirNo, int sutunNo){

        String xpathData = "//div[@class='rt-tr-group'][" + satirNo + "]/div/div["+ sutunNo +"]";

        String istenilenData = driver.findElement(By.xpath(xpathData)).getText();

        return istenilenData;
    }
}
