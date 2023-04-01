package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void name() {
       // clickByJSTest
       // Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
       // LMS LOGIN elementine tikla
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        waitFor(3);
       // Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        assert driver.getCurrentUrl().equals("https://lms.techproeducation.com/");
    }
}
