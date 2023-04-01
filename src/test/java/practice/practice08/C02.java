package practice.practice08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void name() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        String dosyaYolu = System.getProperty("user.home")+"\\OneDrive - hbv.edu.tr\\Masaüstü\\intellij_93550.ico";
        dosyaSec.sendKeys(dosyaYolu);
        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click();
        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        assert driver.findElement(By.xpath("//div[@class='formbuttons']//h3[@id='res']//center")).isDisplayed();

    }
}
