package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
    @Test
    public void name() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //    uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Hüseyin");
        //    OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //    ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actualResult.contains("Hüseyin"));
    }
}
