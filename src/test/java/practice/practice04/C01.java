package practice.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();
        //Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//  --------> (Yeni bir sekme açar)
        driver.get("https://www.techproeducation.com");
        //Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);//  --------> (Yeni bir pencere açar)
        driver.get("https://www.walmart.com");
        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals("https://www.amazon.com/",URL);
    }
}
