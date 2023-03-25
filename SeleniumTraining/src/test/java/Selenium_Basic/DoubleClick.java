package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {

        // System.setProperty("webdiver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        /* driver = new ChromeDriver();
         */
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }

    @Test
    public void doubleClick() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.id("clickable"));
        actions.doubleClick(doubleClick).perform(); //Linea para dar doble clic al elemento
        Thread.sleep(3000);

    }

    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }

}
