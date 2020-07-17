package pages.stage6.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver otherDriver) {
        driver = otherDriver;
    }

    public WebElement findElement(By by){
        try{
            if(waitForElementEnabled(by))
                return driver.findElement(by);
            else
                return null;
        }catch (Exception e) {
            return null;
        }
    }

    public boolean typeOnElement(WebElement element, String data){
        try{
            if(waitForElementVisible(element)){
                element.sendKeys(data);
                return true;}
        }catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean clickOnElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                element.click();
                return true;}
        }catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean clearElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                element.clear();
                return true;}
        }catch (Exception e) {
            return false;
        }
        return false;
    }

    public String getTextFromElement(WebElement element){
        try{
            if(waitForElementVisible(element)){
                return element.getText();}
        }catch (Exception e) {
            return null;
        }
        return null;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return(element.isEnabled()
                    && element.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try{
           return waitForElementVisible(element);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean waitForElementVisible(WebElement element)
    {
        try{
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e){
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
        catch (Exception e){
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
        catch (Exception e){
            return false;
        }
    }

}
