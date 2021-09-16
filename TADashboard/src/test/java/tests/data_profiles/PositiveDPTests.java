package tests.data_profiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

public class PositiveDPTests extends BaseTest {
    private String[] preSetDataProfiles = {
            "Action Implementation By Status",
            "Test Case Execution",
            "Test Case Execution Failure Trend",
            "Test Case Execution History",
            "Test Case Execution Results",
            "Test Case Execution Trend",
            "Test Module Execution",
            "Test Module Execution Failure Trend",
            "Test Module Execution History",
            "Test Module Execution Results",
            "Test Module Execution Results Report",
            "Test Module Execution Trend",
            "Test Module Implementation By Priority",
            "Test Module Implementation By Status",
            "Test Module Status per Assigned Users",
            "Test Objective Execution",
    };

    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USER_NAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

        for (int i = 0; i < preSetDataProfiles.length; i++) {
            Logger.verify("Verify that Edit and Delete are not displayed at " + preSetDataProfiles[i]);
            Assert.assertFalse(dataProfilesPage.getTextOfPresetAction(preSetDataProfiles[i]).contains("Edit"), "Edit is available");
            Assert.assertFalse(dataProfilesPage.getTextOfPresetAction(preSetDataProfiles[i]).contains("Delete"), "Delete is available");

            Logger.verify(String.format("Verify that %s is not clickable.", preSetDataProfiles[i]));
            dataProfilesPage.clickOnPresetDataProfile(preSetDataProfiles[i]);

            Logger.verify(String.format("Verify that in front of %s does not have a checkbox.", preSetDataProfiles[i]));
            Assert.assertFalse(dataProfilesPage.isPresetCheckBoxDisplayed(preSetDataProfiles[i]), "Checkbox has displayed in front of pre-set data profile.");
        }
    }
}