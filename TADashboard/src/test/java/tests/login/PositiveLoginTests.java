package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.DashboardPage;
import page_objects.LoginPage;
import tests.BaseTest;
import utils.helper.Logger;

public class PositiveLoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
    public void test_ValidLogin() {
        Logger.step("Login with a valid user");
        loginPage.login("administrator", "");

        Logger.verify("Verify that user is logged properly");
        Assert.assertTrue(dashboardPage.doesWelcomeLabelDisplay(), "Welcome label should be displayed after logged in");
    }
}
