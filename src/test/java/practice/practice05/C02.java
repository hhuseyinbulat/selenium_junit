package practice.practice05;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02 extends TestBase {
    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */
    @Test
    public void test01() {
        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies number = " + cookies.size());


        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        cookies.forEach(t-> System.out.println(t.getName() +" // "+t.getValue()));
        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","Benim o :)");
        driver.manage().addCookie(myCookie);
        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        waitFor(5);
        Set<Cookie> yeniCookies = driver.manage().getCookies();
        System.out.println("Yeni cookies number = " + yeniCookies.size());
        yeniCookies.forEach(t-> System.out.println(t.getName() +" // "+t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);
        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
    }
}
