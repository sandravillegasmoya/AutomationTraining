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
    WebElement username;
    @FindBy(id="ctl00_Main_LoginConrol_Password")
    WebElement password;
    @FindBy(id="ctl00_Main_LoginConrol_LoginButton")
    WebElement loginButton;
    @FindBy(id="//td[contains(.,'Your login attempt was not successful. Please try again.') and contains(@style,'Red')]")
    WebElement notSuccessLoginMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getLoginTitlePageElement()
    {
        return loginTitlePage;
    }

    public WebElement getUsernameElement()
    {
        return username;
    }

    public WebElement getPasswordElement()
    {
        return password;
    }

    public WebElement getLoginButtonElement()
    {
        return loginButton;
    }

    public WebElement getInvalidLoginMessageElement()
    {
        return notSuccessLoginMessage;
    }

    public void clearElementsLoginPage(){
        clearElemnt(getUsernameElement());
        clearElemnt(getPasswordElement());
    }

    public void logIn(String userName, String password){
        clearElementsLoginPage();
        typeOnElement(getUsernameElement(),userName );
        typeOnElement(getPasswordElement(),password);
        clickOnElemnt(getLoginButtonElement());
    }

    public boolean verifyErrorMessage(String message)
    {
        By messageElement = By.xpath("//td[contains(.,'"+message+"') and contains(@style,'Red')]");
        if(findElement(messageElement).isDisplayed()) {
            return true;
        }
        return false;
    }

}
