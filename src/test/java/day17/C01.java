package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.IOException;

public class C01 extends TestBase {
   /*
scrollIntoViewTest metotu olustur
Techpro education ana sayfasina git
We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
     */
    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        //1 Elemnti bul
        WebElement webElement = driver.findElement(By.xpath("//span[.='we offer']"));
        waitFor(3);

        // 2 obje olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 3 Javascript methodunu yaz
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitFor(3);


        takeScreenShotOfPage();
        waitFor(3);
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();
        waitFor(3);
        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);

        scrollEndJS();
        waitFor(3);

        scrollTopJS();
        waitFor(3);

    }
}
