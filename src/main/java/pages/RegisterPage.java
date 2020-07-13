package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.utilities.BasePage;

public class RegisterPage extends BasePage {

    private By registrerLink = By.id("ctl00_LoginView_RegisterLink");
    private By registerTitle = By.xpath("//h2[contains(.,'Register')]");
    private By firsNameField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstName");
    private By lastNameField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastName");
    private By emailField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Email");
    private By userNameField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserName");
    private By passwordField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password");
    private By confirmPasswordField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPassword");
    private By securityQuestionField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Question");
    private By securityAnswerField = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Answer");
    private By stepNextButton = By.id("ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton");
    private By firtsNameRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_FirstNameRequired");
    private By lastNameRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_LastNameRequired");
    private By emailRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_EmailRequired");
    private By userNameRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_UserNameRequired");
    private By passwordRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordRequired");
    private By confirmPasswordRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_ConfirmPasswordRequired");
    private By securityQuestionRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_QuestionRequired");
    private By securityAnswerRequiredMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_AnswerRequired");
    private By alreadyExistUserMessage = By.id("ctl00_Main_InfoLabel");
    private By PasswordsDoNotMatchMessage = By.id("ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_PasswordCompare");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }



    public void clearElementsRegisterPage(){
        clearElemnt(getConfirmPasswordField());
        clearElemnt(getEmailField());
        clearElemnt(getFirsNameField());
        clearElemnt(getLastNameField());
        clearElemnt(getSecurityQuestionField());
        clearElemnt(getSecurityAnswerField());
        clearElemnt(getUserNameField());
        clearElemnt(getPasswordField());
    }


}
