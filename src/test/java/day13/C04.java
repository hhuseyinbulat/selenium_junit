package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
    /*
Stale Element means the element is no longer fresh. It is old and no longer available
When the element is no longer fresh on the page and you try to use it
When the element is detached from the DOM
When the element is removed after session started
Solution:
Relocate the same element again. You can use a new variable name as well.


Stale Element = eski, kullanılamaz durumda, kullanım artık elverişli degil
-Sayfayi yenilediğinizde (refresh())
-Sayfada ileri geri gittimizde
COZUM:
Elementi tekrar bulmak */

    @Test
    public void staleElementReferenceExceptionTest1(){
        driver.get("https://www.techproeducation.com");
        waitFor(3);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(3);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(3);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(3);
        lmsLoginLink.click();//LMS e git
    }

    @Test
    public void staleElementReferenceExceptionTest2(){
        driver.get("https://www.techproeducation.com");
        waitFor(5);
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();

    }
     /*
        StaleElementReferenceException
StateElementReferenceException = eski kullanılamaz durumda olan, kullanıma artık elverişli olmayan durumlarda alınan hatadır.
Sayfayı yenilediğimizde,>
sayfada ileri geri gittiğimizde meydana gelen exception'dır.

    Çözüm
Elemanı tekrar bulmak.*/

}
