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

    public WebDriver driver;

    public NavigationPage(WebDriver otherDriver) {
        driver = otherDriver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getRegistrerLinkElement()
    {
        return registerLink;
    }

    public WebElement getLoginLinkElement()
    {
        return loginLink;
    }

    public WebElement getLogoutLinkElement()
    {
        return logoutLink;
    }

    public WebElement getBrowseAllCategoriesLinkElement()
    {
        return browseAllCategoriesLink;
    }

    public WebElement getHomeTabElement()
    {
        return homeTab;
    }

    public WebElement getMyAdsProfileTabElement()
    {
        return myAdsProfileTab;
    }

    public WebElement getPostAnAdTabElement()
    {
        return postAnAdTab;
    }

    public HomePage goToHomePage(){
        homePage = new HomePage(driver);
        getHomeTabElement().click();
        return homePage;
    }

    public PostAnAdPage goToPostAnAd(){
        postAnAdPage = new PostAnAdPage(driver);
        getPostAnAdTabElement().click();
        return postAnAdPage;
    }

    public MyAdsProfilePage goToMyAdsProfile(){
        myAdsProfilePage = new MyAdsProfilePage(driver);
        getMyAdsProfileTabElement().click();
        return myAdsProfilePage;
    }

    public LoginPage goToLogin(){
        loginPage = new LoginPage(driver);
        getLoginLinkElement().click();
        return loginPage;
    }

    public RegisterPage goToRegister(){
        registerPage = new RegisterPage(driver);
        getRegistrerLinkElement().click();
        return registerPage;
    }

    public WebElement getMemberNameElement()
    {
        return memberName;
    }

    public boolean isUserLogedIn(String userName){

        if(getMemberNameElement().isDisplayed()){
            if(userName.equals(getMemberNameElement().getText())) {
                return true;
            }
        }
        return false;
    }
}
