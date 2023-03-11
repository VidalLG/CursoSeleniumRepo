package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DragAndDrop {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {

        System.setProperty("webdiver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ****** URL DRAG AND DROP SIN IFRAME ***
        //driver.get("http://demo.seleniumeasy.com/drag-and-drop-demo.html");

        //*******URL DRAG AND DROP CON FRAME******
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
    }

    @Test@Ignore //Quitar el Ignore cuando se ejecute el codigo "SIN IFRAME"
    public void DragAndDropActions () throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//*[contains(text(), 'Draggable 1' )]"));
        WebElement drop = driver.findElement(By.id("mydropzone"));

        //Primer funcion para realizar drag and drop
        /* actions.dragAndDrop(drag,drop).build().perform();
        Thread.sleep(3000); */

        //Segunda funcion para realizar drag and drop
                actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .build()
                .perform();
        Thread.sleep(3000);
    }

    @Test
    public void DragAndDropIframe() throws InterruptedException {

        //Funcion para realizar Drag and Drop con Iframe
        //driver.switchTo().frame(0); -----------> Se utiliza unicamente cuando tenemos el domk un tag "iframe"
        //

        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));


        actions.dragAndDrop(drag,drop)
                .build()
                .perform();

        //Segunda Funcion para hacer drag and drop con Iframe (esta opcion no muestra como se realiza el drag and drop)

        /*actions.clickAndHold(drag)
                .moveToElement(drag)
                .release()
                .build()
                .perform();
        Thread.sleep(3000); */


    }

    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }



}
