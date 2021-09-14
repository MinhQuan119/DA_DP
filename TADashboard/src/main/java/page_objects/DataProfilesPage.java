package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class DataProfilesPage {
    private CheckBox dynamicCheckBox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/preceding-sibling::td/input");
    private Link dynamicDataProfile = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']");
    private Link dynamicAction = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/following-sibling::td[count(//table[@class='GridView']/tbody/tr/th)-2]");

    public String getTextOfAction(String string) {
        dynamicAction.setDynamicValue(string);
        return dynamicAction.getText();
    }

    public void clickOnPreSetDataProfile(String string) {
        dynamicDataProfile.setDynamicValue(string);
        dynamicDataProfile.click();
    }

    public boolean isCheckBoxDisplayed(String string) {
        dynamicCheckBox.setDynamicValue(string);
        return dynamicCheckBox.isVisible(Constants.SHORT_TIME_OUT);
    }
}