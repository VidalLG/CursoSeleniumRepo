package Orange.Pages;

import Orange.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;




}
