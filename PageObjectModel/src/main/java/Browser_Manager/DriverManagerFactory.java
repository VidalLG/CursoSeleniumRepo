package Browser_Manager;

import java.lang.reflect.Type;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type){
        DriverManager driverManager = null;
        switch (type){
            case CHROME :
                driverManager = new ChromeDriverManager();
                break;

            case MOZILLA :
                driverManager = new MozillaDriverManager();
                break;

            default:
                System.out.println("Invalid Browser Select");
                break;
        }
        return driverManager;

    }


}
