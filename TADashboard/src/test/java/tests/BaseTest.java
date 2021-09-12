package tests;

import com.logigear.driver.DriverProperty;
import com.logigear.driver.DriverUtils;
import com.logigear.helper.BrowserSettingHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.common.Constants;
import utils.helper.Logger;

public class BaseTest {

	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String browser) throws Exception {
		DriverProperty driverProperty = BrowserSettingHelper.getDriverProperty(Constants.BROWSER_SETTING_FILE, browser);
		DriverUtils.getDriver(driverProperty);
		DriverUtils.setTimeOut(Constants.TIME_OUT);
		DriverUtils.navigate(Constants.AUT_URL);
	}

	@AfterMethod
	public void afterMethod() {
		DriverUtils.quitBrowser();
	}
}
