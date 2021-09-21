package tests.general_settings;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class PositiveDPGeneralSettingsTests extends BaseTest {
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingsPage = new DataProfilesGeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();

    @BeforeMethod
    public void loginAndNavigateToDPGeneralSettingsPage() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Navigate to data profile page");
        dataProfilesPage.selectAdministerMenu("Data Profiles");

        Logger.step("Click Add New link");
        dataProfilesPage.clickAddNewLink();
    }

    @Test(description = "Verify that all data profile types are listed under 'Item Type' dropped down menu")
    public void tc072_AllDataProfileTypesAreListedUnderItemTypeDroppedDownMenu() {
        List<String> listItemTypes = new ArrayList<>();
        listItemTypes.add("Test Modules");
        listItemTypes.add("Test Cases");
        listItemTypes.add("Test Objectives");
        listItemTypes.add("Data Sets");
        listItemTypes.add("Actions");
        listItemTypes.add("Interface Entities");
        listItemTypes.add("Test Results");
        listItemTypes.add("Test Case Results");
        listItemTypes.add("Test Suites");
        listItemTypes.add("Bugs");

        Logger.verify("Verify that all data profile types are listed under 'Item Type' dropped down menu");
        Assert.assertTrue(dataProfilesGeneralSettingsPage.areItemTypesDisplayedInOptions(listItemTypes),
                "Data profile types is not displayed in dropdown list as expected");
    }
}