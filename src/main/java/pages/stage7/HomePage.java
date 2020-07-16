package pages.stage7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage6.LoginPage;
import pages.stage6.RegisterPage;
import pages.stage7.utilities.BasePage;

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

    @FindBy (xpath = "//td//a")
    private List<WebElement> categoriesList;

    private BrowseAllCategoriesPage browseAllCategoriesPage;

    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public boolean verifyLoads(){
        boolean displayed= false;
        for(WebElement category : categoriesList){
            if(isElementDisplayed(category)){
                displayed = true;
            }else return false;
        }
        return displayed;
    }

    public BrowseAllCategoriesPage selectCategory(String categorySelected){
        for(WebElement category : categoriesList){
            if(getTextFromElement(category).equals(categorySelected)){
                category.click();
            }
        }
        return browseAllCategoriesPage =  new BrowseAllCategoriesPage(driver);
    }

}
