package utils.common;

import utils.helper.PropertiesHelper;

public class Constants {
    public static final String USER_NAME = "administrator";

    // Common Constants
    public static final String BROWSER_SETTING_FILE = "src/test/resources/browsers.setting.ini";
    public static final int TIME_OUT = Integer
            .parseInt(PropertiesHelper.getPropValue("driver.timeout"));
    public static final int SHORT_TIME_OUT = Integer
            .parseInt(PropertiesHelper.getPropValue("driver.shortTimeout"));

    // AUT Constants
    public static final String AUT_URL = PropertiesHelper.getPropValue("aut.url");

    //Pre-set Data Profiles
    public static final String[] PRE_SET_DATA_PROFILES = {
            "Action Implementation By Status",
            "Test Case Execution",
            "Test Case Execution Failure Trend",
            "Test Case Execution History",
            "Test Case Execution Results",
            "Test Case Execution Trend",
            "Test Module Execution",
            "Test Module Execution Failure Trend",
            "Test Module Execution History",
            "Test Module Execution Results",
            "Test Module Execution Results Report",
            "Test Module Execution Trend",
            "Test Module Implementation By Priority",
            "Test Module Implementation By Status",
            "Test Module Status per Assigned Users",
            "Test Objective Execution",
    };
}