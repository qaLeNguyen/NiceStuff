package common;

public class Constant {
    public enum Credential {
        ADMIN("admin", "winmagic@123"),

        ;

        private final String username;
        private final String password;

        Credential(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public enum URL{
        MESSO_ASIA("https://messo.asia"),
        MESSO_ONLINE("https://messo.online"),
        QAVN("https://qavn.online"),
        DOREMI("https://doremi.asia"),

        ;

        private final String url;

        URL(String url) {
            this.url = url;
        }

        public String getURL(){
            return url;
        }
    }

    public enum Title{
        USER_PAGE("Users"),
        ADD_FOLDER_PAGE("Add folder"),
        ADD_NEW_USER_PAGE("Add user"),
        ADD_NEW_GROUP_PAGE("Add group"),
        CHALLENGE_RESPONSE_IN_FOLDER_DROPDOWN_PAGE("Challenge Response"),
        CHALLENGE_RESPONSE_IN_USER_ADVANCED_DROPDOWN_PAGE("Challenge Response"),
        CHECK_PBCONNEX_PAGE("Check PBConnex"),
        VIEW_PROPERTIES_PAGE("User Properties"),
        MOVE_TO_FOLDER_PAGE("Move to folder"),
        ASSIGN_KEY_TO_USER_PAGE("Assign keys to user(s)"),
        ADD_USER_TO_GROUP_PAGE("Add user(s) to group"),
        VIEW_LOG_PAGE("View Audit Log"),
        CREATE_KEY_FILE_PAGE("Create Key File"),

        ;

        private final String title;

        Title(String pageTitle) {
            this.title = pageTitle;
        }

        public String getPageTitle() {
            return title;
        }
    }

}
