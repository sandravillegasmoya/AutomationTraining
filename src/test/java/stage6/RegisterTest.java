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
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserType","executionType"})
    public void setUp(String browserType, String executionType) throws Exception {
        driver = createDriver(browserType, executionType);
        driver.get("http://qa-trainingw7:86/");
        homePage = new HomePage(driver);
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
       registerPage = homePage.goToRegister();
       assertTrue(registerPage.verifyLoads());
    }

    @Test
    public void testValidateMandatoryMessages() throws Exception {
        registerPage = homePage.goToRegister();
        registerPage.clearElementsRegisterPage();
        registerPage.gotoNextStep();
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
        registerPage = homePage.goToRegister();
        registerPage.clearElementsRegisterPage();
        registerPage.fillRegisterForm("Sandra",
                "Villegas",
                "test@avantica.com",
                "svillegas",
                "!123Test",
                "!123Test",
                "test",
                "test");
        registerPage.gotoNextStep();
       assertTrue(registerPage.verifyErrorMessage("User name already exists. Please enter a different user name."));
    }

    @Test
    public void testVerifyMismatchedPasswords() throws Exception {
        registerPage = homePage.goToRegister();
        registerPage.clearElementsRegisterPage();
        registerPage.fillRegisterForm("Sandra",
                "Villegas",
                "test@avantica.com",
                "svillegas",
                "!123Test",
                "!123Ttest",
                "test",
                "test");
        registerPage.gotoNextStep();
        assertTrue(registerPage.verifyErrorMessage("The password and confirmation password must match."));
   }

}
