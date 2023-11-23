package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

/*
1- www.google.com adresine gidilir
2- sayfanın title ve Url değerleri yazdırılır
3- yeni bir sekme açılarak www.wisequarter.com adresine gidilir
4- gidilen sayfanın title ve url değerleri yazdırılır
5- ilk sekmeye geçilip, burada www.testotomasyonu.com adresine gidilir
6- gidilen sayfanın title ve url değerleri yazdırılır
7- açılan pencere kapatılır.

 */
        String ht = "https://www.";
        driver.get(ht+"google.com");
        System.out.println("1.Site Title "+driver.getTitle());
        System.out.println("2.Site URL " +driver.getCurrentUrl());

        System.out.println("1.Site handle 1: "+driver.getWindowHandle());
        String handle1 = driver.getWindowHandle();
        driver.navigate().refresh();
        System.out.println("1.Site handle 2: "+driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(ht+"wisequarter.com");
        System.out.println("2.Site Title " + driver.getTitle());
        System.out.println("2.Site URL "+driver.getCurrentUrl());
        System.out.println("2.Site handle : "+driver.getWindowHandle());
        String  handle2 = driver.getWindowHandle();

        //yeniden ilk sekmeye geçti
        driver.switchTo().window(handle1);
        driver.get(ht+"testotomasyonu.com");
        System.out.println("3.Site Title " + driver.getTitle());
        System.out.println("3.Site URL "+driver.getCurrentUrl());
        System.out.println("3.Site handle : "+driver.getWindowHandle());

        //2.sekmeye dönüyor
        driver.switchTo().window(handle2);
        driver.get("http://www.babayigit.com");

        //Yeni bir pencere açıyor
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(ht+"wisequarter.com");
        driver.switchTo().window(handle1);
        driver.navigate().to(ht+"amazon.com");



        driver.quit();
    }
}
