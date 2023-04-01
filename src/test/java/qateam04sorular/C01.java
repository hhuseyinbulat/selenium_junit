package qateam04sorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01 extends TestBase {

    @Test
    public void name() {
//sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");
        waitFor(5);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        waitFor(2);
//anasayfada oldugunuzu dogrulayin
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.sahibinden.com/",url);
//detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();
//detayli arama sayfasina geldiginizi dogrulatin
        String detayliUrl =driver.getCurrentUrl();
        Assert.assertEquals("https://www.sahibinden.com/arama/detayli",detayliUrl);
        //assert driver.findElement(By.xpath("//h2[text()='Detaylı Arama']")).isDisplayed();
//emlak-konut-satilik seceneklerini secip
//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        driver.findElement(By.xpath("//table[@class='categorySubTable']//tbody//tr//td[2]//div//li//span[text()='Emlak']")).click();
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();
        waitFor(3);
        //driver.findElement(By.xpath("//li[@data-address='city']//a[@title='Ankara']")).click();
        //driver.findElement(By.cssSelector("a[class='faceted-select']")).click();
     // driver.findElement(By.xpath("//a[@class='faceted-select']")).click();
     // waitFor(3);
     // driver.findElement(By.xpath("//li[@data-id='6']//a[text()='Ankara']")).click();
     // waitFor(3);
     // driver.findElement(By.xpath("//li[@data-address='town']//a[@title='İlçe']")).click();
     // waitFor(3);
     // driver.findElement(By.xpath("(//li[@data-id='67'])[2]")).click();
     // waitFor(2);
     // driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
     // waitFor(2);
     // driver.findElement(By.xpath("//li[@data-address='quarter']//a[@title='Mahalle']")).click();
     // waitFor(2);
     // driver.findElement(By.xpath("//*[@data-id='3892']")).click();
     // waitFor(2);
     // driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.xpath("(//a[@class='faceted-select'])[" + i + "]")).click();
            switch (i) {
                case 1:
                    waitFor(3);
                    driver.findElement(By.xpath("(//a[@class='noChild single-selection'])[4]")).click();
                    waitFor(1);
                    break;
                case 2:
                    driver.findElement(By.xpath("(//li[@data-id='67'])[2]")).click();
                    driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
                    waitFor(1);
                    break;
                case 3:
                    driver.findElement(By.xpath("//li[@data-id='3892']//a")).click();
                    driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
                    waitFor(1);
                    break;
            }
        }
//filtreler için sağıdakilere benzer methodlar oluşturun
       //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");

       //detayli_Arama_Fiyat("4.000","4.000.000","USD");
        Actions actions = new Actions(driver);
       // actions.sendKeys(Keys.TAB,"750000",Keys.TAB,"2000000",Keys.TAB,Keys.TAB,"250",Keys.TAB,"400").perform();
        driver.findElement(By.xpath("//input[@placeholder='Min TL']")).sendKeys("1500000",Keys.TAB,"5000000",
        Keys.TAB,Keys.TAB,"150",Keys.TAB,"400");
        waitFor(2);
       //detayli_Arama_Brut("180","400");
       //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
        List<WebElement> kutular = driver.findElements(By.xpath("//div[@class='filtered-select closed js-filtered-select']"));
        kutular.get(0).click();
        driver.findElement(By.xpath("//input[@name='select_a20']")).sendKeys("6");
        driver.findElement(By.xpath("//label[@for='a20_option_27']")).click();
        waitFor(1);
        kutular.get(0).click();
        waitFor(5);
        kutular.get(1).click();
        waitFor(1);
        driver.findElement(By.xpath("//label[@for='a812_option_4']")).click();
        kutular.get(1).click();


//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin

    }
}
