package tests.general_settings;

import com.logigear.driver.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DataProfilesPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

public class NegativeGeneralSettingsTest extends BaseTest {
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingsPage = new DataProfilesGeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();

    @Test(description = "Verify that user is unable to proceed to next step or finish creating data profile if 'Name*' field is left empty")
    public void tc069_UserIsUnableToProceedToNextStepOrFinishCreatingDataProfileIfNameFieldIsEmpty() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Navigate to data profile page");
        dataProfilesPage.selectAdministerMenu("Data Profiles");

        Logger.step("Click Add New link");
        dataProfilesPage.clickAddNewLink();

        Logger.step("Click Next button");
        dataProfilesGeneralSettingsPage.clickNextButton();

        Logger.verify("Verify that dialog message is display");
        Assert.assertEquals(DriverUtils.getAlertText(), "Please input profile name.", "Dialog doesn't display correct message");

        Logger.step("Click Ok in alert");
        DriverUtils.acceptAlert();

        Logger.step("Click Finish button");
        dataProfilesGeneralSettingsPage.clickFinishButton();

        Logger.verify("Verify that dialog message is display");
        Assert.assertEquals(DriverUtils.getAlertText(), "Please input profile name.", "Dialog doesn't display correct message");
    }
}