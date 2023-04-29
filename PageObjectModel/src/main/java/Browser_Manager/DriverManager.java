package Browser_Manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createDriver();
    public void QuitDriver(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
    public void GetDriver(){
        if (driver == null){
            createDriver();
        }
    }



}
