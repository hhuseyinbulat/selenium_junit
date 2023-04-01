package practice.practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void name() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l", Keys.SHIFT, "l", Keys.SHIFT, "o", Keys.SHIFT);
    }
}
