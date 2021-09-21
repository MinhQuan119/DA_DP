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
    public void loginAndNavigateToDPGeneralSettingsPage() {
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
        optionInTypeItem.add("Test Modules");
        optionInTypeItem.add("Test Cases");
        optionInTypeItem.add("Test Objectives");
        optionInTypeItem.add("Data Sets");
        optionInTypeItem.add("Actions");
        optionInTypeItem.add("Interface Entities");
        optionInTypeItem.add("Test Results");
        optionInTypeItem.add("Test Case Results");
        optionInTypeItem.add("Test Suites");
        optionInTypeItem.add("Bugs");

        Logger.verify("Items are listed in priority order");
        dataProfilesGeneralSettingsPage.clickItemTypeComboBox();
        Assert.assertEquals(dataProfilesGeneralSettingsPage.getOptionsInItemType(), optionInTypeItem,
                "items are unlisted in priority order");
    }

    @Test(description = "Verify that special characters is not allowed for input to 'Name *' field")
    public void tc070_SpecialCharactersIsNotAllowedForInputToNameField() {
        Logger.step("Add new Data Profile with input special characters into 'Name *' field");
        dataProfilesGeneralSettingsPage.createNewProfile("/:*?<>|\"#[ ]{}=%;", "test modules", "None");

        Logger.verify("Verify that dialog message is displayed as expected");
        Assert.assertEquals(
                DriverUtils.getAlertText(),
                "Invalid name. The name cannot contain high ASCII characters or any of the following characters: /:*?<>|\"#[]{}=%;",
                "Special characters '/:*?<>|\"#[ ]{}=%;'is allowed for input to 'Name *' field"
        );
    }
}