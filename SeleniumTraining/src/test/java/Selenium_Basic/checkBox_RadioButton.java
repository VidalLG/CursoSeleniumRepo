package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class checkBox_RadioButton {
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException {

        System.setProperty("webdiver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        Thread.sleep(3000);
        driver.manage().deleteAllCookies();
    }

    // Validar:
    // 1. Verificar que se muestre el elemento con el cual vamos a interacturar, antes de cualquier operacion
    // 2. Verificar que los radio button o check box esten habilitados
    // 3. Verificar que seleccion predeterminada del boton ya sea, radio o check


    @Test
    public void checkBoxAndRadioButton () throws InterruptedException {

        WebElement radioButtonMale = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));

        //isDisplayed  :  lo que nos regresa es un valor booleano, si devuelve, verdadero, entonces
        // dicho boton esta presente, si es falso, entonces el boton no esta presente.



        //isEnabled()  : Lo que nos regresa es un valor booleano, si devuelve verdadero, entonces
        //el boton esta habilitado, si regresa falso, el boton no esta presente.

        //isSelected ()  :  lo que nos regresa es un valor booleano, si devuelve verdadero, entonces,
        // el boton esta seleccionado, si regresa falso, el boton no esta presente.




        boolean statusDisplayed = radioButtonMale.isDisplayed();
        //Thread.sleep(3000);

        boolean statusEnable = radioButtonMale.isEnabled();
        //Thread.sleep(3000);

        radioButtonMale.click();
        //si queremos validar si esta seleccionado o no el boton, ocupamos isSelected
        boolean statusSelected = radioButtonMale.isSelected();
        Thread.sleep(3000);

        System.out.println("Status Displayed: "+ statusDisplayed);
        System.out.println("Status Enable: "+ statusEnable);


        System.out.println("Status Selected: "+ statusSelected);









       /* WebElement getCheck = driver.findElement(By.id("buttoncheck"));
        getCheck.click();
        Thread.sleep(3000);

        */

    }

    @AfterTest
    public void TearDown (){
        driver.close();
        driver.quit();
    }




}
