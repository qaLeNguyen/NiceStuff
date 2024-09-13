package test;

import common.Constant;
import common.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        this.driver = WebDriverUtil.getDriver();
        this.wait = WebDriverUtil.getWait();
        this.loginPage = new LoginPage();
        driver.get(Constant.URL.DOREMI.getURL());
    }

    @Test
    public void testLoginByAdminCredential() {
        loginPage.loginByAdminCredential();
        String isUserPageDisplayed = driver.getTitle();
        String expectPageDisplayed = Constant.Title.USER_PAGE.getPageTitle();
        Assert.assertEquals(isUserPageDisplayed, expectPageDisplayed,
                "The page title does not match");
    }

    @AfterMethod
    public void clearUp() {
        if (driver != null) {
            driver.quit();
        }
    }

}
