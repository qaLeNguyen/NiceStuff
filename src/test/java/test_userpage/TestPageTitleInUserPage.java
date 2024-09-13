package test_userpage;

import common.Constant;
import common.WebDriverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;

public class TestPageTitleInUserPage {
    private static final Logger logger = LogManager.getLogger(TestAddNewUser.class);
    private WebDriver driver;
    LoginPage loginPage;
    UserPage userPage;

    @BeforeClass
    public void setUpClass() {
        this.driver = WebDriverUtil.getDriver();
        this.userPage = new UserPage();
        this.loginPage = new LoginPage();
        driver.get(Constant.URL.DOREMI.getURL());
        loginPage.loginByAdminCredential();
        String isUserPageDisplayed = driver.getTitle();
        String expectPageDisplayed = Constant.Title.USER_PAGE.getPageTitle();
        Assert.assertEquals(isUserPageDisplayed, expectPageDisplayed, "The page title does not match");
    }

    @BeforeMethod
    public void setUpMethod() {
        userPage.goToUserPage();
        String isUserPageDisplayed = driver.getTitle();
        String expectUserPageDisplayed = Constant.Title.USER_PAGE.getPageTitle();
        Assert.assertEquals(isUserPageDisplayed, expectUserPageDisplayed,
                "The page title does not match");
        logger.info("Navigated to 'User page' to set up BeforeMethod successfully");
        userPage.clickButtonViewAllSubFolders();
    }

    @Test
    public void testAddFolderTitle() {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddFolder();
        String isAddFolderTitle = driver.getTitle();
        String expectedAddFolderTitle = Constant.Title.ADD_FOLDER_PAGE.getPageTitle();
        Assert.assertEquals(isAddFolderTitle,expectedAddFolderTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add folder' successfully");
    }

    @Test
    public void testAddNewUserTitle() {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddNewUser();
        String isAddUserTitle = driver.getTitle();
        String expectAddUserTitle = Constant.Title.ADD_NEW_USER_PAGE.getPageTitle();
        Assert.assertEquals(isAddUserTitle, expectAddUserTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add new user' page successfully");
    }

    @Test
    public void testAddNewGroupTitle() {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddNewGroup();
        String isAddNewGroupTitle = driver.getTitle();
        String expectedAddNewGroupTitle = Constant.Title.ADD_NEW_GROUP_PAGE.getPageTitle();
        Assert.assertEquals(isAddNewGroupTitle,expectedAddNewGroupTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add new group' successfully");
    }

    @Test
    public void testChallengeResponseInFolderDropdownTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverFolderDropdown();
        userPage.selectChallengeResponseInFolderDropdown();
        String isChallengeResponseInFolderDropdownTitle = driver.getTitle();
        String expectedTitle = Constant.Title.CHALLENGE_RESPONSE_IN_FOLDER_DROPDOWN_PAGE.getPageTitle();
        Assert.assertEquals(isChallengeResponseInFolderDropdownTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Challenge Response' in 'Folder' dropdown successfully");
    }

    @Test
    public void testChallengeResponseInUserAdvancedDropdownTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserAdvancedDropdown();
        userPage.selectChallengeResponseInUserAdvancedDropdown();
        String isChallengeResponseInFolderDropdownTitle = driver.getTitle();
        String expectedTitle = Constant.Title.CHALLENGE_RESPONSE_IN_USER_ADVANCED_DROPDOWN_PAGE.getPageTitle();
        Assert.assertEquals(isChallengeResponseInFolderDropdownTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Challenge Response' in 'User Advanced' dropdown successfully");
    }

    @Test
    public void testPBConnexTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserAdvancedDropdown();
        userPage.selectCheckPBConnex();
        String isCheckPBConnexTitle = driver.getTitle();
        String expectedTitle = Constant.Title.CHECK_PBCONNEX_PAGE.getPageTitle();
        Assert.assertEquals(isCheckPBConnexTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Check PBConnex' in 'User Advanced' dropdown successfully");
    }

    @Test
    public void testViewPropertiesTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectViewProperties();
        String isViewPropertiesTitle = driver.getTitle();
        String expectedTitle = Constant.Title.VIEW_PROPERTIES_PAGE.getPageTitle();
        Assert.assertEquals(isViewPropertiesTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'View properties' in 'User' dropdown successfully");
    }

    @Test
    public void testMoveToFolderTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectMoveToFolder();
        String isMoveToFolderTitle = driver.getTitle();
        String expectedTitle = Constant.Title.MOVE_TO_FOLDER_PAGE.getPageTitle();
        Assert.assertEquals(isMoveToFolderTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Move to folder' in 'User' dropdown successfully");
    }

    @Test
    public void testAssignKeyToUserTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectAssignKeyToUser();
        String isMoveToFolderTitle = driver.getTitle();
        String expectedTitle = Constant.Title.ASSIGN_KEY_TO_USER_PAGE.getPageTitle();
        Assert.assertEquals(isMoveToFolderTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Assign keys to user(s)' in 'User' dropdown successfully");
    }

    @Test
    public void testAddUserToGroupTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectAddUserToGroup();
        String isAddUserToGroupTitle = driver.getTitle();
        String expectedTitle = Constant.Title.ADD_USER_TO_GROUP_PAGE.getPageTitle();
        Assert.assertEquals(isAddUserToGroupTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add user(s) to group' in 'User' dropdown successfully");
    }

    @Test
    public void testViewLogTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectViewLog();
        String isMoveToFolderTitle = driver.getTitle();
        String expectedTitle = Constant.Title.VIEW_LOG_PAGE.getPageTitle();
        Assert.assertEquals(isMoveToFolderTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'View logs' in 'User' dropdown successfully");
    }

    @Test
    public void testCreateKeyFileTitle() {
        userPage.selectUser("admin");
        userPage.hoverOverUserDropdown();
        userPage.selectCreateKeyFile();
        String isMoveToFolderTitle = driver.getTitle();
        String expectedTitle = Constant.Title.CREATE_KEY_FILE_PAGE.getPageTitle();
        Assert.assertEquals(isMoveToFolderTitle,expectedTitle,
                "The page title does not match");
        logger.info("Navigated to 'Create Key File' in 'User' dropdown successfully");
    }

    @AfterClass
    public void clearUp() {
        if (driver != null) {
            driver.quit();
            logger.info("Clear up successfully");
        }
    }
}
