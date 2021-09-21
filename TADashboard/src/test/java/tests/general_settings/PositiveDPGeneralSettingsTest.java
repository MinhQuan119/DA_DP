package tests.general_settings;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class PositiveDPGeneralSettingsTest extends BaseTest {
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingsPage = new DataProfilesGeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void loginAndNavigateToDPGeneralSettingsPage() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

        Logger.step("Click Add New link");
        dataProfilesPage.clickAddNewLink();
    }

    @Test(description = "Verify that all data profile types are listed in priority order under 'Item Type' dropped down menu")
    public void tc073_AllDataProfileTypesAreListed() {
        List<String> optionsInTypeItem = new ArrayList<>();
        optionsInTypeItem.add("Test Modules");
        optionsInTypeItem.add("Test Cases");
        optionsInTypeItem.add("Test Objectives");
        optionsInTypeItem.add("Data Sets");
        optionsInTypeItem.add("Actions");
        optionsInTypeItem.add("Interface Entities");
        optionsInTypeItem.add("Test Results");
        optionsInTypeItem.add("Test Case Results");
        optionsInTypeItem.add("Test Suites");
        optionsInTypeItem.add("Bugs");

        Logger.verify("Items are listed in priority order");
        dataProfilesGeneralSettingsPage.clickItemTypeComboBox();
        Assert.assertEquals(dataProfilesGeneralSettingsPage.getOptionsInItemType(), optionsInTypeItem,
                "items are unlisted in priority order");
    }
}