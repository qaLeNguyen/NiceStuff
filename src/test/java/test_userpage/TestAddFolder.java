package test_userpage;

import common.Constant;
import common.WebDriverUtil;
import data_provider.DataProviderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;

public class TestAddFolder {
    private static final Logger logger = LogManager.getLogger(TestAddNewUser.class);
    private WebDriver driver;
    private WebDriverWait wait;
    LoginPage loginPage;
    UserPage userPage;

    @BeforeClass
    public void setUpClass() {
        this.driver = WebDriverUtil.getDriver();
        this.wait = WebDriverUtil.getWait();
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
    }

    @Test(dataProvider = "'Add folder' from 'Folder' dropdown menu", dataProviderClass = DataProviderService.class)
    public void addSomeFolders(String folderName,
                               String description) {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddFolder();
        String isAddFolderTitle = driver.getTitle();
        String expectedAddFolderTitle = Constant.Title.ADD_FOLDER_PAGE.getPageTitle();
        Assert.assertEquals(isAddFolderTitle,expectedAddFolderTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add folder' successfully");

        userPage.inputFolderName(folderName);
        userPage.inputDescription(description);
        userPage.clickButtonSaveToAddFolder();
        Assert.assertTrue(userPage.msgSuccess(),
                "The msg 'Success' does not displayed. Failed to add new folder");
        logger.info("The msg 'Success' is displayed properly. Added new folder successfully");

        userPage.clickFolderMenuOnSidebar();
        userPage.scrollToViewFolderOnSidebar(folderName);
        Assert.assertTrue(userPage.isFolderFound(folderName),
                "Failed to add new folder");
        logger.info("Add new folder '{}' successfully", folderName);
    }

    @AfterClass
    public void clearUp() {
        if (driver != null) {
            driver.quit();
            logger.info("Clear up successfully");
        }
    }

}
