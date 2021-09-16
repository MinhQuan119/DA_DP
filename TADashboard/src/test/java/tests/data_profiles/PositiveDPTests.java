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
    private List<String> setupPreSetDataProfiles() {
        List<String> list = new ArrayList<>();
        list.add("Action Implementation By Status");
        list.add("Test Case Execution");
        list.add("Test Case Execution Failure Trend");
        list.add("Test Case Execution History");
        list.add("Test Case Execution Results");
        list.add("Test Case Execution Trend");
        list.add("Test Module Execution");
        list.add("Test Module Execution Failure Trend");
        list.add("Test Module Execution History");
        list.add("Test Module Execution Results");
        list.add("Test Module Execution Results Report");
        list.add("Test Module Execution Trend");
        list.add("Test Module Implementation By Priority");
        list.add("Test Module Implementation By Status");
        list.add("Test Module Status per Assigned Users");
        list.add("Test Objective Execution");
        return list;
    }

    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USER_NAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");
        List<String> preSetDataProfiles = setupPreSetDataProfiles();

        for (int i = 0; i < preSetDataProfiles.size(); i++) {
            Logger.verify("Verify that Edit and Delete are not displayed at " + preSetDataProfiles.get(i));
            Assert.assertFalse(dataProfilesPage.getTextOfPresetAction(preSetDataProfiles.get(i)).contains("Edit"), "Edit is available");
            Assert.assertFalse(dataProfilesPage.getTextOfPresetAction(preSetDataProfiles.get(i)).contains("Delete"), "Delete is available");

            Logger.verify(String.format("Verify that %s is not clickable.", preSetDataProfiles.get(i)));
            Assert.assertFalse(dataProfilesPage.doesPresetDataProfileHasLink(preSetDataProfiles.get(i)), "Pre-set data profile is clickable");

            Logger.verify(String.format("Verify that in front of %s does not have a checkbox.", preSetDataProfiles.get(i)));
            Assert.assertFalse(dataProfilesPage.isPresetCheckBoxDisplayed(preSetDataProfiles.get(i)), "Checkbox has displayed in front of pre-set data profile.");
        }
    }
}