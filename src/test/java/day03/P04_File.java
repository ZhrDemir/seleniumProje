package day03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_File extends TestBase {

    @Test
    public void test01(){


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //Bilgisayarımızdaki herhangi bir dosyayı buraya yükleyelim
       WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String dosyayolu = "C:\\Users\\AİLE\\Downloads\\logo.png";
       chooseFile.sendKeys(dosyayolu);

       WebElement buttonElementi = driver.findElement(By.id("file-submit"));
       buttonElementi.click();

       WebElement YaziElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue("File Uploaded",YaziElementi.isDisplayed());

    }
}
