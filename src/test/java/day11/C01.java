package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void name() {
        //Google a gidin https://www.google.com
        driverGet("https://www.google.com");
        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.name("q"));
        actions
                .keyDown(searchBox, Keys.SHIFT)
                .sendKeys("iphone x fiyatlari")
                .keyUp(searchBox,Keys.SHIFT)
                .sendKeys(" cok pahalı"+Keys.ENTER)
                .build()
                .perform();



    }
}
