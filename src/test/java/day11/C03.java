package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03 {
    @Test
    public void name() {
        String dir = System.getProperty("user.dir");
        System.out.println("dir: "+dir);
        String userHome =System.getProperty("user.home");
        System.out.println("home: "+userHome);
        String dosyaYolu = userHome +"\\OneDrive - hbv.edu.tr\\Masaüstü\\intellij_93550.ico";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isExist);

    }
}
