package day03;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class P01_FormDoldurma_Faker extends TestBase {


        @Test
        public void test01(){




// 1-https://www.automationexercise.com/ adresine gidin
            driver.get("https://www.automationexercise.com/");

// 2-Sign-up  butonuna basınız
            driver.findElement(By.xpath("//a[@*='/login']")).click();

// 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayı
            WebElement yaziElementi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
            String expectedYazi = "New User Signup!";
            String actualYazi = yaziElementi.getText();
            Assert.assertEquals(expectedYazi,actualYazi);

// 4-üye kaydı işlemini başlatın

            ReusableMethods.bekle(3);
            WebElement firstName = driver.findElement(By.xpath("//input[@type='text']"));
            Actions actions = new Actions(driver);
            Faker faker = new Faker();

            String firstN = faker.name().firstName();
            String email = faker.internet().emailAddress();

            actions.click(firstName)
                    .sendKeys(firstN)
                    .sendKeys(Keys.TAB)
                    .sendKeys(email)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER)
                    .perform();

// 5-Üye kayit formunu doldurun
            WebElement MrsButonElementi= driver.findElement(By.id("id_gender2"));

            actions.click(MrsButonElementi)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password())
                    .sendKeys(Keys.TAB)
                    .sendKeys("1")
                    .sendKeys(Keys.TAB)
                    .sendKeys("May")
                    .sendKeys(Keys.TAB)
                    .sendKeys("1990")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(firstN)
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.name().lastName())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("Istanbul")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB).perform();

            WebElement countryElementi = driver.findElement(By.id("country"));
            Select select = new Select(countryElementi);
            select.selectByValue("Canada");

            actions.sendKeys(Keys.TAB)
                    .sendKeys(faker.address().state())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().city())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.address().zipCode())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.phoneNumber().phoneNumber())
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER)
                    .perform();



// 6-Üye kaydinin yapildiği mesajının göründğünü doğrulayın
            WebElement YaziEleme = driver.findElement(By.xpath("//b[text()='Account Created!']"));

            Assert.assertTrue(YaziEleme.isDisplayed());


            ReusableMethods.bekle(3);

        }




    }




