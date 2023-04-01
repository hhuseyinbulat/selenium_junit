package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void test01() {
        //        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

       //        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);
        //        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        //       DragAndDrop() surukleme ıslemını gerceklestırır ilk parametre "neyi" ikinci parametre "nereye" sorusunu cevaplar
        Actions actions = new Actions(driver);
        actions.
                clickAndHold(kaynak). // kaynağı tut
                moveToElement(hedef).// hedefe götür
                release(). // bırak
                build() . // önceki methodların ilişkisini güçlendir
                perform();// işlemi gerçekleştir

    }



}
