package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class DataProfilesPage extends BasePage {
    private CheckBox dynamicPresetCheckbox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/preceding-sibling::td/input");
    private CheckBox dynamicNonPresetCheckbox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td/a[text()='%s']/parent::td/preceding-sibling::td/input");
    private Link dynamicPresetDataProfile = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']");
    private Link dynamicNonPresetDataProfile = new Link("xpath=//table[@class='GridView']/tbody/tr/td/a[text()='%s']");
    private Link dynamicPresetAction = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/following-sibling::td[@class='center']/a/parent::td");
    private Link dynamicNonPresetAction = new Link("xpath=//table[@class='GridView']/tbody/tr/td/a[text()='%s']/parent::td/following-sibling::td[@class='center']/a/parent::td");

    public String getTextOfPresetAction(String action) {
        dynamicPresetAction.setDynamicValue(action.replace(" ", " "));
        return dynamicPresetAction.getText();
    }

    public String getTextOfNonPresetAction(String action) {
        dynamicNonPresetAction.setDynamicValue(action.replace(" ", " "));
        return dynamicNonPresetAction.getText();
    }

    public void clickOnPresetDataProfile(String dataProfile) {
        dynamicPresetDataProfile.setDynamicValue(dataProfile.replace(" ", " "));
        dynamicPresetDataProfile.click();
    }

    public boolean isPresetCheckBoxDisplayed(String checkbox) {
        dynamicPresetCheckbox.setDynamicValue(checkbox.replace(" ", " "));
        return dynamicPresetCheckbox.isVisible(Constants.SHORT_TIME_OUT);
    }
}