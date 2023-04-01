package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlerts extends TestBase {
    @Test
    public void dismissAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//*[@onclick ='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        String sonuc = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel",sonuc);
        Thread.sleep(3000);
    }
}
