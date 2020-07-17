package pages.stage7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath="//div[@id='col_main_right']/h2[@class='section']")
    WebElement loginTitlePage;
    @FindBy(id="ctl00_Main_LoginConrol_UserName")
    WebElement usernameField;
    @FindBy(id="ctl00_Main_LoginConrol_Password")
    WebElement passwordField;
    @FindBy(id="ctl00_Main_LoginConrol_LoginButton")
    WebElement loginButton;
    @FindBy(id="//td[contains(.,'Your login attempt was not successful. Please try again.') and contains(@style,'Red')]")
    WebElement notSuccessLoginMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clearElementsLoginPage(){
        clearElement(usernameField);
        clearElement(passwordField);
    }

    public void logIn(String userName, String password){
        clearElementsLoginPage();
        typeOnElement(usernameField,userName );
        typeOnElement(passwordField,password);
        clickOnElement(loginButton);
    }

    public boolean verifyMessage(String message)
    {
        By messageElement = By.xpath("//td[contains(.,'"+message+"') and contains(@style,'Red')]");
        if(findElement(messageElement).isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean verifyLoads(){
        return(isElementDisplayed(usernameField) &&
                isElementDisplayed(passwordField) &&
                isElementDisplayed(loginButton));
    }

}
