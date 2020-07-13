package stage6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.stage6.HomePage;
import pages.stage6.LoginPage;
import utilies.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private LoginPage loginPage ;
    private WebElement buttonLogin;

    @BeforeMethod (alwaysRun = true)
    @Parameters({"browserType","executionType"})
    public void setUp(String browserType, String executionType) throws Exception {
        driver = createDriver(browserType, executionType);
        driver.get("http://qa-trainingw7:86/");
        loginPage = new LoginPage(driver);
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
        System.out.println("Executing class: LoginTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: LoginTest");
    }

    @Test
    public void testVerifyLoginPageIsDisplayed() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.goToLogin();
        assertTrue(loginPage.isElementPresent(loginPage.getLoginTitlePageElement()));
    }

    @Test
    public void testVerifyLoginValidCredentials() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.goToLogin();
        loginPage.clearElementsLoginPage();
        loginPage.logIn("svillegas1","!123Test");
        assertTrue(loginPage.isUserLogedIn("svillegas1"));
    }

    @Test
    public void testVerifyLoginInvalidCredentials() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage.goToLogin();
        loginPage.clearElementsLoginPage();
        loginPage.logIn("svillegas1","invalidPass");
        assertTrue(loginPage.verifyErrorMessage("Your login attempt was not successful. Please try again."));
    }

}
