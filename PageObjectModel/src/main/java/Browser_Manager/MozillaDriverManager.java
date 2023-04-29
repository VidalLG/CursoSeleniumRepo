package Browser_Manager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaDriverManager extends DriverManager{

    @Override
    public void createDriver(){
        System.setProperty("webdriver.gecko.driver","src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();


    }
}
