package pages.stage7;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class HomePage extends BasePage {

    @FindBy(id = "ctl00_SecondBar_CommonSearchTextBox")
    WebElement searchTexBox;
    @FindBy(id = "ctl00_SecondBar_CommonSearchButton")
    WebElement searchButton;
    @FindBy(id = "ctl00_SecondBar_CommonWhatsNewRangeList")
    WebElement whatsNewRangeList;
    @FindBy(id = "ctl00_SecondBar_CommonWhatsNewButton")
    WebElement whatsNewButton;

    @FindBy(xpath = "//a[contains(.,'Go to My Ads & Profile')]")
    WebElement goToMyAdsLink;
    @FindBy(xpath = "//a[contains(.,'Place a New Ad')]")
    WebElement placeNewAdLink;

    @FindBy(xpath = "//h[contains(.,'Browse Categories')]")
    WebElement browseCategoriesTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
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
    WebElement musicCategoryLink;

    public BrowseCategoriesPage browseCategoriesPage;

    public HomePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getAntiquesCollectiblesCategoryLinkElement()
    {
        return antiquesCollectiblesCategoryLink;
    }

    public WebElement getArtsCraftsCategoryLinkElement()
    {
        return artsCraftsCategoryLink;
    }

    public WebElement getPersonalArtsCraftsSubCategoryLinkElement()
    {
        return personalArtsCraftsSubCategoryLink;
    }

    public WebElement getAutoCategoryLinkElement()
    {
        return autoCategoryLink;
    }

    public WebElement getHondaAutoSubCategoryLinkElement()
    {
        return hondaAutoSubCategoryLink;
    }

    public WebElement getNissanAutoSubCategoryLinkElement()
    {
        return nissanAutoSubCategoryLink;
    }

    public WebElement getToyotaAutoSubCategoryLinkElement()
    {
        return toyotaAutoSubCategoryLink;
    }

    public WebElement getElectronicsCategoryLinkElement()
    {
        return electronicsCategoryLink;
    }

    public WebElement getGardenCategoryLinkElement()
    {
        return gardenCategoryLink;
    }

    public WebElement getHomeCategoryLinkElement()
    {
        return homeCategoryLink;
    }

    public WebElement getMusicCategoryLinkElement()
    {
        return musicCategoryLink;
    }

    public WebElement getBrowseCategoriesTitle()
    {
        return browseCategoriesTitle;
    }

    public WebElement getSearchTexBox()
    {
        return searchTexBox;
    }

    public WebElement getSearchButton()
    {
        return searchButton;
    }

    public WebElement getWhatsNewRangeList()
    {
        return whatsNewRangeList;
    }

    public WebElement getWhatsNewButton()
    {
        return whatsNewButton;
    }

    public WebElement getGoToMyAdsLink()
    {
        return goToMyAdsLink;
    }

    public WebElement getPlaceNewAdLink()
    {
        return placeNewAdLink;
    }

    public BrowseCategoriesPage goToBrowseCategories(WebElement element){
        browseCategoriesPage = new BrowseCategoriesPage(driver);
        element.click();
        return browseCategoriesPage;
    }

}
