package Selenium_Intermadiate;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Waits {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //****** WAITS ********* WAITS *********** WAITS ************ WAITS ******** WAITS **********
    //Implicit Wait
    //Explicit Wait
    //Fluent Wait


    @Test
    public void implicitWaits () throws InterruptedException {
        Thread.sleep(3000);
        //La espera implicita se coloca despues de que se envia la URL al navegador
        //La espera implicita significa informar a Selenium WebDriver que espere una cantidad de
        //tiempo especifica si el elemento web no es visible despues de esperar ese tiempo especifico lanzara :
        //"NosuchelementException"...

        WebElement elementoTontin = driver.findElement(By.id("botonTontin"));
        elementoTontin.click();



    }



    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }

}
