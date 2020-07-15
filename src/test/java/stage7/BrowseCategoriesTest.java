package stage7;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.stage7.BrowseCategoriesPage;
import pages.stage7.HomePage;
import utilies.BaseTest;

import static org.testng.Assert.assertEquals;

public class BrowseCategoriesTest extends BaseTest{

    private WebDriver driver;
    private HomePage homePage;
    private BrowseCategoriesPage browseCategoriesPage;

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
        browseCategoriesPage = homePage.goToBrowseCategories(homePage.getAntiquesCollectiblesCategoryLinkElement());
        assertEquals(browseCategoriesPage.getOptionSelected(browseCategoriesPage.getCategoryDropDown()), " Antiques & Collectibles");
    }

    @Test
    public void testSearchViewAuto() throws Exception {
        browseCategoriesPage = homePage.goToBrowseCategories(homePage.getAutoCategoryLinkElement());
        assertEquals(browseCategoriesPage.getOptionSelected(browseCategoriesPage.getCategoryDropDown()), " Auto");
    }

    @Test
    public void testSearchViewArtsCrafts() throws Exception {
        browseCategoriesPage = homePage.goToBrowseCategories(homePage.getArtsCraftsCategoryLinkElement());
        assertEquals(browseCategoriesPage.getOptionSelected(browseCategoriesPage.getCategoryDropDown()), " Arts & Crafts");
    }

}
