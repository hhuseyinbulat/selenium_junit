package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01 extends TestBase {
    /*
Selenium tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu selenium'dan gelen getScreenshotAs method'u ile alinir
    -getScreenshotAs method'u Selenium'daki TakeScreenshot API' indan gelir.
 */
    @Test
    public void name() throws IOException {
        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

        File goruntu = ts.getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"image.png";
        FileUtils.copyFile(goruntu,new File(path));
        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA");
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Result for')]")).getText();
        Assert.assertTrue("Search Results for: QA".contains(text));
    }
}
