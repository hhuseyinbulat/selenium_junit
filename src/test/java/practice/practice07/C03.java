package practice.practice07;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
/*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */
    //"https://demoqa.com/automation-practice-form"  Adresine gidin
    // Formu doldurunuz
    // Sayfayi kapatin

    @Test
    public void name() {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys(new Faker().name().firstName(), Keys.TAB, new Faker().name().lastName(),
                Keys.TAB,new Faker().internet().emailAddress(),
                Keys.TAB,Keys.SPACE, Keys.TAB, new Faker().phoneNumber().cellPhone(),
                Keys.TAB,"20 Jul 1990",Keys.ENTER,Keys.TAB,
                new Faker().lorem().sentence(),Keys.TAB,
                Keys.TAB,Keys.SPACE, Keys.TAB, Keys.TAB, Keys.TAB);
        WebElement fileUpload = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        String dosyaYolu =System.getProperty("user.home")+"\\OneDrive - hbv.edu.tr\\Masaüstü\\intellij_93550.ico";
        fileUpload.sendKeys(dosyaYolu);
 }

}
