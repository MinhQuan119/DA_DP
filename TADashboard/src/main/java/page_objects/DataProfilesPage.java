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

    public String getTextOfPresetAction(String profileName) {
        dynamicPresetAction.setDynamicValue(profileName.replace(" ", " "));
        return dynamicPresetAction.getText();
    }

    public String getTextOfNonPresetAction(String profileName) {
        dynamicNonPresetAction.setDynamicValue(profileName.replace(" ", " "));
        return dynamicNonPresetAction.getText();
    }

    public void clickOnPresetDataProfile(String profileName) {
        dynamicPresetDataProfile.setDynamicValue(profileName.replace(" ", " "));
        dynamicPresetDataProfile.click();
    }

    public boolean doesPresetDataProfileHasLink(String profileName) {
        boolean bool = true;
        dynamicPresetDataProfile.setDynamicValue(profileName.replace(" ", " "));
        if(dynamicPresetDataProfile.getAttribute("href") == null) bool = false;
        return bool;
    }

    public boolean isPresetCheckBoxDisplayed(String profileName) {
        dynamicPresetCheckbox.setDynamicValue(profileName.replace(" ", " "));
        return dynamicPresetCheckbox.isVisible(Constants.SHORT_TIME_OUT);
    }
}