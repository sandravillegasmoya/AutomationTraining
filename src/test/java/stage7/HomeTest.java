package stage7;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.stage7.HomePage;
import utilies.BaseTest;

import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    private WebDriver driver;
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
        System.out.println("Executing class: HomeTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: HomeTest");
    }

    @Test
    public void testVerifyHomePageLoadingApp() throws Exception {
        assertTrue(homePage.verifyLoads());
    }

    @Test
    public void testVerifyHomePageNavMenu() throws Exception {
        homePage = homePage.navigation.goToHomePage();
        assertTrue(homePage.verifyLoads());

    }

}
