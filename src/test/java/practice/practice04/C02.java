package practice.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //        - https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();
        //        //    - youtube videosunu çalıştırınız
        WebElement youtube = driver.findElement(By.cssSelector("iframe[src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtube);
        driver.findElement(By.cssSelector("button[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        //        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();
        //        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //        //    - iphone aratınız
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ")[2];
        System.out.println("Sonuc: "+sonuc);
        //        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        System.out.println("İlkWindowUrl: "+driver.switchTo().window(ilkWindow).getCurrentUrl());
        //        //    - ilk sekmeyi kapatalım
        driver.close();
        //        //    - Sonra diğer sekmeyide kapatalım
    }
}
