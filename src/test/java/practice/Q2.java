package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    ///* ...Exercise2...
    // 1 - Driver olusturalim
    // 2 - Java class'imiza chromedriver.exe'yi tanitalim
    // 3 - Driver'in tum ekrani kaplamasini saglayalim
    // 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
    //     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
    // 5 - "https://www.otto.de" adresine gidelim
    // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
    // 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
    // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
    // 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
    //     kontrol edelim
    // 10- Bir onceki web sayfamiza geri donelim
    // 11- Sayfayi yenileyelim
    // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
    // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
    //     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        driver.get("https://www.otto.de");

        String ottoURL = driver.getCurrentUrl();
        System.out.println("ottoURL = " + ottoURL);
        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);

        if(ottoTitle.contains("OTTO")&& ottoURL.contains("otto")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.navigate().to("https://wisequarter.com/");

        String wqTitle = driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);

        boolean isTrue = wqTitle.contains("Quarter");

        if(isTrue){
            System.out.println("Tst PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();


        driver.close();
        driver.quit();




    }
}
