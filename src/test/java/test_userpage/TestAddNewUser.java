package test_userpage;

import common.Constant;
import common.WebDriverUtil;
import data_provider.DataProviderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.UserPage;

public class TestAddNewUser {
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

    @Test(dataProvider = "'Add new user' from 'Folder' dropdown menu", dataProviderClass = DataProviderService.class)
    public void addSomeNewUsers(String userID,
                               String password,
                               String firstName,
                               String lastName,
                               String phone,
                               String email,
                               String description) {
        userPage.hoverOverFolderDropdown();
        userPage.selectAddNewUser();
        String isAddUserTitle = driver.getTitle();
        String expectAddUserTitle = Constant.Title.ADD_NEW_USER_PAGE.getPageTitle();
        Assert.assertEquals(isAddUserTitle, expectAddUserTitle,
                "The page title does not match");
        logger.info("Navigated to 'Add new user' page successfully");

        userPage.inputUserID(userID);
        userPage.inputPassword(password);
        userPage.inputFirstName(firstName);
        userPage.inputLastName(lastName);
        userPage.inputPhone(phone);
        userPage.inputEmail(email);
        userPage.inputDescription(description);
        userPage.uncheckUserMustChangePassword();
        userPage.clickButtonSaveToAddNewUser();
        Assert.assertTrue(userPage.msgSuccess(),
                "The msg 'Success' does not displayed. Failed to create new user");
        logger.info("The msg 'Success' is displayed properly. Added new user successfully");

        userPage.goToUserPage();
        String isUserPageDisplayed = driver.getTitle();
        String expectUserPageDisplayed = Constant.Title.USER_PAGE.getPageTitle();
        Assert.assertEquals(isUserPageDisplayed, expectUserPageDisplayed,
                "The page title does not match");
        logger.info("Navigated to 'User page'  successfully");

        userPage.clickButtonViewAllSubFolders();
        userPage.search(userID);
        Assert.assertTrue(userPage.isUserFound(userID),"The created user is not existed");
        logger.info("Created user '{}' successfully", userID);
    }

    @AfterClass
    public void clearUp() {
        if (driver != null) {
            driver.quit();
            logger.info("Clear up successfully");
        }
    }

}
