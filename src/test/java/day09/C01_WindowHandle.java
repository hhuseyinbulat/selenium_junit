package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedWindow1Text ="Opening a new window";
        Assert.assertEquals(expectedWindow1Text,actualWindow1Text);
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        //Click Here butonuna basın.
        String windowHandle1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();
        waitFor(3);
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        switchToWindow(1);
        String actualTitleWindow2 =driver.getTitle();
        String expectedTitleWindow2 ="New Window";
        Assert.assertEquals(expectedTitleWindow2,actualTitleWindow2);

    }
}
