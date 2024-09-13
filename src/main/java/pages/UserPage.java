package pages;

import common.BuiltInAction;
import locator.CommonLocator;
import locator.UserLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class UserPage extends BuiltInAction {
    private static final Logger logger = LogManager.getLogger(UserPage.class);

    public UserPage() {
        super();
    }

    public void goToUserPage() {
        try {
            click(CommonLocator.SECUREDOC_LOGO.getBy());
            logger.info("Navigated to 'User page' successfully");
        } catch (Exception e) {
            logger.error("Exception occurred while navigating to 'User page'");
        }
    }

    public void clickButtonViewAllSubFolders() {
        try {
            click(UserLocator.BUTTON_VIEW_ALL_SUB_FOLDERS.getBy());
            logger.info("Clicked button 'View all sub-folders'");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking button 'View all sub-folders'");
        }
    }

    public void clickButtonViewThisFolder() {
        try {
            click(UserLocator.BUTTON_VIEW_THIS_FOLDER.getBy());
            logger.info("Clicked button 'View this folder'");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking button 'View this folder'");
        }
    }

    public void clickButtonSaveToAddNewUser() {
        try {
            click(UserLocator.BUTTON_SAVE_IN_ADD_NEW_USER.getBy());
            logger.info("Clicked the 'Save' button, proceeding to 'Add New User'");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking button 'Save' to 'Add new user'");
        }
    }

    public void clickButtonSaveToAddNewGroup() {
        try {
            click(UserLocator.BUTTON_SAVE_IN_ADD_NEW_GROUP.getBy());
            logger.info("Clicked the 'Save' button, proceeding to 'Add new group'");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking button 'Save' to 'Add new group'");
        }
    }

    public void clickButtonSaveToAddFolder() {
        try {
            click(UserLocator.BUTTON_SAVE_IN_ADD_FOLDER.getBy());
            logger.info("Clicked the 'Save' button, proceeding to 'Add Folder'");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking button 'Save' to 'Add Folder'");
        }
    }

    public void clickScrollBar() {
        try {
            click(CommonLocator.SIDEBAR.getBy());
            logger.info("Clicked scrollbar");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking scrollbar");
        }
    }

    public void clickFolderMenuOnSidebar() {
        try {
            click(CommonLocator.SIDEBAR_USERS_FOLDER_MENU.getBy());
            logger.info("Clicked 'Folder menu' on sidebar");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking Folder menu on sidebar");
        }
    }

    public void clickFolderItemInMoveToFolderPage() {
        try {
            click(UserLocator.ITEM_FOLDER_IN_MOVE_TO_FOLDER.getBy());
            logger.info("Clicked 'Folder item' in 'Move to folder' page");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking to 'Folder item'");
        }
    }


    public boolean msgSuccess() {
        boolean isSuccess = isElementDisplayed(CommonLocator.OPERATION_SUCCEEDED_ALERT.getBy());
        if (isSuccess) {
            logger.info("Operation succeed is displayed");
        } else {
            logger.error("Operation is not displayed");
        }
        return isSuccess;
    }

    /**
     * The checkbox 'User must change password at next logon' is checked by default.
     * Uncheck this checkbox will not require user to change their password after first-login
     */
    public void uncheckUserMustChangePassword() {
        WebElement checkBox = getElementVisible(UserLocator.CHECK_BOX_USER_MUST_CHANGE_PASSWORD.getBy());
        try {
            if (checkBox.isSelected()) {
                checkBox.click();
                logger.info("Unchecked the checkbox 'User must change password at next logon'");
            } else {
                logger.error("The checkbox 'User must change password at next logon' is unchecked by default");
            }
        } catch (Exception e) {
            logger.error("Exception occurred while unchecking the checkbox 'User must change password at next logon'");
        }
    }

    public void hoverOverUserDropdown() {
        try {
            hoverOver(UserLocator.DROPDOWN_USER.getBy());
            logger.info("Hovered over 'User' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while hovering over 'User' dropdown");
        }
    }

    public void hoverOverUserAdvancedDropdown() {
        try {
            hoverOver(UserLocator.DROPDOWN_USER_ADVANCED.getBy());
            logger.info("Hovered over 'User Advanced' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while hovering over 'User Advanced' dropdown");
        }
    }

    public void hoverOverFolderDropdown() {
        try {
            hoverOver(UserLocator.DROPDOWN_FOLDER.getBy());
            logger.info("Hovered over 'Folder' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while hovering over 'Folder' dropdown");
        }
    }

    public void search(String name) {
        try {
            input(CommonLocator.SEARCH_FIELD.getBy(), name);
            logger.info("Inputted '{}' into search field", name);
        } catch (Exception e) {
            logger.error("Exception occurred while searching for Users/ Keys/ Groups");
        }
    }

    public void scrollToViewFolderOnSidebar(String folderName) {
        try {
            scrollToView(CommonLocator.SIDEBAR_USERS_FOLDER_NAME_DISPLAYED.getBy(folderName));
            logger.info("Scrolled to folder named '{}'", folderName);
        } catch (Exception e) {
            logger.error("Exception occurred while scrolling to folder on sidebar");
        }
    }

    public void scrollToViewGroupOnSidebar(String groupName) {
        try {
            scrollToView(CommonLocator.SIDEBAR_USERS_GROUP_NAME_DISPLAYED.getBy(groupName));
            logger.info("Scrolled to group named '{}'", groupName);
        } catch (Exception e) {
            logger.error("Exception occurred while scrolling to group on sidebar");
        }
    }

    public void scrollToViewFolderInMoveToFolderPage(String folderName) {
        try {
            scrollToView(CommonLocator.SIDEBAR_USERS_FOLDER_NAME_DISPLAYED.getBy(folderName));
            logger.info("Scrolled to folder named '{}' in 'Move to folder' page", folderName);
        } catch (Exception e) {
            logger.error("Exception occurred while scrolling to folder in 'Move to folder' page");
        }
    }

    public boolean isUserFound(String username) {
        return isElementDisplayed(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
    }

    public boolean isFolderFound(String folderName) {
        return isElementDisplayed(CommonLocator.SIDEBAR_USERS_FOLDER_NAME_DISPLAYED.getBy(folderName));
    }

    public boolean isGroupFound(String groupName) {
        return isElementDisplayed(CommonLocator.SIDEBAR_USERS_GROUP_NAME_DISPLAYED.getBy(groupName));
    }

    public boolean isConfirmDeleteUserDisplayed() {
        return isElementDisplayed(UserLocator.CONFIRM_DIALOG_DELETE_USER.getBy());
    }

    public boolean isConfirmRestoreUserDisplayed() {
        return isElementDisplayed(UserLocator.CONFIRM_DIALOG_RESTORE_USER.getBy());
    }

    public void clickButtonYesToProceedDeleteUser() {
        if (isConfirmDeleteUserDisplayed()) {
            click(CommonLocator.BUTTON_YES.getBy());
            logger.info("Clicked 'Yes' button to delete user");
        } else {
            logger.error("The dialog 'Delete the selected user(s)' does not display");
        }
    }

    public void clickButtonYesToProceedRestoreUser() {
        if (isConfirmRestoreUserDisplayed()) {
            click(CommonLocator.BUTTON_YES.getBy());
            logger.info("Clicked 'Yes' button to restore user");
        } else {
            logger.error("The dialog 'Restore the selected user(s) ?' does not display");
        }
    }

    public void selectUser(String username) {
        try {
            boolean isUserFound = isElementDisplayed(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
            if (isUserFound) {
                click(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
                logger.info("Selected user '{}'", username);
            } else {
                clickButtonViewAllSubFolders();
                isUserFound = isElementDisplayed(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
                if (isUserFound) {
                    click(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
                    logger.info("Clicked button 'View All Sub-Folders, and selected user '{}'", username);
                } else {
                    search(username);
                    click(UserLocator.CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL.getBy(username));
                    logger.info("Searched, and selected user '{}'", username);
                }
            }
        } catch (Exception e) {
            logger.error("Error occurred when trying to select user");
        }
    }

    public void selectAddFolder() {
        try {
            click(UserLocator.ITEM_ADD_FOLDER.getBy());
            logger.info("Selected 'Add folder'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Add folder");
        }
    }

    public void selectAddNewUser() {
        try {
            click(UserLocator.ITEM_ADD_NEW_USER.getBy());
            logger.info("Selected 'Add new user'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Add new user");
        }
    }

    public void selectAddNewGroup() {
        try {
            click(UserLocator.ITEM_ADD_NEW_GROUP.getBy());
            logger.info("Selected 'Add new group'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Add new group");
        }
    }

    public void selectChallengeResponseInFolderDropdown() {
        try {
            click(UserLocator.ITEM_CR_FOLDER.getBy());
            logger.info("Selected 'Challenge Response' in 'Folder' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Challenge Response' in 'Folder' dropdown");
        }
    }

    public void selectChallengeResponseInUserAdvancedDropdown() {
        try {
            click(UserLocator.ITEM_CR_USER_ADVANCED.getBy());
            logger.info("Selected 'Challenge Response' in 'User Advanced' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Challenge Response' in 'User Advanced' dropdown");
        }
    }

    public void selectCheckPBConnex() {
        try {
            click(UserLocator.ITEM_CHECK_PBCONNEX.getBy());
            logger.info("Selected 'Check PBConnex' in 'User Advanced' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Check PBConnex' in 'User Advanced' dropdown");
        }
    }

    public void selectViewProperties() {
        try {
            click(UserLocator.ITEM_VIEW_PROPERTIES.getBy());
            logger.info("Selected 'View properties' in 'User' dropdown");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'View properties' in 'User' dropdown");
        }
    }

    public void selectDeleteUser() {
        try {
            click(UserLocator.ITEM_DELETE_USERS.getBy());
            logger.info("Selected 'Delete user(s)'");
        } catch (Exception e) {
            logger.error("Exception occurred while deleting user");
        }
    }

    public void selectRestoreUser() {
        try {
            click(UserLocator.ITEM_RESTORE_USER.getBy());
            logger.info("Selected 'Restore user(s)'");
        } catch (Exception e) {
            logger.error("Exception occurred while restoring user(s)");
        }
    }

    public void selectMoveToFolder() {
        try {
            click(UserLocator.ITEM_MOVE_TO_FOLDER.getBy());
            logger.info("Selected 'Move to folder'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Move to folder'");
        }
    }

    public void selectAssignKeyToUser() {
        try {
            click(UserLocator.ITEM_ASSIGN_KEYS_TO_USERS.getBy());
            logger.info("Selected 'Assign key(s) to user(s)'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Assign key(s) to user(s)'");
        }
    }

    public void selectAddUserToGroup() {
        try {
            click(UserLocator.ITEM_ADD_USERS_TO_GROUP.getBy());
            logger.info("Selected 'Add user(s) to group'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Add user(s) to group'");
        }
    }

    public void selectViewLog() {
        try {
            click(UserLocator.ITEM_VIEW_LOGS.getBy());
            logger.info("Selected 'View logs'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'View logs'");
        }
    }

    public void selectCreateKeyFile() {
        try {
            click(UserLocator.ITEM_CREATE_KEY_FILE.getBy());
            logger.info("Selected 'Create Key File'");
        } catch (Exception e) {
            logger.error("Exception occurred while selecting 'Create Key File'");
        }
    }

    public void inputFolderName(String folderName) {
        try {
            input(UserLocator.INPUT_FIELD_FOLDER_NAME.getBy(), folderName);
            logger.info("Inputted 'Folder Name' '{}'", folderName);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Folder Name'");
        }
    }

    public void inputDescription(String description) {
        try {
            input(UserLocator.INPUT_FIELD_DESCRIPTION.getBy(), description);
            logger.info("Inputted 'Description' '{}'", description);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Description'");
        }
    }

    public void inputGroupName(String groupName) {
        try {
            input(UserLocator.INPUT_FIELD_GROUP_NAME.getBy(), groupName);
            logger.info("Inputted 'Group Name' '{}'", groupName);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Group Name'");
        }
    }

    public void inputUserID(String userID) {
        try {
            input(UserLocator.INPUT_FIELD_USERID.getBy(), userID);
            logger.info("Inputted 'UserID' '{}'", userID);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'UserID'");
        }
    }

    public void inputPassword(String password) {
        try {
            input(UserLocator.INPUT_FIELD_PASSWORD.getBy(), password);
            logger.info("Inputted 'Password' '{}'", password);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Password'");
        }
    }

    public void inputFirstName(String firstName) {
        try {
            input(UserLocator.INPUT_FIELD_FIRSTNAME.getBy(), firstName);
            logger.info("Inputted 'First Name' '{}'", firstName);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'First Name'");
        }
    }

    public void inputLastName(String lastName) {
        try {
            input(UserLocator.INPUT_FIELD_LASTNAME.getBy(), lastName);
            logger.info("Inputted 'Last Name' '{}'", lastName);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Last Name'");
        }
    }

    public void inputPhone(String phone) {
        try {
            input(UserLocator.INPUT_FIELD_PHONE.getBy(), phone);
            logger.info("Inputted 'Phone' '{}'", phone);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Phone'");
        }
    }

    public void inputEmail(String email) {
        try {
            input(UserLocator.INPUT_FIELD_EMAIL.getBy(), email);
            logger.info("Inputted 'Email' '{}'", email);
        } catch (Exception e) {
            logger.error("Exception occurred while inputting 'Email'");
        }
    }

    public void goToRecyclePage() {
        try {
            click(CommonLocator.SIDEBAR_RECYCLE_BIN.getBy());
            logger.info("Clicked 'Recycle' on sidebar");
        } catch (Exception e) {
            logger.error("Exception occurred while clicking 'Recycle'");
        }
    }


}
