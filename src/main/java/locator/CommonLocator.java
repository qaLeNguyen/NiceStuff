package locator;

import org.openqa.selenium.By;

public enum CommonLocator {

    USER_ID_FIELD(Type.ID, "UserName"),
    PASSWORD_FIELD(Type.ID, "password-input"),
    BUTTON_LOGON(Type.ID, "ses-submit-btn"),
    BUTTON_YES(Type.XPATH, "//button[.='Yes']"),
    BUTTON_NO(Type.XPATH, "//button[.='No']"),
    BUTTON_MOVE(Type.ID,"btnSubmitMove"),
    BUTTON_SAVE(Type.NAME ,"save"),
    BUTTON_ADD(Type.NAME ,"save"),
    BUTTON_OK(Type.NAME ,"save"),
    BUTTON_OK_CONFIRM_DIALOG(Type.XPATH, "//button[@class='btn btn-default']"),

    LABEL_ADD_FOLDER(Type.XPATH, "//li[@id='breadcrumbnav']//label[.='Add folder']"),
    LABEL_ADD_GROUP(Type.XPATH, "//li[@id='breadcrumbnav']//label[.='Add group']"),
    LABEL_VIEW_AUDIT_LOG(Type.XPATH, "//label[.='View Audit Log']"),
    LABEL_CHECK_PBCONNEX(Type.XPATH, "//li[@id='breadcrumbnav']//label[.='Challenge Response']"),

    SECUREDOC_LOGO(Type.XPATH, "//li[@id='breadcrumbnav']//li[1]//span[1]"),
    SIDEBAR_USERS_PAGE(Type.XPATH, "//li[@class='i_Users']"),
    SIDEBAR_DEVICES_PAGE(Type.XPATH, "//li[@class='Devices']"),
    SIDEBAR_PROFILES_PAGE(Type.XPATH, "//li[@class='i_Profiles']"),
    SIDEBAR_PACKAGES_PAGE(Type.XPATH, "//li[@class='i_Packages']"),
    SIDEBAR_CONFIGURATION_PAGE(Type.XPATH, "//span[.='Configuration']"),
    SIDEBAR_RECYCLE_BIN(Type.CSS, ".RecyclingBin"),
    SIDEBAR_ADMIN_MANAGEMENT(Type.XPATH,"//span[.='Administrator Management']"),
    SIDEBAR_USERS_BUTTON_EXPAND_FOLDER(Type.XPATH, "//li[@class='jstree-closed']/ins[@class='jstree-icon']"),
    SIDEBAR_USERS_FOLDER_MENU(Type.CSS, ".jstree-checked"),
    SIDEBAR_USERS_FOLDER_NAME_DISPLAYED(Type.XPATH, "//a[contains(.,'{{text}}')]"),
    SIDEBAR_USERS_GROUP_NAME_DISPLAYED(Type.XPATH, "//a[contains(.,'{{text}}')]"),
    SIDEBAR_DEVICES_FOLDER_NAME_DISPLAYED(Type.XPATH, "//a[contains(.,'{{text}}')]"),
    SIDEBAR_DEVICES_GROUP_NAME_DISPLAYED(Type.XPATH, "//a[contains(.,'{{text}}')]"),

    SIDEBAR(Type.ID,"foldermainnav"),
    SEARCH_FIELD(Type.CSS, "[placeholder='Search...']"),
    SEARCHED_KEY(Type.XPATH, "//td[@role='gridcell'][normalize-space(text())='{{text}}']"),
    SEARCHED_GROUP(Type.XPATH, "//td[@role='gridcell'][normalize-space(text())='{{text}}']"),

    OPERATION_SUCCEEDED_ALERT(Type.XPATH, "//div[@class='alert success']"),

    CHECK_BOX_DISPLAY_ALL_KEYS(Type.CSS,".aCheckBox"),
    CHECK_BOX_DISPLAY_ALL_GROUPS(Type.XPATH,"//a[.='Display all groups']"),
    CHECK_BOX_DISPLAY_ALL_USERS(Type.XPATH,"//a[.='Display all users']"),
    FOLDER_NAME_DISPLAYED_IN_MOVE_TO_FOLDER(Type.CSS,"[title='{{text}}']"),

    ;

    private final Type type;
    private final String valueString;

    CommonLocator(Type type, String value) {
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
