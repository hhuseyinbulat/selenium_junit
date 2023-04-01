package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1-C01_TekrarTestiisimlibirclassolusturun
        // 2-https://www.google.com/  adresinegidin
        driver.get("https://www.google.com/");
        // 3-cookiesuyarisinikabulederekkapatin
        // 4-Sayfabasliginin“Google”ifadesiicerdiginitestedin
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Google")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");
        // 5-Aramacubuguna“Nutella”yaziparatin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // 6-Bulunansonucsayisiniyazdirin
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println(sonucYazisi);

        // 7-sonucsayisinin10milyon’danfazlaoldugunutestedin
        String yuzElliMilyon =sonucYazisi.split(" ")[1];
        yuzElliMilyon = yuzElliMilyon.replaceAll("\\.", "");
        int yeni150 = Integer.parseInt(yuzElliMilyon);
        if (yeni150>10000000){
            System.out.println("Test Passed"+ "\nSonuç Sayısı: "+yeni150 );
        }else System.out.println("Test Failed");

        // 8-Sayfayikapatin
        driver.close();
    }
}
