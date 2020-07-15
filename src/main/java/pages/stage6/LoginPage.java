package pages.stage6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage6.utilities.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "ctl00_LoginView_LoginLink")
    WebElement loginLink;
    @FindBy(id = "ctl00_LoginView_MemberLoginStatus")
    WebElement logoutLink;
    @FindBy(id = "ctl00_LoginView_RegisterLink")
    WebElement registrerLink;
    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    WebElement browseAllCategoriesLink;
    @FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
    WebElement homeTab;
    @FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
    WebElement myAdsProfileTab;
    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    WebElement postAnAdTab;
    @FindBy(id = "ctl00_LoginView_MemberName")
    WebElement memberName;
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

    public void clearElementsLoginPage(){
        clearElemnt(getUsernameElement());
        clearElemnt(getPasswordElement());
    }

    public boolean isUserLogedIn(String userName){

        if(isElementDisplayed(getMemberNameElement())){
            if(userName.equals(getTextFromElement(getMemberNameElement()))) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyLoads(String userName){
        boolean isLoad=false;
        if(isElementDisplayed(getHomeTabElement()) &&
                isElementDisplayed(getPostAnAdTabElement()) &&
                isElementDisplayed(getMyAdsProfileTabElement()) &&
                isElementDisplayed(getUsernameElement()) &&
                isElementDisplayed(getPasswordElement()) &&
                isElementDisplayed(getLoginButtonElement())){
                isLoad=true;
        }
        return isLoad;
    }

    public HomePage logIn(String userName, String password){

        clearElementsLoginPage();
        typeOnElement(getUsernameElement(),userName );
        typeOnElement(getPasswordElement(),password);
        clickOnElemnt(getLoginButtonElement());

        return new HomePage(driver);
    }

    public boolean verifyErrorMessage(String message)
    {
        By messageElement = By.xpath("//td[contains(.,'"+message+"') and contains(@style,'Red')]");
        if(findElement(messageElement).isDisplayed()) {
            return true;
        }
        return false;
    }

    public void goToLogin(){
        clickOnElemnt(getLoginLinkElement());
    }

    public void goToRegister(){ clickOnElemnt(getRegistrerLinkElement());}

}
