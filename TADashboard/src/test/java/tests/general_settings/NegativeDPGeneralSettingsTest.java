package tests.general_settings;

import com.logigear.driver.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.DataProfilesPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

import java.util.ArrayList;
import java.util.List;

public class NegativeDPGeneralSettingsTest extends BaseTest {
    DataProfilesGeneralSettingsPage dataProfilesGeneralSettingsPage = new DataProfilesGeneralSettingsPage();
    LoginPage loginPage = new LoginPage();
    DataProfilesPage dataProfilesPage = new DataProfilesPage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void loginAndNavigateToDPPage() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Go to Data Profiles page.");
        dashboardPage.selectAdministerMenu("Data Profiles");

        Logger.step("Click Add New link");
        dataProfilesPage.clickAddNewLink();
    }

    @Test(description = "Verify that user is unable to proceed to next step or finish creating data profile if 'Name*' field is left empty")
    public void tc069_UserIsUnableToProceedToNextStepOrFinishCreatingDataProfileIfNameFieldIsEmpty() {
        Logger.step("Click Next button");
        dataProfilesGeneralSettingsPage.clickNextButton();

        Logger.verify("Verify that dialog message is displayed");
        Assert.assertEquals(DriverUtils.getAlertText(), "Please input profile name.", "Dialog doesn't display correct message");

        Logger.step("Click Ok in alert");
        DriverUtils.acceptAlert();

        Logger.step("Click Finish button");
        dataProfilesGeneralSettingsPage.clickFinishButton();

        Logger.verify("Verify that dialog message is displayed");
        Assert.assertEquals(DriverUtils.getAlertText(), "Please input profile name.", "Dialog doesn't display correct message");
    }

    @Test(description = "Verify that all data profile types are listed in priority order under 'Item Type' dropped down menu")
    public void tc073_AllDataProfileTypesAreListed() {
        List<String> optionInTypeItem = new ArrayList<>();
        optionInTypeItem.add("test modules");
        optionInTypeItem.add("test cases");
        optionInTypeItem.add("test objectives");
        optionInTypeItem.add("data sets");
        optionInTypeItem.add("actions");
        optionInTypeItem.add("interface entities");
        optionInTypeItem.add("test results");
        optionInTypeItem.add("test case results");
        optionInTypeItem.add("test suites");
        optionInTypeItem.add("bugs");
        Logger.verify("Items are listed in priority order");
        dataProfilesGeneralSettingsPage.clickItemTypeComboBox();
        for (String option : optionInTypeItem) {
            Assert.assertTrue(dataProfilesGeneralSettingsPage.isOptionVisible(option),
                    "items are unlisted in priority order");
        }
    }
}