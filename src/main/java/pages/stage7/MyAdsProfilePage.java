package pages.stage7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class MyAdsProfilePage extends BasePage {

    @FindBy(id = "ctl00_Main_CommonSearchTextBox")
    WebElement searchField;
    @FindBy(id = "ctl00_Main_CommonCategoryDropDown_CategoryList")
    WebElement categoryDropDown;
    @FindBy(id = "ctl00_Main_SearchButton")
    WebElement searchButton;
    @FindBy(id = "ctl00_Main_AdvancedSearchLink")
    WebElement advancedSearchLink;
    @FindBy(id = "ctl00_Main_CurrentAdsButton")
    WebElement currentAdsButton;
    @FindBy(id = "ctl00_Main_InactiveAdsButton")
    WebElement inactiveAdsButton;
    @FindBy(id = "ctl00_Main_SavedAdsButton")
    WebElement savedAdsButton;
    @FindBy(id = "ctl00_Main_ActivationAdsButton")
    WebElement activationAdsButton;
    @FindBy(id = "ctl00_Main_ProfileLink")
    WebElement profileLink;
    @FindBy(xpath="//h2[contains(.,'My Current Ads')]")
    WebElement myCurrentAdsTitle;

    public MyAdsProfilePage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public boolean verifyLoads(){
        return(isElementPresent(categoryDropDown)&&
                isElementPresent(searchButton) &&
                isElementPresent(searchField));
    }

}
