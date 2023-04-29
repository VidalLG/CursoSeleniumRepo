package Selenium_Advanced;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class javascriptExecutor {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void NewPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://demo.guru99.com/test/newtours/'");
        Thread.sleep(3000);
    }

    @Test
    public void SendKeys() throws InterruptedException {

        //Forzar introducir valores a un campo con JavaScript

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('search')[0].value='MacBook'");
        Thread.sleep(3000);
    }

    @Test
    public void Click() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*js.executeScript("window.location = 'http://demo.seleniumeasy.com/basic-checkbox-demo.html'");
        Thread.sleep(3000);

         */
        //js.executeScript("document.querySelector('.dropdown-toggle').click()");
        js.executeScript("document.querySelector('#form-currency')[0].click()");
        Thread.sleep(3000);
    }





    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }


}
