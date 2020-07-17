package stage7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.stage7.HomePage;
import pages.stage7.LoginPage;
import utilies.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage ;

    @BeforeMethod (alwaysRun = true)
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
        System.out.println("Executing class: LoginTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: LoginTest");
    }

    @Test
    public void testVerifyLoginPageIsDisplayed() throws Exception {
        driver.get("http://qa-trainingw7:86/");
        loginPage = homePage.navigation.goToLogin();
        assertTrue(loginPage.verifyLoads());
    }

    @Test
    public void testVerifyLoginValidCredentials() throws Exception {
        loginPage = homePage.navigation.goToLogin();
        loginPage.clearElementsLoginPage();
        loginPage.logIn("svillegas1","!123Test");
        assertTrue(loginPage.navigation.isUserLogIn("svillegas1"));
    }

    @Test
    public void testVerifyLoginInvalidCredentials() throws Exception {
        loginPage= homePage.navigation.goToLogin();
        loginPage.clearElementsLoginPage();
        loginPage.logIn("svillegas1","invalidPass");
        assertTrue(loginPage.verifyMessage("Your login attempt was not successful. Please try again."));
    }

}
