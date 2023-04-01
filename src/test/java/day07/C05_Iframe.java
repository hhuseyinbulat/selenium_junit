package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Iframe extends TestBase {

    @Test
    public void iframeTest() {
        //Iframe nedir?
//https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String actualText = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));
//Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);

        String frameElementText = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedFrameElementText ="Applications lists";
        Assert.assertEquals(expectedFrameElementText,frameElementText);
//Son olarak footer daki 'Powered By' yazisini varligini test edilip
driver.switchTo().parentFrame();
String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();

        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
    /*
    How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
***Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
***driver.findElements(By.tagName(“iframe”));
***driver.findElements(By.xpath(“//iframe”));
————————————
Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
***2 farkli yol vardır.
***defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.
———————————-
What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
*** Oncelikle her ikiside framein disina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir
—————————————
What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
Iframe. Cozum : switch to iframe
Alert. Cozum : switch to alert
New window(Yeni pencere) : switch to window
     */
}
