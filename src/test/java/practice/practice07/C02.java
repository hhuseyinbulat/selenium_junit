package practice.practice07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02 extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */

    @Test
    public void name() {
        driver.get("https://jqueryui.com/slider/#colorpicker");
        waitFor(3);
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        List<WebElement> tuslar = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(tuslar.get(1),-175,0);
        actions.dragAndDropBy(tuslar.get(2),-80,0);
        actions.dragAndDropBy(tuslar.get(1),301,0).build().perform();

        WebElement sariKutu =driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sariKutu.isDisplayed();
    }
}
