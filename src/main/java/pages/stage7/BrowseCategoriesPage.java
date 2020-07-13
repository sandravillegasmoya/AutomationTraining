package pages.stage7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class BrowseCategoriesPage extends BasePage {

    @FindBy(id="ctl00_Main_SearchTermTextBox")
    WebElement searchTermTextBox;
    @FindBy(id="ctl00_Main_CategoryDropDown_CategoryList")
    WebElement categoryDropDown;
    @FindBy(id="ctl00_Main_SearchButton")
    WebElement searchButton;
    @FindBy(id="ctl00_Main_SubcategoriesList")
    WebElement subcategoriesList;

    public BrowseCategoriesPage(WebDriver otherDriver) {
        super(otherDriver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getSearchTermTextBox()
    {
        return searchTermTextBox;
    }

    public WebElement getCategoryDropDown()
    {
        return categoryDropDown;
    }

    public WebElement getSearchButton()    {
        return searchButton;
    }

    public WebElement getSubcategoriesList()
    {
        return subcategoriesList;
    }

}
