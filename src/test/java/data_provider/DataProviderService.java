package data_provider;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import utils.JsonUtil;

public class DataProviderService {

    @DataProvider(name = "'Add new user' from 'Folder' dropdown menu")
    public Object[][] userDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\user.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] userData = new Object[jsonArray.size()][7];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            userData[i][0] = user.get("userID");
            userData[i][1] = user.get("password");
            userData[i][2] = user.get("firstName");
            userData[i][3] = user.get("lastName");
            userData[i][4] = user.get("phone");
            userData[i][5] = user.get("email");
            userData[i][6] = user.get("description");
        }

        return userData;
    }

    @DataProvider(name = "'Add folder' from 'Folder' dropdown menu")
    public Object[][] folderDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\folder.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] folderData = new Object[jsonArray.size()][2];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            folderData[i][0] = user.get("folderName");
            folderData[i][1] = user.get("description");
        }

        return folderData;
    }

    @DataProvider(name = "'Add new group' from 'Folder' dropdown menu")
    public Object[][] groupDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\group.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] groupData = new Object[jsonArray.size()][2];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            groupData[i][0] = user.get("groupName");
            groupData[i][1] = user.get("description");
        }

        return groupData;
    }

    @DataProvider(name = "'Delete user' from 'User' dropdown menu")
    public Object[][] DeleteUserDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\delete_one_user.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] userData = new Object[jsonArray.size()][1];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            userData[i][0] = user.get("userName");
        }

        return userData;
    }

    @DataProvider(name = "'Delete multiple user(s)' from 'User' dropdown menu")
    public Object[][] DeleteMultipleUserDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\delete_multiple_users.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] userData = new Object[jsonArray.size()][7];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            userData[i][0] = user.get("userName1");
            userData[i][1] = user.get("userName2");
            userData[i][2] = user.get("userName3");
            userData[i][3] = user.get("userName4");
            userData[i][4] = user.get("userName5");
            userData[i][5] = user.get("userName6");
            userData[i][6] = user.get("userName7");
        }

        return userData;
    }

    @DataProvider(name = "'Restore user' from 'User' dropdown menu")
    public Object[][] RestoreUserDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\restore_one_user.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] userData = new Object[jsonArray.size()][1];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            userData[i][0] = user.get("userName");
        }

        return userData;
    }

    @DataProvider(name = "'Restore multiple user(s)' from 'User' dropdown menu")
    public Object[][] RestoreMultipleUserDataProvider() {
        String filePath = "src\\test\\resources\\data_userpage\\restore_multiple_users.json ";
        JSONArray jsonArray = JsonUtil.parseJsonFile(filePath);

        Object[][] userData = new Object[jsonArray.size()][7];

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            userData[i][0] = user.get("userName1");
            userData[i][1] = user.get("userName2");
            userData[i][2] = user.get("userName3");
            userData[i][3] = user.get("userName4");
            userData[i][4] = user.get("userName5");
            userData[i][5] = user.get("userName6");
            userData[i][6] = user.get("userName7");
        }

        return userData;
    }


}



