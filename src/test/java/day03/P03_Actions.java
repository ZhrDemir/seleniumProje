package day03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Watchable;

public class P03_Actions extends TestBase {
    @Test
    public void ActionsTest(){

        Actions actions = new Actions(driver);

//1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

//2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim

        WebElement DragMeElementi = driver.findElement(By.id("draggable"));
        WebElement DropHereElementi = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(DragMeElementi,DropHereElementi).perform();

//3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin

        String expectedYazi = "Dropped!";
        String actualYazi = DropHereElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);











    }
}
