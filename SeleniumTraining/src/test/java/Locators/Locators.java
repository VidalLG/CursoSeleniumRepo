package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {
        // Se coloca la direccion del driver, segun corresponda (chrome, mozilla, edge...)
        System.setProperty("webdiver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

        // Se crea la instancia u objeto del Navegador
        driver = new ChromeDriver();

        //Maximizar el nevegador
        driver.manage().window().maximize();

        //Enviamos la URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);

    }

    @Test
    public void locators () throws InterruptedException {

        /* ************************ Localizador por "ID"

        WebElement demoSite = driver.findElement(By.id("site-name"));
        demoSite.click();
        Thread.sleep(2000);

        */

        /* ************************ Localizador por "name"

        WebElement userName = driver.findElement(By.name("userName"));
        userName.click();
        userName.sendKeys("VidalLG");
        Thread.sleep(3000);

         */

        // ************************Localizador por "class"

       /* WebElement logo = driver.findElement(By.className("logo"));
        logo.click();
        Thread.sleep(3000);

        */

        // ************************Localizador por "Link text"
        /* WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep(3000);

         */

        // ************************Localizador por "Parcial link text"
        //Se ocupa para utilizar solo una parte del texto total

        /* WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(3000);

         */

        // ************************ Localizador por "cssSelector" 1

        /* WebElement userName = driver.findElement(By.cssSelector("input[name='userName']"));
        userName.click();
        userName.sendKeys("Automatizacion23");
        Thread.sleep(3000);

         */

        // ************************ Localizador por "cssSelector" 2

        /* WebElement demoSite = driver.findElement(By.cssSelector("div#site-name"));
        demoSite.click();
        Thread.sleep(3000);

         */

        // ************************ Localizador por "cssSelector" 3

        /* WebElement demoSite = driver.findElement(By.cssSelector("#site-name"));
        demoSite.click();
        Thread.sleep(3000);

         */

        // ************************ Localizador por "cssSelector" 4

        /*WebElement userName = driver.findElement(By.cssSelector("input[type='text'][name='userName']"));
        userName.sendKeys("Automatizacion");
        Thread.sleep(3000);
         */


        // ************************  "Xpaths" ************************
        /*
        Existen dos tiposde XPATHS son: Absoluto y Relativo


        XPATH Absoluto por buena practicas NO se deben utilizar o bien no abusar de el.
        Diferencias:
        El xpath absoluto es toda la ruta del elemento, es decir, la ubicación del mismo y su sintaxis inicia con
        una diagonal
         */


        /*
        WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
        userName.sendKeys("Locura");
        Thread.sleep(3000);

         */

        //********************************** Xpath Relativo ********************************
        /*
        - El uso de xpath relativo inicia con un DOBLE (diagonal) " // "
        - El uso de xpath relativo se realiza por medio de los tags y atributo,
        entiendase que tags, son: span, img, button, input, etc...

         */

        //1. Un atributo

        /*WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("VidalLG");
        Thread.sleep(3000);*/

        //2. Dos atributos
        /*WebElement demoSite = driver.findElement(By.xpath("//a[@title='Home' and @style='font-size:32px;']"));
        demoSite.click();
        Thread.sleep(3000);*/

        //3.Uso de xpath usando contains, con: "*" o "tag" , cabe mencionar que se puede utulizar uno u otro

        WebElement demoSite = driver.findElement(By.xpath("//*[contains(text(), 'Demo Site')]"));
        demoSite.click();
        Thread.sleep(3000);













    }



    @AfterTest
    public void TearDown (){

        //Cierra el navegador
        driver.close();
        driver.quit();
    }





}
