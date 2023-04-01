package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01 {
    @Test
    public void test01() throws IOException {
        // WORKBOOK -> WORKSHEET -> ROW -> CELL
        String path ="./src/resources/Excels/Capitals.xlsx";
        // DOSYAYI AÇ
        FileInputStream fileInputStream = new FileInputStream(path);
        // WORKBOOKU AÇ
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //WORKSHEET i AÇ
                                                       //Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet = workbook.getSheet("Sheet1");

        //ILK ROW a GİT
        Row row = sheet.getRow(0);

        //ILK CELL i YAZDIR
        Cell cell = row.getCell(0);
        System.out.println(cell);
        //        1. SATIR 2. SUTUN
        Cell cell12 = sheet.getRow(0).getCell(1);
        System.out.println(cell12);
//        3.Satir 1.Sutun yazdir ve O verinin France oldugunu test et
        String cell31 = sheet.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);
//       Exceldeki toplam kullanilan satir sayisini bul
        int toplamSatirSayisi = sheet.getLastRowNum()+1;//son satir numarasi.index 0dan basliyor. sayma sayilari 1 den. +1 ekle
        System.out.println(toplamSatirSayisi);//11
//        Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den basliyor
//        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}
//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
//            ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);
    }
}


