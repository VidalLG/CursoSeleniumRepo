package Selenium_Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {
        private WebDriver driver;

        @BeforeTest
        public void Setup() throws InterruptedException{
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/upload/");
            driver.manage().deleteAllCookies();
        }


        @Test
        public void UploadFile() throws InterruptedException {

            WebElement uploadFile = driver.findElement(By.name("uploadfile_0"));
            uploadFile.sendKeys("C:\\Users\\Administrador\\Documents\\Automatización\\GIT\\SELENIUM_REPO\\CursoSeleniumRepo\\SeleniumTraining\\src\\test\\java\\UploadFile\\docUpload.txt");
            Thread.sleep(3000);
        }

        @AfterTest
        public void TearDown()
        {
            //Cierra el navegador
            driver.close();
            driver.quit();
        }


    }



