package tests.data_profiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class PositiveDPTests extends BaseTest {
    List<String> preSetDataProfiles = new ArrayList<>();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

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

        for (String dataProfile: preSetDataProfiles) {
            Logger.verify("Verify that Edit and Delete are not displayed at " + dataProfile);
            Assert.assertFalse(dataProfilesPage.getTextOfAction(dataProfile).contains("Edit"), "Edit is available");
            Assert.assertFalse(dataProfilesPage.getTextOfAction(dataProfile).contains("Delete"), "Delete is available");

            Logger.verify(String.format("Verify that %s is not clickable.", dataProfile));
            Assert.assertFalse(dataProfilesPage.doesDataProfileHasLink(dataProfile), "Pre-set data profile is clickable");

            Logger.verify(String.format("Verify that in front of %s does not have a checkbox.", dataProfile));
            Assert.assertFalse(dataProfilesPage.isCheckBoxDisplayed(dataProfile), "Checkbox has displayed in front of pre-set data profile.");
        }
    }
}