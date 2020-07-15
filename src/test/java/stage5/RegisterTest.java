package stage5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.RegisterPage;
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
        registerPage.clickOnElement(registerPage.getRegistrerLink());
       assertTrue(registerPage.isElementPresent(registerPage.getRegisterTitle()));
    }

    @Test
    public void testValidateMandatoryMessages() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        registerPage.clickOnElement(registerPage.getRegistrerLink());
        registerPage.clearElementsRegisterPage();
        registerPage.clickOnElement(registerPage.getStepNextButton());
        assertTrue(registerPage.isElementDisplayed(registerPage.getFirtsNameRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getLastNameRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getEmailRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getUserNameRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getPasswordRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getConfirmPasswordRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getSecurityQuestionRequiredMessage()));
        assertTrue(registerPage.isElementDisplayed(registerPage.getSecurityAnswerRequiredMessage()));
    }

    @Test
    public void testVerifyUserNameAlreadyTaken() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        registerPage.clickOnElement(registerPage.getRegistrerLink());
        registerPage.clearElementsRegisterPage();
        registerPage.typeOnElement(registerPage.getFirsNameField(),"Sandra");
        registerPage.typeOnElement(registerPage.getLastNameField(),"Villegas");
        registerPage.typeOnElement(registerPage.getEmailField(),"test@avantica.com");
        registerPage.typeOnElement(registerPage.getUserNameField(),"svillegas");
        registerPage.typeOnElement(registerPage.getPasswordField(),"!123Test");
        registerPage.typeOnElement(registerPage.getConfirmPasswordField(),"!123Test");
        registerPage.typeOnElement(registerPage.getSecurityQuestionField(),"test");
        registerPage.typeOnElement(registerPage.getSecurityAnswerField(),"test");
        registerPage.clickOnElement(registerPage.getStepNextButton());
        assertTrue(registerPage.isElementDisplayed(registerPage.getAlreadyExistUserMessage()));
    }

    @Test
    public void testVerifyMismatchedPasswords() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        registerPage.clickOnElement(registerPage.getRegistrerLink());
        registerPage.clearElementsRegisterPage();
        registerPage.typeOnElement(registerPage.getFirsNameField(),"Sandra");
        registerPage.typeOnElement(registerPage.getLastNameField(),"Villegas");
        registerPage.typeOnElement(registerPage.getEmailField(),"test@avantica.com");
        registerPage.typeOnElement(registerPage.getUserNameField(),"svillegas");
        registerPage.typeOnElement(registerPage.getPasswordField(),"!123Test");
        registerPage.typeOnElement(registerPage.getConfirmPasswordField(),"!123Ttst");
        registerPage.typeOnElement(registerPage.getSecurityQuestionField(),"test");
        registerPage.typeOnElement(registerPage.getSecurityAnswerField(),"test");
        registerPage.clickOnElement(registerPage.getStepNextButton());
        assertTrue(registerPage.isElementDisplayed(registerPage.getPasswordsDoNotMatchMessage()));
   }

}
