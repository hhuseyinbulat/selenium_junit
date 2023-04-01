package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class RamazanHoca extends TestBase {
    WebElement lmsloginLink;
    @Test
    public void staleElementReferenceExceptionTest01() {
        driver.get("https://www.techproeducation.com");
        // LMS LOGIN linkine tıkla ve o sayfanın url'nin lms içerdiğini test et
        waitFor(5);
        lmsloginLink = driver.findElement(By.linkText("LMS LOGIN")); // Kendime note: sınıf seviyesinde instantiate yaparsak çözüm.
        waitFor(5);
        lmsloginLink.click(); // LMS'e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms")); // URl'in "lms" kelimesi içerdiğini test ettik

        waitFor(5);
        // Tekrar ana sayfaya gel ve LMS LOGIN sayfasına tekrar git
        driver.navigate().back(); // tekrar ana sayfaya gittik
        lmsloginLink.click(); // LMS'e tekrar git
}}
