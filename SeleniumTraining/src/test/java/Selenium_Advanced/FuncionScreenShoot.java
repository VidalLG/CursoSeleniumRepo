package Selenium_Advanced;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class FuncionScreenShoot {


    private WebDriver driver;

    public void sacarScreenShot() throws IOException, InterruptedException {
        for (int i = 0; // índice de control
             i < 5;   // condición booleana
             i++)      // modificación del índice tras cada bucle
        {
            // Lo que quieras que se ejecute varias veces
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File("src/test/java/Screens/screenScroll" + i + ".png"));
            //Thread.sleep(3000);


        }
    }
}
