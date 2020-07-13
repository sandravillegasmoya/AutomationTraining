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
        if(waitForElementEnabled(by))
            return driver.findElement(by);
        else
            return null;
    }

    public void typeOnElement(WebElement element, String data){
        element.sendKeys(data);
    }

    public void clickOnElemnt(WebElement element){
        element.click();
    }

    public void clearElemnt(WebElement element){
        element.clear();
    }

    public String getTextFromElement(WebElement element)
    {
        return element.getText();
    }

    public boolean isElementPresent(WebElement element) {

        try {
            if(element.isDisplayed())
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
                if(element.isDisplayed()) {
                    isDisplayed = true;
                }
            }
        }
        catch (NoSuchElementException e)
        {
            isDisplayed= false;
        }
        return isDisplayed;
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

}
