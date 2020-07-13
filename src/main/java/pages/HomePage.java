package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utilities.BasePage;

public class HomePage extends BasePage{

    private By loginLink = By.id("ctl00_LoginView_LoginLink");

    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
    }


}
