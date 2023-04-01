package day16;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class C01_Deneme {
    @Test
    public void ExcelDataOkuma() throws IOException {
        String path ="./src/resources/Excels/Capitals.xlsx";
        // İlgili dosyayı yolunu vererek aç
        FileInputStream fileInputStream = new FileInputStream(path);
        //Workbook dosyasını aç
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        String ikinciSatir1inciEleman =workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        System.out.println(ikinciSatir1inciEleman);
        String ikinciSatir2inciEleman =workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();
        System.out.println(ikinciSatir2inciEleman);
        System.out.println("Örnek Çözüm: "+workbook.getSheet("Sheet1").getRow(10).getCell(0).toString());
        //------------------------------------------------//
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("Nüfus");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("300000000");
        FileOutputStream fileOutputStream2 = new FileOutputStream(path);
       workbook.write(fileOutputStream2);
    }
}
