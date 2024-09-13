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

public class TestRestoreUser {
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
        userPage.goToRecyclePage();
        logger.info("Navigated to 'Recycle' page to set up @BeforeMethod successfully");
    }

    @Test(dataProvider = "'Restore user' from 'User' dropdown menu",
            dataProviderClass = DataProviderService.class)
    public void restoreUser(String userName) {
        userPage.selectUser(userName);
        userPage.hoverOverUserDropdown();
        userPage.selectRestoreUser();
        Assert.assertTrue(userPage.isConfirmRestoreUserDisplayed(),
                "The dialog 'Restore the selected user(s) ?' is not displayed");
        logger.info("The dialog 'Restore the selected user(s) ?' is displayed properly");
        userPage.clickButtonYesToProceedRestoreUser();
        Assert.assertTrue(userPage.msgSuccess(),
                "The msg 'Success' does not displayed. Failed to delete user");
        logger.info("The msg 'Success' is displayed properly. Delete user '{}' successfully", userName);

        userPage.goToUserPage();
        userPage.clickButtonViewAllSubFolders();
        userPage.search(userName);
        Assert.assertTrue(userPage.isUserFound(userName),
                "User cannot be found in 'User' page. Failed to restore user");
        logger.info("Restore user '{}' successfully", userName);
    }

    @Test(dataProvider = "'Restore multiple user(s)' from 'User' dropdown menu",
            dataProviderClass = DataProviderService.class)
    public void restoreMultipleUsers(String userName1,
                                     String userName2,
                                     String userName3,
                                     String userName4,
                                     String userName5,
                                     String userName6,
                                     String userName7) {
        userPage.selectUser(userName1);
        userPage.selectUser(userName2);
        userPage.selectUser(userName3);
        userPage.selectUser(userName4);
        userPage.selectUser(userName5);
        userPage.selectUser(userName6);
        userPage.selectUser(userName7);
        userPage.hoverOverUserDropdown();
        userPage.selectRestoreUser();
        Assert.assertTrue(userPage.isConfirmRestoreUserDisplayed(),
                "The dialog 'Restore the selected user(s) ?' is not displayed");
        logger.info("Selected multiple users. The dialog 'Restore the selected user(s) ?' is displayed properly");
        userPage.clickButtonYesToProceedRestoreUser();
        Assert.assertTrue(userPage.msgSuccess(),
                "The msg 'Success' does not displayed. Failed to delete user");
        logger.info("The msg 'Success' is displayed properly. Restore multiple users successfully");

        userPage.goToUserPage();
        userPage.clickButtonViewAllSubFolders();
        userPage.search(userName1);
        Assert.assertTrue(userPage.isUserFound(userName1),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user1 '{}' successfully", userName1);

        userPage.search(userName2);
        Assert.assertTrue(userPage.isUserFound(userName2),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user2 '{}' successfully", userName2);

        userPage.search(userName3);
        Assert.assertTrue(userPage.isUserFound(userName3),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user3 '{}' successfully", userName3);

        userPage.search(userName4);
        Assert.assertTrue(userPage.isUserFound(userName4),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user4 '{}' successfully", userName4);

        userPage.search(userName5);
        Assert.assertTrue(userPage.isUserFound(userName5),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user5 '{}' successfully", userName5);

        userPage.search(userName6);
        Assert.assertTrue(userPage.isUserFound(userName6),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user6 '{}' successfully", userName6);

        userPage.search(userName7);
        Assert.assertTrue(userPage.isUserFound(userName7),
                "User cannot be found in 'Users' page. Failed to restore user");
        logger.info("Restore user7 '{}' successfully", userName7);
    }

    @AfterClass
    public void clearUp() {
        if (driver != null) {
            driver.quit();
            logger.info("Clear up successfully");
        }
    }

}
