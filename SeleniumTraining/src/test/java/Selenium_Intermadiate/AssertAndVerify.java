package Selenium_Intermadiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertAndVerify {

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

    // 1. Verify / assert (afirmar) si un texto esta presente en la pagina
    // 2. Verify / assert (afirmar) si un elemento esta presente
    @Test
    public void VerifyTextPresent() throws InterruptedException {
        //Es necesario implementar antes o despues de la prueba, verificaciones o afimaciones
        // **************** una veificacion no detiene el scrip, es decir verifica y continua

        if (driver.getPageSource().contains("This would be a basic example to start with checkboxes using selenium.")){
            System.out.println("Message is PRESENT");
        }
        else {
            System.out.println("Message is not PRESENT");
        }

        Assert.assertTrue(driver.getPageSource().contains("fdgfdfdgfdg"));



        String pageSource = driver.getPageSource();
        System.out.println("Page source is: "+pageSource);

        //Si requerimos que el scrip se detenga podemos usar los asserts
        WebElement check = driver.findElement(By.id("check1"));
        check.click();
        Thread.sleep(3000);

    }

    @Test
    public void verifyGetText() throws InterruptedException {
        String message = "All Examples";
        String get = driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).getText();
        if (message.equals(get)){
            System.out.println("Element is present" + get);
        }
        else {
            System.out.println("Message is not PRESENT");
        }

        Thread.sleep(3000);
    }

    public boolean isElementPresent(String locator){
        try{
            driver.findElement(By.xpath(locator));
            return true;
        }
        catch (Throwable T){
            System.out.println("Exception. " + T);
            return false;
        }
    }

    @Test
    public void VerifyElementPresent() throws InterruptedException {
        if (isElementPresent("//a[contains(text(),'All Examplesssssssss')]")){
            System.out.println("Is element present");
        }
        else {
            System.out.println("Is NOT element present");
        }
        Thread.sleep(3000);
    }

    @Test
    public void AssertTrue() throws InterruptedException {
        //El assert true se utiliza para realizar validaciones para scripts o pasasos POSITIVOS
        WebElement examples = driver.findElement(By.xpath("//a[contains(text(),'All Examples')]"));
        Assert.assertTrue(examples.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void AssertFalse() throws InterruptedException {

        //El assert false se utiliza para utilizar validaciones para scripts o pasos NEGATIVOS
        WebElement examples = driver.findElement(By.xpath("//a[contains(text(),'All Examples')]"));
        Assert.assertFalse(examples.isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void AssertEquals() throws InterruptedException {
        //El assert equals realiza validaciones de igualdad

        String title = "Selenium Easy - Checkbox demo for automation using selenium";
        String get_Title = driver.getTitle();
        System.out.println("Title: "+ get_Title);
        Assert.assertEquals(title, driver.getTitle());
        Thread.sleep(3000);
    }

    @Test
    public void GetText() throws InterruptedException {
        String examples = driver.findElement(By.xpath("//a[contains(text(),'All Examples')]")).getText();
        System.out.println("Text : " + examples);
        Assert.assertEquals(examples,"All Examples");
        Thread.sleep(3000);
        Assert.assertEquals(examples.length(),12);
    }




    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }

}
