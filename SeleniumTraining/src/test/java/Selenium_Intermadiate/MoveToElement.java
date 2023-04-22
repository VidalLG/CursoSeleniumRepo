package Selenium_Intermadiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoveToElement {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void MoveToElement() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement examples = driver.findElement(By.xpath("//a[contains(text(),'All Examples')]"));

        //Tooltip
        //actions.moveToElement(examples).perform();

        //Click
        actions.moveToElement(examples).click().build().perform();

        Thread.sleep(3000);
        actions.moveToElement(examples).click(examples).pause(2000).click(examples).build().perform();
    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }


}
