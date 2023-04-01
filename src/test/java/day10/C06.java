package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06 extends TestBase {

    @Test
    public void test01() {
        //        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        //        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        //       DragAndDrop() surukleme ıslemını gerceklestırır ilk parametre "neyi" ikinci parametre "nereye" sorusunu cevaplar
        Actions actions = new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(430,30).release().build().perform();
    }
    //ACTIONS CLASS'ı NEDİR? HANGİ METHODLAR İLE  NASIL KULLANILIR?..

//   Actions classını kullanarak klavye ve mouse ile yapabileciğiz tüm işlemleri otomosyonda da  yapmamızı sağlamaktayız..!!
//   Bu classa ait metdodlar kısaca aşağıdaki gibidir....

//       actions.doubleClick () :   WebElement'e çift tıklama yapar
//       actions.clickAndHold () :  Uzerinde click yapili olarak bekler
//       actions .dragAndDrop () :  Bir noktadan diğerine sürükler ve bırakır
//       actions.moveToElement () : Mouse'u istedigimiz WebElement'in uzerinde tutar
//       actions.contextClick ():   Mouse ile istedigimiz WebElement'e sag tiklama yapar.
//       actions.sendKeys() :       Öğeye bir dizi anahtar gönderir
//       actions.keyDown () :       Klavyede tuşa basma işlemi gerçekleştirir
//       actions.keyUp () :         Klavyede tuşu serbest bırakma işlemi gerçekleştirir
//
//
//        !!!!Actions classını kullanmak için üç aşama vardır.

//     1.Action classından obje üretiriz.
//     (Actions actions= new Actions(driver);)
//     2.actions objesi ile kullanacağımız web elementi locate ederiz...
//     3.istediğimiz methodları action objesi ile kullanırız.
//     actions.doubleClick(element ismi).perform;
}
