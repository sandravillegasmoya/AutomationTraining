package stage7;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.stage7.HomePage;
import pages.stage7.LoginPage;
import pages.stage7.PostAnAdPage;
import utilies.BaseTest;

import static org.testng.Assert.assertTrue;


public class PostAnAdTest extends BaseTest{

    private WebDriver driver;
    private HomePage homePage;
    private PostAnAdPage postAnAdPage;
    private LoginPage loginPage;

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
        System.out.println("Executing class: PostAnAdTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: PostAnAdTest");
    }

    @Test
    public void testVerifyPostAnAdTabUserNotLogged() throws Exception {
        postAnAdPage = homePage.navigation.goToPostAnAd();
        assertTrue(!postAnAdPage.verifyLoads());
    }

    @Test
    public void testVerifyPostAnAdTabUserAlreadyLogged() throws Exception {
        loginPage = homePage.navigation.goToLogin();
        loginPage.clearElementsLoginPage();
        loginPage.logIn("svillegas1","!123Test");
        postAnAdPage = loginPage.navigation.goToPostAnAd();
        assertTrue(postAnAdPage.verifyLoads());
    }

}
