package practice.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C05 extends TestBase {
    @Test
    public void test01() {
        //         -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//div[text()='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        String window1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();
        //        -Sayfa başlığının Fleet içerdiğini test edelim
        Set<String> handles =driver.getWindowHandles();

        Assert.assertTrue(driver.getTitle().contains("Fleet"));
    }
}
