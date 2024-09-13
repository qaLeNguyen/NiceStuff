package locator;

import org.openqa.selenium.By;

public enum DeviceLocator {

    DEVICE_NAME(Type.ID,"DeviceName"),
    MANUFACTURER(Type.ID,"Manufacturer"),
    LOCATION(Type.ID,"Location"),
    SES_PROFILE(Type.ID,"SesProfile"),
    ASSET_TAG(Type.ID,"AssetTag"),
    IP_ADDRESS(Type.ID,"IPAddress"),
    VERSION(Type.ID,"Version"),
    ENCRYPTION_TYPE(Type.ID,"HardwareEncryption"),
    ENCRYPTION_STATUS(Type.ID,"EncryptionStatus"),
    IS_A_CLONE(Type.ID,"isClone"),
    SERIAL_NUMBER(Type.ID,"SerialNumber"),
    MODEL(Type.ID,"Model"),
    TYPE(Type.ID,"Type"),
    PROFILE_STATUS(Type.ID,"ProfileStatus"),
    BUTTON_STATUS(Type.ID,"Status"),
    PORT(Type.ID,"Port"),
    LAST_COMMUNICATED(Type.ID,"LastCommunicated"),
    CHECK_BOX_OF_SEARCHED_DEVICE(Type.XPATH, "//tr[td[a[text()='{{text}}']]]//input[@type='checkbox']"),
    SEARCHED_USERS_NAME_DISPLAYED_IN_PANEL(Type.XPATH, "//a[.='{{text}}']"),
    SEARCHED_DEVICES_NAME_DISPLAYED_IN_PANEL(Type.XPATH, "//a[.='{{text}}']"),
    DROPDOWN_DEVICE(Type.ID,"Actions_Type_Device_Basic"),
    DROPDOWN_DEVICE_ADVANCED(Type.ID,"Actions_Type_Device_Advanced"),
    DROPDOWN_FOLDER(Type.ID,"Actions_Type_Folder_Basic"),
    DROPDOWN_FOLDER_ADVANCED(Type.ID,"Actions_Type_Folder_Advanced"),
    LABEL_MOVE_DEVICES_TO_FOLDER(Type.CSS, "[title='Move device(s) to folder'] > label"),
    LABEL_ADD_DEVICES_TO_GROUP(Type.CSS, "[title='Add device(s) to group'] > label"),
    LABEL_ASSIGN_USERS_TO_DEVICES(Type.CSS, "[title='Assign user(s) to device(s)'] > label"),
    LABEL_ASSIGN_KEYS_TO_DEVICES(Type.CSS, "[title='Assign user(s) to device(s)'] > label"),
    LABEL_PROPERTIES(Type.XPATH, "//label[.='Properties: General']"),
    LABEL_PROPERTIES_KEYS(Type.XPATH, "//label[.='Properties: Keys']"),
    LABEL_PROPERTIES_USERS(Type.XPATH, "//label[.='Properties: Users']"),
    ITEM_MOVE_DEVICES_TO_FOLDER(Type.ID, "Actions_Device_MoveDevice"),
    ITEM_ADD_DEVICES_TO_GROUP(Type.ID, "Actions_Device_AddGroup"),
    ITEM_VIEW_PROPERTIES_OF_DEVICE(Type.ID, "Actions_Device_ViewDeviceGeneral"),
    ITEM_DELETE_DEVICES(Type.ID, "Actions_Device_DeleteConfirmed"),
    ITEM_ASSIGN_KEYS_TO_DEVICES(Type.ID, "Actions_Device_AddKey"),
    CONFIRM_DIALOG_DELETE_DEVICE(Type.XPATH, "//div[@class='jconfirm-content']/div[.='Delete the selected device(s) ?']"),
    MENU_DEVICE_PROPERTIES_KEYS(Type.XPATH,"//a[.='Keys']"),
    MENU_DEVICE_PROPERTIES_USERS(Type.XPATH,"//a[.='Users']"),

    ;

    private final Type type;
    private final String valueString;

    DeviceLocator(Type type, String value) {
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
