package tests.display_fields;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.DataProfilesDisplayFieldsPage;
import page_objects.DataProfilesGeneralSettingsPage;
import page_objects.DataProfilesPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.common.Constants;
import utils.helper.Logger;

import java.util.List;

public class PositiveDPDisplayFieldsTests extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private DataProfilesPage dataProfilesPage = new DataProfilesPage();
    private DataProfilesGeneralSettingsPage generalSettingsPage = new DataProfilesGeneralSettingsPage();
    private DataProfilesDisplayFieldsPage displayFieldsPage = new DataProfilesDisplayFieldsPage();

    @BeforeMethod(onlyForGroups = "g1")
    public void loginAndAddDataProfile() {
        Logger.step("Login with a valid user");
        loginPage.login(Constants.USERNAME, "");

        Logger.step("Navigate to data profile page");
        dataProfilesPage.selectAdministerMenu("Data Profiles");

        if (!dataProfilesPage.isDataProfileVisible("A")) {
            dataProfilesPage.clickAddNewLink();
            Logger.step("Add data profile name 'A' ");
            generalSettingsPage.createNewProfile("A", "test modules", "None");
        }
    }

    @Test(description = "Verify that all fields are pre-fixed with check boxes", groups = "g1")
    public void tc78_AllFieldsArePrefixedWithCheckBoxes() {
        Logger.step("Click data profile A");
        dataProfilesPage.clickOnDataProfile("A");

        Logger.step("Click Next button");
        generalSettingsPage.clickNextButton();

        List<String> allLabels = displayFieldsPage.getAllDisplayFieldsLabels();
        Logger.verify("Verify that all fields are pre-fixed with check boxes");
        for (String label : allLabels) {
            Assert.assertTrue(displayFieldsPage.isFieldPrefixedWithCheckBox(label), label + " is not pre-fixed with check box");
        }
    }
}