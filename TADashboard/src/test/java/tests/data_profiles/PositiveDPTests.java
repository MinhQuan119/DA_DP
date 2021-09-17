package tests.data_profiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.DataHelper;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class PositiveDPTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingPage = new DataProfilesGeneralSettingsPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

        List<String> preSetDataProfiles = new ArrayList<>();
        preSetDataProfiles.add("Action Implementation By Status");
        preSetDataProfiles.add("Test Case Execution");
        preSetDataProfiles.add("Test Case Execution Failure Trend");
        preSetDataProfiles.add("Test Case Execution History");
        preSetDataProfiles.add("Test Case Execution Results");
        preSetDataProfiles.add("Test Case Execution Trend");
        preSetDataProfiles.add("Test Module Execution");
        preSetDataProfiles.add("Test Module Execution Failure Trend");
        preSetDataProfiles.add("Test Module Execution History");
        preSetDataProfiles.add("Test Module Execution Results");
        preSetDataProfiles.add("Test Module Execution Results Report");
        preSetDataProfiles.add("Test Module Execution Trend");
        preSetDataProfiles.add("Test Module Implementation By Priority");
        preSetDataProfiles.add("Test Module Implementation By Status");
        preSetDataProfiles.add("Test Module Status per Assigned Users");
        preSetDataProfiles.add("Test Objective Execution");

        for (String dataProfile : preSetDataProfiles) {
            Logger.verify("Verify that Edit and Delete are not displayed at " + dataProfile);
            Assert.assertFalse(dataProfilesPage.getTextOfAction(dataProfile).contains("Edit"), "Edit is available");
            Assert.assertFalse(dataProfilesPage.getTextOfAction(dataProfile).contains("Delete"), "Delete is available");

            Logger.verify(String.format("Verify that %s is not clickable.", dataProfile));
            Assert.assertFalse(dataProfilesPage.doesDataProfileHasLink(dataProfile), "Pre-set data profile is clickable");

            Logger.verify(String.format("Verify that in front of %s does not have a checkbox.", dataProfile));
            Assert.assertFalse(dataProfilesPage.isCheckBoxDisplayed(dataProfile), "Checkbox has displayed in front of pre-set data profile.");
        }
    }

    @Test(description = "Verify that Check Boxes are only present for non-preset Data Profiles.")
    public void tc068_CheckBoxesAreOnlyPresentForNonPresetDataProfiles() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

        Logger.step("Add new data profile");
        String name = DataHelper.getRandomText();
        dataProfilesPage.clickAddNewLink();
        dataProfilesGeneralSettingPage.createNewProfile(name, "test modules", "None");

        Logger.verify(String.format("Verify that in front of %s has a checkbox.", name));
        Assert.assertTrue(dataProfilesPage.isCheckBoxDisplayed(name), "Checkbox is not displayed in front of non-preset data profile.");
    }
}