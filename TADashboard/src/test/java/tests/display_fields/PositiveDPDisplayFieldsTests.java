package tests.display_fields;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DataProfilesDisplayFieldsPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class PositiveDPDisplayFieldsTest extends BaseTest {
    DataProfilesDisplayFieldsPage dataProfilesDisplayFieldsPage = new DataProfilesDisplayFieldsPage();
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingsPage = new DataProfilesGeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();

    @Test(description = "Verify that all fields are displayed correctly")
    public void tc077_VerifyThatAllFieldsAreDisplayed() {
        Logger.step("Login with a valid user");
        loginPage.login("administrator", "");

        Logger.step("navigate to data profile page");
        dataProfilesPage.selectAdministerMenu("Data Profiles");

        Logger.step("Click Add new link");
        dataProfilesPage.clickAddNewLink();

        Logger.step("Enter Name field and select Item Type field");
        dataProfilesGeneralSettingsPage.createNewProfile("Test Data Profile", "test cases", "None");

        Logger.step("click next button");
        dataProfilesGeneralSettingsPage.clickNextButton();

        List<String> fieldsOfTestCases = new ArrayList<>();
        fieldsOfTestCases.add("ID");
        fieldsOfTestCases.add("Location");
        fieldsOfTestCases.add("Title");
        fieldsOfTestCases.add("Recent result");
        fieldsOfTestCases.add("Notes");
        fieldsOfTestCases.add("Source");
        fieldsOfTestCases.add("URL");

        Logger.verify("Verify that all fields are displayed correctly");
        Assert.assertEquals(dataProfilesDisplayFieldsPage.getTextOfCheckBox(), fieldsOfTestCases,
                "All fields displayed incorrectly");
    }
}