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
    WebElement memberNameLabel;
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

    public boolean isUserLogedIn(String userName){
        if(isElementDisplayed(memberNameLabel)){
            return(userName.equals(getTextFromElement(memberNameLabel)));
        }
        return false;
    }

    public boolean verifyLoads(){
        return(isElementDisplayed(usernameField) &&
                isElementDisplayed(passwordField) &&
                isElementDisplayed(loginButton));
    }

    public void goToHomePage(){
        clickOnElement(homeTab);
    }

    public void goToPostAnAd(){
        clickOnElement(postAnAdTab);
    }

    public void goToMyAdsProfile(){
        clickOnElement(myAdsProfileTab);
    }

    public void goToRegister(){
        clickOnElement(registrerLink);
    }

    public HomePage logIn(String userName, String password){

        clearElementsLoginPage();
        typeOnElement(usernameField,userName );
        typeOnElement(passwordField,password);
        clickOnElement(loginButton);

        return new HomePage(driver);
    }

    public boolean verifyMessage(String message)
    {
        By messageElement = By.xpath("//td[contains(.,'"+message+"') and contains(@style,'Red')]");
        return(findElement(messageElement).isDisplayed());
    }



}
