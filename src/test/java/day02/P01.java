package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    public static void main(String[] args) {

        /*




 */
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // 1- http://babayigit.net/testdocs/ adresine gidilir
        driver.get(" http://babayigit.net/testdocs/");

        //2- INFO FORM butonuna tıklanır
        driver.findElement(By.xpath("//a[@href='information.html']")).click();

        //3- Form verileri girilir

        driver.findElement(By.id("firstName")).sendKeys("Z");
        driver.findElement(By.id("lastName")).sendKeys("D");
        driver.findElement(By.id("email")).sendKeys("zdem2021@gmail.com");
        driver.findElement(By.cssSelector("input[id='phone")).sendKeys("500000000");
        driver.findElement(By.xpath("//input[@id=\"age\"]")).sendKeys("45");
        driver.findElement(By.id("female")).click();
        driver.findElement(By.id("city")).sendKeys("Istanbul");
        driver.findElement(By.id("country")).sendKeys("Türkiye");
        driver.findElement(By.name("occupation")).sendKeys("student");

        // 4- Save butonuna tıklanır
        driver.findElement(By.xpath("//button[@onclick='saveUserInfo()']")).click();
       // 5- Sonuç yazdırılır
        WebElement sonucYazisi = driver.findElement(By.id("resultMessage"));
        System.out.println(sonucYazisi.getText());

        driver.quit();
    }
}
