package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_testExerc {
    public static void main(String[] args) throws InterruptedException {





//. .Exercise2...
//        1-Driver oluşturalim
//        2-Java class'imiza chnomedriver.exe i tanitalim

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        3-Driver'in tum ekranı kaplamasini saglayalim

        driver.manage().window().maximize();

//        4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim.
//        Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

//        5-"https://www.otto.de” adresine gidelim

        driver.get("https://www.otto.de");


//        6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoUrl = driver.getCurrentUrl();
        String ottoTitle = driver.getTitle();


//        7-Title ve url inin "OTTO” kelimesinin içerip icermedigini kontrol edelim

        System.out.println(ottoTitle);
        System.out.println(ottoUrl);

        if (ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
            System.out.println("TITLE and URL TEST PASSED");
        }else System.out.println("TITLE and URL TEST FAILED");


//        8-Ardindan "https://wisequarter.com/” adresine gidip

        System.out.println("-------------------------------");
        driver.navigate().to("https://wisequarter.com/");

//        9-BU adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim

        String wqTitle = driver.getTitle();
        boolean kelime = wqTitle.contains("Quarter");

        System.out.println(wqTitle);
        if (kelime==true){
            System.out.println("WİSE QUARTER TITLE TEST PASSED");
        }else System.out.println("WİSE QUARTER TITLE TEST FAILED");

//        10-Bir onceki web sayfamiza geri donelim

        Thread.sleep(3000);
        driver.navigate().back();

//        11-Sayfayı yenileyelim
                Thread.sleep(3000);
                driver.navigate().refresh();

//        12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
                Thread.sleep(3000);
                driver.navigate().back();
        System.out.println("----------test tamamlandı----------");
                driver.quit();


    }
}
