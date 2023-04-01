package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test01() {
        //https://techproeducation.com a git
        driverGet("https://www.techproeducation.com");
        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.
                           sendKeys(Keys.PAGE_DOWN)
                          .sendKeys(Keys.PAGE_DOWN)
                          .sendKeys(Keys.PAGE_DOWN)
                          .perform();
        waitFor(3);
        //Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP)
                .sendKeys(Keys.PAGE_UP)
                .sendKeys(Keys.PAGE_UP).perform();

    }
}
