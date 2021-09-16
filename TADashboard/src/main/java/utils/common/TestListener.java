package utils.common;

import com.logigear.driver.DriverUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.util.UUID;

public class TestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String path = DriverUtils
				.captureScreenshot(UUID.randomUUID().toString(), "screenshots");

		if (!path.isEmpty()) {
			String script = Common.screenshotURI(path);
			Reporter.log(script);
			new File(path).delete();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String path = DriverUtils
				.captureScreenshot(UUID.randomUUID().toString(), "screenshots");

		if (!path.isEmpty()) {
			String script = Common.screenshotURI(path);
			Reporter.log(script);
			new File(path).delete();
		}
	}

	public void onStart(ITestContext context) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}
}
