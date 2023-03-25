package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolTip {
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
    public void toolTip() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.id("hover"));
        actions.moveToElement(hover).perform();
        Thread.sleep(3000);

        WebElement statusMessage = driver.findElement(By.id("move-status"));
        String message = statusMessage.getText();
        System.out.println("The message is : " + message);

    }

    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }

}
