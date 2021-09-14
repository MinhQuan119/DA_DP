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
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
    public void tc066_PreSetDataProfilesArePopulatedCorrectly() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USER_NAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.navigateToDataProfiles();

        for (int i = 0; i < Constants.PRE_SET_DATA_PROFILES.length; i++) {
            Logger.step("Verify that Edit and Delete are not displayed at " + Constants.PRE_SET_DATA_PROFILES[i]);
            Assert.assertNotEquals(dataProfilesPage.getTextOfAction(Constants.PRE_SET_DATA_PROFILES[i]), "Edit", "Edit is available");
            Assert.assertNotEquals(dataProfilesPage.getTextOfAction(Constants.PRE_SET_DATA_PROFILES[i]), "Delete", "Delete is available");

            Logger.step(String.format("Verify that %s is not clickable.", Constants.PRE_SET_DATA_PROFILES[i]));
            dataProfilesPage.clickOnPreSetDataProfile(Constants.PRE_SET_DATA_PROFILES[i]);

            Logger.step(String.format("Verify that in front of %s does not have a checkbox.", Constants.PRE_SET_DATA_PROFILES[i]));
            Assert.assertFalse(dataProfilesPage.isCheckBoxDisplayed(Constants.PRE_SET_DATA_PROFILES[i]), "Checkbox has displayed in front of pre-set data profile.");
        }
    }
}