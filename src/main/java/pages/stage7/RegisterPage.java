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


    public void clearElementsRegisterPage(){
        clearElement(confirmPasswordField);
        clearElement(emailField);
        clearElement(firsNameField);
        clearElement(lastNameField);
        clearElement(securityQuestionField);
        clearElement(securityAnswerField);
        clearElement(userNameField);
        clearElement(passwordField);
    }

    public void fillRegisterForm(String firstName,
                                 String lastName,
                                 String email,
                                 String userName,
                                 String password,
                                 String confirmPassword,
                                 String securityQuestion,
                                 String securityAnswer){

        typeOnElement(firsNameField,firstName);
        typeOnElement(lastNameField,lastName);
        typeOnElement(emailField,email);
        typeOnElement(userNameField,userName);
        typeOnElement(passwordField,password);
        typeOnElement(confirmPasswordField,confirmPassword);
        typeOnElement(securityQuestionField,securityQuestion);
        typeOnElement(securityAnswerField,securityAnswer);

    }

    public void gotoNextStep(){clickOnElement(stepNextButton);}

    public boolean verifyErrorMessage(String message){
        By messageElement = By.xpath("//span[contains(.,'"+message+"' )]");
        return(findElement(messageElement).isDisplayed());
    }

    public boolean verifyLoads(){
        return(isElementDisplayed(firsNameField) &&
                isElementDisplayed(lastNameField) &&
                isElementDisplayed(emailField) &&
                isElementDisplayed(passwordField) &&
                isElementDisplayed(confirmPasswordField) &&
                isElementDisplayed(securityAnswerField) &&
                isElementDisplayed(securityQuestionField) &&
                isElementDisplayed(stepNextButton));
    }
}
