package day17;

import org.junit.Test;
import utilities.TestBase;

public class C04 extends TestBase {


    @Test
    public void name() {
        // 2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
        // 3)Tarih kısmındaki Yazili metinleri al ve yazdır
        getValueByJS("hotelDates");
    }
}
