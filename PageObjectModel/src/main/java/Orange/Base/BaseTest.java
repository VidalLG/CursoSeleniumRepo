package Orange.Base;

import Orange.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    public static Properties properties;

    public BaseTest (){
        try{
            properties = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"src/main/java/Orange" + "/Config/config.properties");
            properties.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equals("fireFox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }


}
