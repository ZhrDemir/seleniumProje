package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05_SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
// ...Exercise3...

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to  https://testpages.herokuapp.com/styled/index.html

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculater under Micro Apps

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

//         Type any number in the first input
//         Type any number in the second input
//         Click on Calculate
//         Get the result
//         Print the result
        driver.findElement(By.id("number1")).sendKeys("136");
        driver.findElement(By.id("number2")).sendKeys("264");
        driver.findElement(By.xpath("//*[@*='calculate']")).click();
        WebElement answer = driver.findElement(By.id("answer"));
        System.out.println("işlem sonucu = "+ answer.getText());


        Thread.sleep(3000);
        driver.quit();
    }
}
