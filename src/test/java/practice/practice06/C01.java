package practice.practice06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01 extends TestBase {
    @Test
    public void name() {
        //// 1- https://www.amazon.com sayfasına gidin
        driverGet("https://www.amazon.com");
        //    // 2- nutella icin arama yapın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        //    // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driverGet("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        //    // 4- yeni tab'da acilan urunun basligini yazdirin
        System.out.println("Ürün Başlığı = " + driver.findElement(By.id("productTitle")).getText());
        //    // 5- ilk sayfaya gecip url'i yazdırın
        switchToWindow(1);
        System.out.println(driver.getCurrentUrl());
    }
}
