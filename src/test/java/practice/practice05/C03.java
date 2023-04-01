package practice.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03 extends TestBase {

   /* Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
    Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */
    @Test
    public void test01() {
        //    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");
        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu = driver.findElement(By.xpath("//*[@id='div2']"));
        Actions action = new Actions(driver);
        waitFor(3);
        action.moveToElement(maviKutu).perform();
        waitFor(3);
        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClick = driver.findElement(By.xpath("//*[@name='dblClick']"));
        action.doubleClick(doubleClick).perform();
        Assert.assertEquals("Double Clicked !!",driver.switchTo().alert().getText());


        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement sourceElement = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement targetElement = driver.findElement(By.xpath("//*[@id='droppable']"));
        action.dragAndDrop(sourceElement,targetElement).perform();
        waitFor(3);
        String text = driver.findElement(By.xpath("//div[@id='droppable']//p")).getText();
        Assert.assertEquals("Dropped!",text);

    }
}
