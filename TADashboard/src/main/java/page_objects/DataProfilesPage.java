package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class DataProfilesPage {
    private CheckBox dynamicCheckbox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/preceding-sibling::td/input");
    private Link dynamicDataProfile = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']");
    private Link dynamicAction = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/following::td[@class='center']/a/parent::td");

    public String getTextOfAction(String string) {
        dynamicAction.setDynamicValue(string.replace(" ", " "));
        return dynamicAction.getText();
    }

    public void clickOnDataProfile(String string) {
        dynamicDataProfile.setDynamicValue(string.replace(" ", " "));
        dynamicDataProfile.click();
    }

    public boolean isCheckBoxDisplayed(String string) {
        dynamicCheckbox.setDynamicValue(string.replace(" ", " "));
        return dynamicCheckbox.isVisible(Constants.SHORT_TIME_OUT);
    }
}