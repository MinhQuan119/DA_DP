package tests.general_settings;

import com.logigear.driver.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesPage;
import page_objects.GeneralSettingsPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

public class NegativeGeneralSettingsTest extends BaseTest {
    GeneralSettingsPage generalSettingsPage = new GeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that user is unable to proceed to next step or finish creating data profile if 'Name*' field is left empty")
    public void tc069_UserIsUnableToProceedToNextStepOrFinishCreatingDataProfileIfNameFieldIsEmpty() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("navigate to data profile page");
        dashboardPage.clickDataProfilesLink(dataProfilesPage);

        Logger.step("Click Add new link");
        dataProfilesPage.clickAddNewLink();

        Logger.step("click next button");
        generalSettingsPage.clickNextButton();

        Logger.verify("Verify that dialog message is display");
        Assert.assertEquals(generalSettingsPage.getAlertText(), "Please input profile name.", "Dialog message doesn't displayed");

        Logger.step("Click Ok in alert");
        DriverUtils.acceptAlert();

        Logger.step("Click finish button");
        generalSettingsPage.clickFinishButton();

        Logger.verify("Verify that dialog message is display");
        Assert.assertEquals(generalSettingsPage.getAlertText(), "Please input profile name.", "Dialog message doesn't displayed");
    }
}