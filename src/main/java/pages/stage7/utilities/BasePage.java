package pages.stage7.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;
    public NavigationPage navigation;

    public BasePage(WebDriver otherDriver) {
        driver = otherDriver;
        navigation = new NavigationPage(driver);
    }

    public WebElement findElement(By by){
        try{
            if(waitForElementEnabled(by))
                return driver.findElement(by);
            else
                return null;
        }catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean typeOnElement(WebElement element, String data){
        try{
            if(waitForElementVisible(element)){
                element.sendKeys(data);
                return true;}
        }catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public boolean clickOnElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                element.click();
                return true;}
        }catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public boolean clearElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                element.clear();
                return true;}
        }catch (NoSuchElementException e) {
            return false;
        }
        return false;
    }

    public String getTextFromElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                return element.getText();}
        }catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            if(element.isEnabled() && element.isDisplayed())
                return true;
            else
                return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element){
        boolean isDisplayed=false;
        try{
            if(waitForElementVisible(element))
            {
                isDisplayed = true;
            }
        }
        catch (NoSuchElementException e)
        {
            isDisplayed= false;
        }
        return isDisplayed;
    }

    public String getOptionSelected(WebElement element){

        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        System.out.println(defaultItem );
        return defaultItem;
    }

    public boolean waitForElementVisible(WebElement element)
    {
        try{
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean waitForElementEnabled(By element)
    {
        try{
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean waitForElementNotVisible(WebElement element)
    {
        try{
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean verifyLoads(WebDriver driver, WebElement element){

        boolean isLoad =  false;

        try{
            if (!((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
                wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.visibilityOf(element));
            }
            isLoad = true;
        }
        catch (NoSuchElementException e){
            isLoad =  false;
        }

        return isLoad;

    }
}
