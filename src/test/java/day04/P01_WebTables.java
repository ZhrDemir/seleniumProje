package day04;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class P01_WebTables extends TestBase {


// @fixMethodOrder(MethodSrters.Name_ASCENDIES)
@Test
    public void test01(){

    //1."https://testotomasyonu.com/webtables" adresine gidin
    driver.get("https://testotomasyonu.com/webtables");

    //2.Web table tum body'sini yazdirin
    WebElement tableHeeader= driver.findElement(By.xpath("//table/thead"));
    System.out.println(tableHeeader.getText());

    WebElement tableBady= driver.findElement(By.xpath("//table/tbody"));
    System.out.println(tableBady.getText());

//3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
    String expectedIcerik = "Comfortable Gaming Chair";
    String actualIcerik = tableBady.getText();
    assertTrue(actualIcerik.contains(expectedIcerik));


//4.Web table'daki satir sayisinin 5 oldugunu test edin
    List<WebElement> satirElementleri = driver.findElements(By.xpath("//tbody/tr"));
    int expectedSatirSayisi = 5;
    int actualSatirSayisi = satirElementleri.size();
    assertEquals(expectedSatirSayisi,actualSatirSayisi);


//5.Tum satirlari yazdirin
    for (int i = 0; i < satirElementleri.size(); i++) {
        System.out.println(i+1+" satır elemanları: \n"+ satirElementleri.get(i).getText()+"\n");

    }


//6. Web table'daki sutun sayisinin 4 olduğunu test edin
    List<WebElement> baslikElementleri = driver.findElements(By.xpath("//thead/tr/th"));

    int expectedSutunSayisi = 4;
    int actualSutunSayisi = baslikElementleri.size();
    assertEquals(expectedSutunSayisi,actualSutunSayisi);

//7. 3.sutunu yazdirin
    List<WebElement> ucuncuSutunElemanlari = driver.findElements(By.xpath("//td[3]"));
    for (int i = 0; i < ucuncuSutunElemanlari.size(); i++) {

        System.out.println(i+1+".satır 3.sütun  elemanları : "+ ucuncuSutunElemanlari.get(i).getText()+"\n");
    }



//8. Tablodaki basliklari yazdirin
    System.out.println("Başlıklar : \n");
    for (int i = 0; i < baslikElementleri.size(); i++) {
        System.out.println( baslikElementleri.get(i).getText()+", ");

    }

//9.  4.satirdaki category degerinin "Furniture" oldugunu test edin

    expectedIcerik = "Furniture";
    actualIcerik = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
    assertTrue(actualIcerik.contains(expectedIcerik));
}
}