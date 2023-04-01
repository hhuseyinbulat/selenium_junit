package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Deneme extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void beforeClass() throws Exception {
        String currentTime = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path =System.getProperty("user.dir")+"/test_output_deneme/reports/"+currentTime+"html_report.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);
        extentReports = new ExtentReports();
        extentHtmlReporter.config().setDocumentTitle("Deneme Title");
        extentHtmlReporter.config().setReportName("Deneme Rapor Adı");
        extentReports.setSystemInfo("Test Enviroment","Regression");
        extentReports.setSystemInfo("Application","İlk Uygulamam");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("QA","Hüseyin");

        extentReports.attachReporter(extentHtmlReporter);

        extentTest = extentReports.createTest("İlk Test","Smoke Test");
    }
    @Test
    public void extendReportTest(){
        extentTest.pass("TEST GEÇTİ");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        extentReports.flush();
    }
}
