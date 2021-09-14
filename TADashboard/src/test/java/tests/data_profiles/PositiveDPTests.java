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
    //Pre-set Data Profiles
    public final String[] PRE_SET_DATA_PROFILES = {
            "Action Implementation By Status",
            "Test Case Execution",
            "Test Case Execution Failure Trend",
            "Test Case Execution History",
            "Test Case Execution Results",
            "Test Case Execution Trend",
            "Test Module Execution",
            "Test Module Execution Failure Trend",
            "Test Module Execution History",
            "Test Module Execution Results",
            "Test Module Execution Results Report",
            "Test Module Execution Trend",
            "Test Module Implementation By Priority",
            "Test Module Implementation By Status",
            "Test Module Status per Assigned Users",
            "Test Objective Execution",
    };

    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USER_NAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.navigateToDataProfiles();

        for (int i = 0; i < PRE_SET_DATA_PROFILES.length; i++) {
            Logger.step("Verify that Edit and Delete are not displayed at " + PRE_SET_DATA_PROFILES[i]);
            Assert.assertNotEquals(dataProfilesPage.getTextOfAction(PRE_SET_DATA_PROFILES[i]), "Edit", "Edit is available");
            Assert.assertNotEquals(dataProfilesPage.getTextOfAction(PRE_SET_DATA_PROFILES[i]), "Delete", "Delete is available");

            Logger.step(String.format("Verify that %s is not clickable.", PRE_SET_DATA_PROFILES[i]));
            dataProfilesPage.clickOnDataProfile(PRE_SET_DATA_PROFILES[i]);

            Logger.step(String.format("Verify that in front of %s does not have a checkbox.", PRE_SET_DATA_PROFILES[i]));
            Assert.assertFalse(dataProfilesPage.isCheckBoxDisplayed(PRE_SET_DATA_PROFILES[i]), "Checkbox has displayed in front of pre-set data profile.");
        }
    }
}