package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    @Test
    public void name() {
        //Tests package’inda yeni bir class olusturun: WindowHandle
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        Assert.assertTrue(actualText.equals("Opening a new window"));
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String window1Handle = driver.getWindowHandle();
        Set<String> windowshandle = driver.getWindowHandles();
        for (String w : windowshandle) {
            if (!w.equals(window1Handle)) {
                driver.switchTo().window(w);
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertEquals("New Window",actualTitle);
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",text);
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        String titleSon = driver.switchTo().window(window1Handle).getTitle();
        Assert.assertEquals("The Internet",titleSon);
    }
}
