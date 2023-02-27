package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReuseableMethods {
    public static void tumSayfaSS(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String dinamikDosyaYolu = "target/tumSayfaSS"+ldt.format(dtf)+".png";

        File tumSayfaSS = new File(dinamikDosyaYolu);

        File geciciFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciFile,tumSayfaSS);
        } catch (IOException e) {

        }


    }
}
