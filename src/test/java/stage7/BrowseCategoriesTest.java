package stage7;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.stage7.BrowseAllCategoriesPage;
import pages.stage7.HomePage;
import utilies.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BrowseCategoriesTest extends BaseTest{

    private WebDriver driver;
    private HomePage homePage;
    private BrowseAllCategoriesPage browseCategoriesPage;

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
        System.out.println("Executing class: BrowseCategoriesTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Completing execution class: BrowseCategoriesTest");
    }

    @Test
    public void testSearchViewAntiquesCollectibles() throws Exception {
        browseCategoriesPage = homePage.selectCategory("Antiques & Collectibles");
        assertTrue(browseCategoriesPage.verifyCategorySelected(" Antiques & Collectibles"));
    }

    @Test
    public void testSearchViewAuto() throws Exception {
        browseCategoriesPage = homePage.selectCategory("Auto");
        assertTrue(browseCategoriesPage.verifyCategorySelected(" Auto"));
    }

    @Test
    public void testSearchViewArtsCrafts() throws Exception {
        browseCategoriesPage = homePage.selectCategory("Auto");
        assertTrue(browseCategoriesPage.verifyCategorySelected(" Auto"));
    }

}
