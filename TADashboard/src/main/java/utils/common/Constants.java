package utils.common;

import utils.helper.PropertiesHelper;

public class Constants {

	// Common Constants
	public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.ini";
	public static final int TIME_OUT = Integer
			.parseInt(PropertiesHelper.getPropValue("driver.timeout"));
	public static final int SHORT_TIME_OUT = Integer
			.parseInt(PropertiesHelper.getPropValue("driver.shortTimeout"));

	// AUT Constants
	public static final String AUT_URL = PropertiesHelper.getPropValue("aut.url");
}
