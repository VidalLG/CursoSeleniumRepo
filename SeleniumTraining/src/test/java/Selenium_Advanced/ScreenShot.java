package Selenium_Advanced;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void sacarScreenShot() throws IOException, InterruptedException {


        for (int i = 0; i < i; ){

            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("src/test/java/Screens/screenScroll" + i + ".png"));
            //Thread.sleep(3000);
            i ++;
        }



    }


    @Test
    public void screenShot() throws IOException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sacarScreenShot();
        js.executeScript("window.scrollBy(0,380)");
        sacarScreenShot();

    }


    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }



}
