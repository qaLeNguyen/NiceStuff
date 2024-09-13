package pages;

import common.BuiltInAction;
import common.Constant;
import locator.CommonLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BuiltInAction {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        super();
    }

    public void inputUserName(String username) {
        input(CommonLocator.USER_ID_FIELD.getBy(), username);
    }

    public void inputPassword(String password) {
        input(CommonLocator.PASSWORD_FIELD.getBy(), password);
    }

    public void clickLogOnButton() {
        click(CommonLocator.BUTTON_LOGON.getBy());
    }

    public void loginByAdminCredential() {
        try {
            input(CommonLocator.USER_ID_FIELD.getBy(), Constant.Credential.ADMIN.getUsername());
            input(CommonLocator.PASSWORD_FIELD.getBy(), Constant.Credential.ADMIN.getPassword());
            clickLogOnButton();
            logger.info("Login with Admin Credential successfully");
        } catch (Exception e) {
            logger.error("Exception occurred while logging with Admin Credential");
        }
    }

}
