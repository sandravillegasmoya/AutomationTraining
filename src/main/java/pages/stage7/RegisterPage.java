package pages.stage7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.stage7.utilities.BasePage;

public class RegisterPage extends BasePage {

    @FindBy(xpath="//h2[contains(.,'Register')]")
    WebElement registerTitle;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName")
    WebElement firsNameField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName")
    WebElement lastNameField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email")
    WebElement emailField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName")
    WebElement userNameField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password")
    WebElement passwordField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword")
    WebElement confirmPasswordField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question")
    WebElement securityQuestionField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer")
    WebElement securityAnswerField;
    @FindBy(id="ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton")
    WebElement stepNextButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getRegisterTitleElement()
    {
        return registerTitle;
    }

    public WebElement getFirsNameFieldElement()
    {
        return firsNameField;
    }

    public WebElement getLastNameFieldElement()
    {
        return lastNameField;
    }

    public WebElement getEmailFieldElement()
    {
        return emailField;
    }

    public WebElement getUserNameFieldElement()
    {
        return userNameField;
    }

    public WebElement getConfirmPasswordFieldElement()
    {
        return confirmPasswordField;
    }

    public WebElement getSecurityQuestionFieldElement()
    {
        return securityQuestionField;
    }

    public WebElement getSecurityAnswerFieldElement()
    {
        return securityAnswerField;
    }

    public WebElement getPasswordFieldElement()
    {
        return passwordField;
    }

    public WebElement getStepNextButtonElement()
    {
        return stepNextButton;
    }

    public void clearElementsRegisterPage(){
        clearElemnt(getConfirmPasswordFieldElement());
        clearElemnt(getEmailFieldElement());
        clearElemnt(getFirsNameFieldElement());
        clearElemnt(getLastNameFieldElement());
        clearElemnt(getSecurityQuestionFieldElement());
        clearElemnt(getSecurityAnswerFieldElement());
        clearElemnt(getUserNameFieldElement());
        clearElemnt(getPasswordFieldElement());
    }

    public boolean verifyErrorMessage(String message){
        By messageElement = By.xpath("//span[contains(.,'"+message+"' )]");

        if(findElement(messageElement).isDisplayed()) {
            return true;
        }
        return false;
    }
}
