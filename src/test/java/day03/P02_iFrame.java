package day03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_iFrame extends TestBase {

    @Test
    public void iframeTest01(){




// 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

// 2 ) Bir metod olusturun: iframeTest


//  3- "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement YaziElementi = driver.findElement(By.xpath("(//h3)[1]"));
        Assert.assertTrue(YaziElementi.isEnabled());
        System.out.println(YaziElementi.getText());

//  4- Text Box'a "Merhaba Dunya!" yazin.

        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));

        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dünya");

//  5- TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
//      ve  konsolda yazdirin.

        driver.switchTo().parentFrame();

        WebElement linkTextElementi = driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));

        Assert.assertTrue(linkTextElementi.isDisplayed());

        System.out.println(linkTextElementi.getText());

    }
}
