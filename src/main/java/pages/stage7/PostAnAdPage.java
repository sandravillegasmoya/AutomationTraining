package pages.stage7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class PostAnAdPage extends BasePage {


    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl00_CategoryButton")
    WebElement antiquesCollectiblesCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl01_CategoryButton")
    WebElement artsCraftsCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl02_CategoryButton")
    WebElement autoCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl03_CategoryButton")
    WebElement electronicsCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl04_CategoryButton")
    WebElement gardenCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl05_CategoryButton")
    WebElement homeCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_SubcategoriesList_ctl06_CategoryButton")
    WebElement musicCategoryButton;
    @FindBy(id = "ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton")
    WebElement nextButton;
    @FindBy(xpath="//h2[contains(.,'Post an Ad: Category Selection')]")
    WebElement postAnAdPageTitle;

    public PostAnAdPage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getAntiquesCollectiblesCategoryButton()
    {
        return antiquesCollectiblesCategoryButton;
    }

    public WebElement getArtsCraftsCategoryButton()
    {
        return artsCraftsCategoryButton;
    }

    public WebElement getAutoCategoryButton()
    {
        return autoCategoryButton;
    }

    public WebElement getElectronicsCategoryButton()
    {
        return electronicsCategoryButton;
    }

    public WebElement getGardenCategoryButton() {
        return gardenCategoryButton;
    }

    public WebElement getHomeCategoryButton()
    {
        return homeCategoryButton;
    }

    public WebElement getMusicCategoryButton()
    {
        return musicCategoryButton;
    }

    public WebElement getNextButton()
    {
        return nextButton;
    }

    public WebElement getPostAnAdPageTitle()
    {
        return postAnAdPageTitle;
    }


}
