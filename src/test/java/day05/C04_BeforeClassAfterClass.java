package day05;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    /*
     @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
     @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
     en son @AfterClass'i calistiririz.
     Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
     */
    @BeforeClass
    public static void setUp() {
        System.out.println("Bütün testlerden önce çalıştı");
        //   WebDriverManager.chromedriver().setup();
        //   WebDriver driver = new ChromeDriver();
        //   driver.manage().window().maximize();
        //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Bütün Testlerden sonra çalıştı");
    }

    @Before
    public void setUp01() {
        System.out.println("her testten önce çalışır");
    }

    @After
    public void tearDown01() {
        System.out.println("Her testten sonra çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk Test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }

    @Test
    @Ignore //Çalıştırmak istemediğimiz testler için kullanırız
    public void test03() {
        System.out.println("Ikinci Test");
    }
}
