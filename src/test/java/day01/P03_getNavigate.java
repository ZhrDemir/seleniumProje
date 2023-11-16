package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_getNavigate {
    public static void main(String[] args) throws InterruptedException {
   /*..Exercise-1:...
        Create a new class with main method
   */
        // Set Path
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        //Create a chrome driver
        WebDriver driver = new ChromeDriver();
       // Maximize window
        driver.manage().window().maximize();

        //  Open google home page
        driver.get("https://www.google.com");
        Thread.sleep(2000);

       // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();

        // Wait about 4 sn
         Thread.sleep(4000);

         // Navigate forward to amazon
        driver.navigate().forward();

        Thread.sleep(2000);
        //  Refresh page
        driver.navigate().refresh();

        //  Close/quit the browser
        driver.quit();

        // And Last step print "All is well" on console
        System.out.println("All is well");









    }
}
