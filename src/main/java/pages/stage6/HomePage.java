package pages.stage6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage6.utilities.BasePage;

import java.util.List;

public class HomePage extends BasePage {

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

    RegisterPage registerPage;
    LoginPage loginPage;

    @FindBy (xpath = "//td//h4")
    private List<WebElement> categoriesList;

    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public boolean verifyLoads(String userName){
        boolean displayed= false;
        for(WebElement category : categoriesList){
            if(isElementDisplayed(category)){
                displayed = true;
            }else return false;
        }
        return displayed;
    }

    public boolean isUserLogedIn(String userName){

        if(isElementDisplayed(memberName)){
            return(userName.equals(getTextFromElement(memberName)));
        }
        return false;
    }

    public LoginPage goToLogin(){
        clickOnElement(loginLink);
        return loginPage = new LoginPage(driver);
    }

    public void goToPostAnAd(){
        clickOnElement(postAnAdTab);
    }

    public void goToMyAdsProfile(){
        clickOnElement(myAdsProfileTab);
    }

    public RegisterPage goToRegister(){
        clickOnElement(registrerLink);
        return registerPage = new RegisterPage(driver);
    }

}
