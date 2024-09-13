package locator;

import org.openqa.selenium.By;

public enum UserLocator {

    BUTTON_VIEW_ALL_SUB_FOLDERS(Type.XPATH, "//a[.='View all sub-folders']"),
    BUTTON_VIEW_THIS_FOLDER(Type.XPATH, "//a[.='View this folder']"),
    BUTTON_SAVE_IN_ADD_NEW_USER(Type.ID, "new-user-submit"),
    BUTTON_SAVE_IN_ADD_FOLDER(Type.CSS, "[name='save']"),
    BUTTON_SAVE_IN_ADD_NEW_GROUP(Type.CSS, "[name='save']"),
    CHECK_BOX_CHANGE_PASSWORD_CREATE_KEY_FILE(Type.ID,"PwdForceChange"),
    CHECK_BOX_USER_MUST_CHANGE_PASSWORD(Type.ID,"IsAdminSetPassword"),
    CHECK_BOX_OF_USER_DISPLAYED_IN_PANEL(Type.XPATH, "//tr[td[a[text()='{{text}}']]]//input[@type='checkbox']"),
    CHECK_BOX_OF_KEY_DISPLAYED_IN_PANEL(Type.XPATH, "//tr[td[text()='{{text}}']]//input[@type='checkbox']"),
    CHECK_BOX_OF_GROUP_DISPLAYED_IN_PANEL(Type.XPATH, "//tr[td[text()='{{text}}']]//input[@type='checkbox']"),

    CONFIRM_DIALOG_DELETE_USER(Type.XPATH,"//div[@class='jconfirm-content']/div[.='Delete the selected user(s)?']"),
    CONFIRM_DIALOG_RESTORE_USER(Type.XPATH,"//div[@class='jconfirm-content']/div[.='Restore the selected user(s) ?']"),
    CONFIRM_DIALOG_RESET_FAILED_LOGIN(Type.XPATH,"//div[@class='jconfirm-content']/div[.='Reset failed login number to zero for the selected user(s)?']"),
    CONFIRM_DIALOG_DELETE_FOLDER(Type.XPATH,"//div[@class='jconfirm-content']/div[contains(.,'Warning ! You are about to delete a folder that may: user(s), key(s), and device')]"),
    CONFIRM_DIALOG_DELETE_GROUP(Type.CSS,".jconfirm-content"),

    DRAG_USER_NAME(Type.XPATH,"//span[contains(@id, '{{text}}')]"),
    DROPDOWN_USER(Type.ID,"Actions_Type_User_Basic"),
    DROPDOWN_USER_ADVANCED(Type.ID,"Actions_Type_User_Advanced"),
    DROPDOWN_FOLDER(Type.ID,"Actions_Type_Folder_Basic"),
    DROPDOWN_USER_TYPE_IN_ADD_NEW_USER(Type.ID, "UserType"),
    DROPDOWN_GENERAL_IN_VIEW_PROPERTIES(Type.ID, "Actions_Type_General"),

