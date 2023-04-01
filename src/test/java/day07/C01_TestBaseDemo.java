package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    @Test
    public void name() {
        driver.get("https://www.techproeducation.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamps"));
    }
}
