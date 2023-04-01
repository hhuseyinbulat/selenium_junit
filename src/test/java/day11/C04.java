package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04 extends TestBase {
    @Test
    public void name() {
        //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driverGet("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[.='b10 all test cases, code.docx']")).click();
        waitFor(3);
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String userHome = System.getProperty("user.home");
        String dosyaYolu = userHome+"\\Downloads\\b10 all test cases, code.docx";
        boolean indirildiMi = Files.exists(Paths.get(dosyaYolu));
    }
}
