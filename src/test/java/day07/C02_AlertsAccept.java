package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {
    @Test
    public void acceptAlertTest() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine git
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String sonuc = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert",sonuc);
        Thread.sleep(3000);
        //1.Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    }
}
