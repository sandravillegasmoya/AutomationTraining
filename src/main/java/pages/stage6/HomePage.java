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
   /*@FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
    WebElement antiquesCollectiblesCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
    WebElement artsCraftsCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_NestedSubCategoryRepeater_ctl01_SubCategoryButton")
    WebElement personalArtsCraftsSubCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
    WebElement autoCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_NestedSubCategoryRepeater_ctl01_SubCategoryButton")
    WebElement hondaAutoSubCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_NestedSubCategoryRepeater_ctl02_SubCategoryButton")
    WebElement nissanAutoSubCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_NestedSubCategoryRepeater_ctl03_SubCategoryButton")
    WebElement toyotaAutoSubCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")
    WebElement electronicsCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")
    WebElement gardenCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")
    WebElement homeCategoryLink;
    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")
    WebElement musicCategoryLink;*/

    @FindBy(xpath = "//td//h4")
    private List<WebElement> categoriesList;

    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getMemberNameElement()
    {
        return memberName;
    }

    //    eliminar isElementDisplayed
    //      verificar que se presentan los elementos escenciales de la pag home
    //          verificar hometab
    public boolean verifyLoads(String userName){
        boolean isLoad=false;
        if(isElementDisplayed(getHomeTabElement()) &&
                isElementDisplayed(getPostAnAdTabElement()) &&
                isElementDisplayed(getMyAdsProfileTabElement())){
            if(isUserLogedIn(userName)){
                if(isElementDisplayed(getLogoutLinkElement())){
                    isLoad=true;
                }
            }else{
                if(isElementDisplayed(getLoginLinkElement())){
                    isLoad=true;
                }
            }
        }
        return isLoad;
    }

    public boolean isUserLogedIn(String userName){

        if(isElementDisplayed(getMemberNameElement())){
            if(userName.equals(getTextFromElement(getMemberNameElement()))) {
                return true;
            }
        }
        return false;
    }

    public void goToHomePage(){
        clickOnElemnt(getHomeTabElement());
    }

    public void goToPostAnAd(){
        clickOnElemnt(getPostAnAdTabElement());
    }

    public void goToMyAdsProfile(){
        clickOnElemnt(getMyAdsProfileTabElement());
    }

}
