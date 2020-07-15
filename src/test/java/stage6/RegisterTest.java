package stage6;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.stage6.HomePage;
import pages.stage6.RegisterPage;
import utilies.BaseTest;

import static org.testng.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserType","executionType"})
    public void setUp(String browserType, String executionType) throws Exception {
        driver = createDriver(browserType, executionType);
        driver.get("http://qa-trainingw7:86/");
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("Deleting Driver");
        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Starting Execution");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Completing Execution");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Executing class: RegistrerTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: RegistrerTest");
    }


    @Test
    public void testVerifyRegistrerLink() throws Exception {
       driver.get("http://qa-trainingw7:86/");
       registerPage.goToRegister();
       assertTrue(registerPage.isElementPresent(registerPage.getRegisterTitleElement()));
    }

    @Test
    public void testValidateMandatoryMessages() throws Exception {
        registerPage.goToRegister();
        registerPage.clearElementsRegisterPage();
        registerPage.clickOnElemnt(registerPage.getStepNextButtonElement());
        assertTrue(registerPage.verifyErrorMessage("First name is required."));
        assertTrue(registerPage.verifyErrorMessage("Last name is required."));
        assertTrue(registerPage.verifyErrorMessage("Email is required."));
        assertTrue(registerPage.verifyErrorMessage("User name is required."));
        assertTrue(registerPage.verifyErrorMessage("Password is required."));
        assertTrue(registerPage.verifyErrorMessage("Confirm password is required."));
        assertTrue(registerPage.verifyErrorMessage("Security question is required."));
        assertTrue(registerPage.verifyErrorMessage("Security answer is required."));
    }

    @Test
    public void testVerifyUserNameAlreadyTaken() throws Exception {
        registerPage.goToRegister();
        registerPage.clearElementsRegisterPage();
        registerPage.typeOnElement(registerPage.getFirsNameFieldElement(),"Sandra");
        registerPage.typeOnElement(registerPage.getLastNameFieldElement(),"Villegas");
        registerPage.typeOnElement(registerPage.getEmailFieldElement(),"test@avantica.com");
        registerPage.typeOnElement(registerPage.getUserNameFieldElement(),"svillegas");
        registerPage.typeOnElement(registerPage.getPasswordFieldElement(),"!123Test");
        registerPage.typeOnElement(registerPage.getConfirmPasswordFieldElement(),"!123Test");
        registerPage.typeOnElement(registerPage.getSecurityQuestionFieldElement(),"test");
        registerPage.typeOnElement(registerPage.getSecurityAnswerFieldElement(),"test");
        registerPage.clickOnElemnt(registerPage.getStepNextButtonElement());
       assertTrue(registerPage.verifyErrorMessage("User name already exists. Please enter a different user name."));
    }

    @Test
    public void testVerifyMismatchedPasswords() throws Exception {
        registerPage.clickOnElemnt(registerPage.getRegistrerLinkElement());
        registerPage.clearElementsRegisterPage();
        registerPage.typeOnElement(registerPage.getFirsNameFieldElement(),"Sandra");
        registerPage.typeOnElement(registerPage.getLastNameFieldElement(),"Villegas");
        registerPage.typeOnElement(registerPage.getEmailFieldElement(),"test@avantica.com");
        registerPage.typeOnElement(registerPage.getUserNameFieldElement(),"svillegas");
        registerPage.typeOnElement(registerPage.getPasswordFieldElement(),"!123Test");
        registerPage.typeOnElement(registerPage.getConfirmPasswordFieldElement(),"!123Ttst");
        registerPage.typeOnElement(registerPage.getSecurityQuestionFieldElement(),"test");
        registerPage.typeOnElement(registerPage.getSecurityAnswerFieldElement(),"test");
        registerPage.clickOnElemnt(registerPage.getStepNextButtonElement());
        assertTrue(registerPage.verifyErrorMessage("The password and confirmation password must match."));
   }

}