    ITEM_BACK_INSIDE_VIEW_PROPERTIES(Type.XPATH,"//div[@id='actions_panel']//a[.='Back']"),
    ITEM_FOLDER_IN_MOVE_TO_FOLDER(Type.ID,"FF_Folders_a"),
    ITEM_PERMISSIONS_IN_VIEW_PROPERTIES(Type.XPATH,"//a[.='Permissions']"),
    ITEM_AUTOBOOT_USER_TYPE(Type.XPATH,"//option[.='Autoboot User']"),
    ITEM_REGULAR_USER_TYPE(Type.XPATH,"//option[.='Regular User']"),
    ITEM_TEMPORARY_USER_TYPE(Type.XPATH,"//option[.='Temporary User']"),
    ITEM_VIEW_PROPERTIES(Type.ID,"Actions_User_ViewUserGeneral"),
    ITEM_ASSIGN_KEYS_TO_USERS(Type.ID,"Actions_User_AssignKeys"),
    ITEM_ADD_USERS_TO_GROUP(Type.ID,"Actions_User_AssignGroups"),
    ITEM_VIEW_LOGS(Type.ID,"Actions_User_ViewLogs"),
    ITEM_CREATE_KEY_FILE(Type.ID,"Actions_Key_CreateKeyFile"),
    ITEM_CR_USER_ADVANCED(Type.ID,"Actions_User_ChallengeResponse"),
    ITEM_CHECK_PBCONNEX(Type.ID,"Actions_User_CheckPBConnex"),
    ITEM_RESET_FAILED_PREBOOT_LOGIN(Type.ID,"Actions_User_ResetFailedLoginsConfirmed"),
    ITEM_ADD_FOLDER(Type.ID,"Actions_Folder_AddFolder"),
    ITEM_ADD_NEW_USER(Type.ID,"Actions_Folder_AddUserGeneral"),
    ITEM_ADD_NEW_GROUP(Type.ID,"Actions_Group_AddGroup"),
    ITEM_CR_FOLDER(Type.ID,"Actions_User_ChallengeResponseGen"),
    ITEM_DE_ASSIGN_KEY_FROM_USER(Type.ID,"Actions_User_DeassignKeys"),
    INPUT_FIELD_PASSWORD_CREATE_KEY_FILE(Type.ID,"PwdNew"),
    INPUT_FIELD_PASSWORD_CONFIRM_CREATE_KEY_FILE(Type.ID,"PwdConfirm"),
    INPUT_FIELD_FOLDER_NAME(Type.ID,"Folder_Name"),
    INPUT_FIELD_GROUP_NAME(Type.ID,"GroupName"),
    INPUT_FIELD_DESCRIPTION(Type.ID,"Description"),
    INPUT_FIELD_USERID(Type.ID,"User_Name"),
    INPUT_FIELD_PASSWORD(Type.ID,"password-input"),
    INPUT_FIELD_FIRSTNAME(Type.ID,"FirstName"),
    INPUT_FIELD_LASTNAME(Type.ID,"LastName"),
    INPUT_FIELD_PHONE(Type.ID,"Phone"),
    INPUT_FIELD_EMAIL(Type.ID,"Email"),

    TAB_TOKENS(Type.XPATH,"//a[.='Token']"),
    TAB_DEVICES(Type.XPATH,"//a[.='Devices']"),
    TAB_KEYS(Type.XPATH,"//a[.='Keys']"),
    TAB_LOGS(Type.XPATH,"//a[.='Logs']"),
    TAB_MULTIPLE_IDP(Type.XPATH,"//a[.='IDP Multi-Account']"),

    LABEL_PROPERTIES_KEYS(Type.XPATH, "//label[.='Properties: Keys']"),
    LABEL_ASSIGN_KEYS_TO_USERS(Type.XPATH, "//label[.='Assign keys to user(s)']"),
    LABEL_ADD_USERS_TO_GROUP(Type.XPATH, "//label[.='Add user(s) to group']"),
    LABEL_CREATE_KEY_FILE(Type.XPATH, "//label[.='Create Key File']"),
    LABEL_ADD_NEW_USER(Type.XPATH, "//label[.='Add new user']"),
    LABEL_CR_IN_USER_ADVANCED(Type.XPATH, "//li[@id='breadcrumbnav']//label[.='Challenge Response']"),

    SEARCHED_NAME_DISPLAYED(Type.XPATH, "//a[.='{{text}}']"),
    LABEL_PROPERTIES(Type.XPATH, "//label[.='Properties: General']"),
    LABEL_MOVE_TO_FOLDER(Type.XPATH, "//label[.='Move to folder']"),
    ITEM_DELETE_USERS(Type.ID,"Actions_User_DeleteUserConfirmed"),
    ITEM_MOVE_TO_FOLDER(Type.ID,"Actions_User_MoveUser"),
    ITEM_RESTORE_USER(Type.ID,"Actions_User_RestoreUser"),
    ;

    private final Type type;
    private final String valueString;
    
    UserLocator(Type type, String value) {
        this.type = type;
        this.valueString = value;
    }
    
    public By getBy(String text) {
        return type.buildBy(valueString.replace("{{text}}", text));
    }
    
    public By getBy() {
        return type.buildBy(valueString);
    }
    
}
