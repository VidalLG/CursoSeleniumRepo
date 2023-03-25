package Selenium_Intermadiate;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AlertAndPopup {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }

    @Test@Ignore
    public void aceptarAlert() throws InterruptedException {
        WebElement launchModal = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        launchModal.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @Test
    public void dismissAlert () throws InterruptedException {
        //Instancia de Java Script
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Con este codigo odemos crear alertas
        js.executeScript("alert('Esta es mi alerta');");
        Thread.sleep(3000);
        String alerta = driver.switchTo().alert().getText();
        System.out.println("Texto en alerta: " + alerta);
        driver.switchTo().alert().dismiss();
    }



    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }


}
