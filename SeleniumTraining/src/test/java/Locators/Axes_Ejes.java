package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Axes_Ejes {
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
    public void Child(){
        //Este xpath es Child AXES

        // En este ejemplo en parte del array, colocamos el numero 1 ya que solo tenia un buton, sin embargo
        //SI HUBIERA MAS BOTONES cambia el

        WebElement find = driver.findElement(By.xpath("//span[@class='input-group-btn']//child::button[1]"));
        WebElement busq = driver.findElement(By.xpath("ul[@class='dropdown-menu']//child::li[3]"));
    }

    @Test
    public void Parent(){
        //Este xpath es por relacion de parent

        WebElement input = driver.findElement(By.xpath("//input[@type='text']//parent::div"));
    }

    @Test
    public void Self(){

        //Este xpath es por su mismo eje, es decir, si por ejemplo "div" el tag inicial su eje es igual a "div"
        // o al colocar la relacion "self" tambien es valido colocar "*"

        //Ejemplo 1 con tag

        WebElement input = driver.findElement(By.xpath("//input[@type='text']//parent::div"));

        //Ejemplo 2 con *
        WebElement input_dos = driver.findElement(By.xpath("//input[@type='text']//parent::*"));
    }

    @Test
    public void Ancestor() throws InterruptedException {
        //El eje ancestor seleccionara los elementos anteriores, es decir, se puede colocar
        //"parent", o "grandparent"

        WebElement input =driver.findElement(By.xpath("//input[@type='text']//ancestor::div"));
        input.sendKeys("HP");
        Thread.sleep(3000);
    }

    @Test
    public void Descendant(){
        //Este xpath en la parte de la relacon tambien podemos indexar, por ejemplo si es [1], [2], segun corresponda
        //
        WebElement input = driver.findElement(By.xpath("//div[@class='input-group']//descendant::input[1]"));
    }

    @Test
    public void Following(){
        //Este xpath en la parte de la relacon tambien podemos indexar, por ejemplo si es [1], [2], segun corresponda
        //
        WebElement input = driver.findElement(By.xpath("//div[@class='input-group']//following::input[1]"));

    }

    @Test
    public void FollowingSibling(){

        WebElement input = driver.findElement(By.xpath("//div[@class='input-group']//following-sibling::input"));
    }








    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }



}
