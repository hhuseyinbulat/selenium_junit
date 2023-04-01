package practice.practice08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C03 extends TestBase {
    @Test
    public void name() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser = driver.findElement(By.xpath("//button[@aria-controls='supported-browsers']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();
        browser.click();
        waitFor(1);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.linkText("ChromeDriver 109.0.5414.74")).click();
        //Açılan pencerede chromedriver'i indirelim
        List<String> handles = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(handles.get(1));
        WebElement w32 = driver.findElement(By.xpath("//td//a[@href='/109.0.5414.74/chromedriver_win32.zip']"));
        w32.click();
        //Driver'in indiğini doğrulayalım
        String dosyaYolu2= System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (1).zip";
        assert Files.exists(Paths.get(dosyaYolu2));
    }
}
