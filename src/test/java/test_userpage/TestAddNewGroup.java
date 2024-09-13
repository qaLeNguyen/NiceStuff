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

public class TestAddNewGroup {
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

    @Test(dataProvider = "'Add new group' from 'Folder' dropdown menu", dataProviderClass = DataProviderService.class)
    public void addSomeGroups(String groupName,
                               String description) {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddNewGroup();
        String isAddNewGroupTitle = driver.getTitle();
        String expectedAddNewGroupTitle = Constant.Title.ADD_NEW_GROUP_PAGE.getPageTitle();
        Assert.assertEquals(isAddNewGroupTitle,expectedAddNewGroupTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add new group' successfully");

        userPage.inputGroupName(groupName);
        userPage.inputDescription(description);
        userPage.clickButtonSaveToAddNewGroup();
        Assert.assertTrue(userPage.msgSuccess(),
                "The msg 'Success' does not displayed. Failed to add new group");
        logger.info("The msg 'Success' is displayed properly. Added new group successfully");

        userPage.clickFolderMenuOnSidebar();
        userPage.scrollToViewGroupOnSidebar(groupName);
        Assert.assertTrue(userPage.isGroupFound(groupName),
                "Failed to add new group");
        logger.info("Add new group '{}' successfully", groupName);
    }

    @AfterClass
    public void clearUp() {
        if (driver != null) {
            driver.quit();
            logger.info("Clear up successfully");
        }
    }

}
