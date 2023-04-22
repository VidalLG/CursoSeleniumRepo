package Selenium_Intermadiate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(5));

    }

    // * * * * WAITS * * * *
    // Implicit Wait
    // Explicit Wait
    // Fluent Wait
    // <<<<<<<<<Todos los siguientes test, corresponden a ExplicitWait>>>>>>>>>>>>>


    @Test
    public void ImplicitWait () throws InterruptedException
    {
        //Thread.sleep(3000);
        //La espera implicita se coloca despues de que se envia la URL al navegador de la siguiente manera:
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //La espera implicita significa informar a Selenium WebDriver que espere una cantidad de tiempo especifica
        //Si el elemento web no es visible despues de esperar ese tiempo especifico lanzara : "NosuchelementException"...
        WebElement botonTontin = driver.findElement(By.id("Tontin"));
        botonTontin.click();

    }
    //ESTUDIAR DESDE AQUI

    @Test
    public void ExplicitWait() throws InterruptedException {
        /*Dentro de las esperas explicitas, el tiempo de espera finaliza hasta que se se cumpla la condicion o el tiempo de espera
         se agote, cuando esto suceda nos regresara la excepcion ¨ElementNotVisibleException¨*/

        // * * * * * * * * * * * * * * Explicit Wait * * * * * * * * * * * * * *

        // 1. Thread.sleep (  Thread.sleep(3000);) -- >> No pertenece a selenium, pertenece a el lengauje de programacion "Java".
        // 2. WebDriverWait
        // > > > Antes de realizar cualquier operacion, esperar una determinada posicion antes de proceder con el codigo
        // > > > Espere a que WebDriver verifique si el elemento existe o pueda operar sobre el, por ejemplo:
        // que sea visible
        // que este habilitado
        // que este deshabilitado
        // o que pueda hacer clic

        // Se declara el objeto de WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickMe = driver.findElement(By.className("btn btn-default"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-default")));



    }

    @Test@Ignore
    public void alertPresent() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //alertPresent
        // Espera unicamente cuando la alerta esta presente en la pagina
        //wait.until(ExpectedConditions.alertIsPresent());

        //Instancia de Java Script
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Con este codigo podemos crear alertas
        js.executeScript("alert('Esta es mi alerta, de prueba');");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.alertIsPresent());

        String alerta = driver.switchTo().alert().getText();
        System.out.println("Texto en alerta : " + alerta);
        driver.switchTo().alert().dismiss();
    }

    @Test@Ignore
    public void WaitElement ()
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement clickMe = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));

        //elementToBeClikCable
        //esta condicion funciona por ejemplo con los siguientes elementos: inputs, botones, etc, etc.
        wait.until(ExpectedConditions.elementToBeClickable(clickMe));

        //elementToBeSelected
        //esta condicion funciona por ejemplo con los siguientes elementos: Radio button, check boxes.
        //wait.until(ExpectedConditions.elementToBeSelected(clickMe));

        //presenceOfAllElementsLocatedBy
        //By click = By.xpath("//button[@onclick='myAlertFunction()']");
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) click)); //-- >> P E N D I E N T E

        //textToBePresentInElement
        //wait.until(ExpectedConditions.textToBePresentInElement(clickMe, "Click me!"));

    }

    @Test@Ignore
    public void PageLoadTimeOut()
    {
        // 1. Determina la cantidad de tiempo de espera para la que se complete la carga de la pagina, antes de que se
        //    produzca un error al final del tiempo

        //2. Si el tiempo de espera es negativo, la carga de la pagina puede ser indefinida hasta que se cargue la pagina
        // Nota : esta tiempo de espera se declara tambien despues de enviar la url al navegador, de la siguiente manera :
        // driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(5));
        //...
    }

    @Test@Ignore
    public void FluentWait()
    {
        // 1. Fluent Wait usa dos parametros para manejar la espera, el valor de tiempo de espera y la frecuencia.
        // 2. Fluent Wait es otro tipo de espera explicita y puede definir el sondeo e ignorar la excepcion para continuar
        // con la ejecucion del script en caso de que el elemento no se encuentre en la pagina web


        WebElement clickMe = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(clickMe, "Click me!"));
    }







    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }
}
