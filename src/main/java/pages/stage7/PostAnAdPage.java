package pages.stage7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

import java.util.List;

public class PostAnAdPage extends BasePage {


    @FindBy(id = "ctl00_Main_PostAdWizard_StartNavigationTemplateContainerID_StartNextButton")
    WebElement nextButton;
    @FindBy(xpath="//h2[contains(.,'Post an Ad: Category Selection')]")
    WebElement postAnAdPageTitle;
    @FindBy (xpath = "//table[@id='ctl00_Main_PostAdWizard_SubcategoriesList']//td//a")
    private List<WebElement> categoriesList;

    public PostAnAdPage(WebDriver otherDriver) {
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


}
