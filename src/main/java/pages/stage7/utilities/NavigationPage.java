package pages.stage7.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.*;

public class NavigationPage{

    @FindBy(id = "ctl00_LoginView_LoginLink")
    WebElement loginLink;
    @FindBy(id = "ctl00_LoginView_MemberLoginStatus")
    WebElement logoutLink;
    @FindBy(id = "ctl00_LoginView_RegisterLink")
    WebElement registerLink;
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

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAdsProfilePage myAdsProfilePage;
    private PostAnAdPage postAnAdPage;
    private RegisterPage registerPage;
    private BrowseAllCategoriesPage browseAllCategoriesPage;

    public WebDriver driver;

    public NavigationPage(WebDriver otherDriver) {
        driver = otherDriver;
        PageFactory.initElements(driver,this);
    }

    public HomePage goToHomePage(){
        homeTab.click();
        return homePage = new HomePage(driver);
    }

    public PostAnAdPage goToPostAnAd(){
        postAnAdTab.click();
        return  postAnAdPage = new PostAnAdPage(driver);
    }

    public MyAdsProfilePage goToMyAdsProfile(){
        myAdsProfileTab.click();
        return myAdsProfilePage = new MyAdsProfilePage(driver);
    }

    public LoginPage goToLogin(){
        loginLink.click();
        return loginPage = new LoginPage(driver);
    }

    public RegisterPage goToRegister(){
        registerLink.click();
        return registerPage = new RegisterPage(driver);
    }

    public BrowseAllCategoriesPage goToBrowseAllCategoriesPage(){
        browseAllCategoriesLink.click();
        return browseAllCategoriesPage = new BrowseAllCategoriesPage(driver);
    }

    public boolean isUserLogIn(String userName){
        if(memberName.isDisplayed()){
            if(userName.equals(memberName.getText())) {
                return true;
            }
        }
        return false;
    }
}
