package practice.practice07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {
    /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void name() {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement tuval = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tuval).clickAndHold();
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);

        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,-5);

        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);

        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,5);

        }
        actions.release().build().perform();
        driver.findElement(By.xpath("//button[text()='Clear']")).click();
    }
}
