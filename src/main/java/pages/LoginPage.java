package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.utilities.BasePage;

public class LoginPage extends BasePage {

    private By loginLink = By.id("ctl00_LoginView_LoginLink");
    private By loginTitlePage = By.xpath("//h2[contains(.,'Login')]");
    private By username = By.id("ctl00_Main_LoginConrol_UserName");
    private By password = By.id("ctl00_Main_LoginConrol_Password");
    private By loginButton = By.id("ctl00_Main_LoginConrol_LoginButton");
    private By memberName = By.id("ctl00_LoginView_MemberName");
    private By notSuccessLoginMessage = By.xpath("//td[contains(.,'Your login attempt was not successful. Please try again.') and contains(@style,'Red')]");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement getLoginTitlePage()
    {
        return findElement(loginTitlePage);
    }

    public WebElement getLoginLink()
    {
        return findElement(loginLink);
    }

    public WebElement getUsername()
    {
        return findElement(username);
    }

    public WebElement getPassword()
    {
        return findElement(password);
    }

    public WebElement getLoginButton()
    {
        return findElement(loginButton);
    }

    public WebElement getMemberName()
    {
        return findElement(memberName);
    }

    public WebElement getInvalidLoginMessage()
    {
        return findElement(notSuccessLoginMessage);
    }

    public void clearElementsLoginPage(){
        clearElement(getUsername());
        clearElement(getPassword());
    }

}
