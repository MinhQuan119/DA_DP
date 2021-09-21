package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Label;
import utils.common.Constants;

import java.util.List;

public class DataProfilesDisplayFieldsPage extends BasePage {
    private Label profileHeader = new Label("css=#profilesettings > tbody > tr > td.profilesettingheader");
    private Label displayFieldLabels = new Label("css=#profilesettings > tbody label");
    private CheckBox dynamicCheckBox = new CheckBox("xpath=//table[@id='profilesettings']/tbody//label[contains(text(),'%s')]/input");

    public List<String> getAllLabels() {
        displayFieldLabels.waitForDisplay();
        return displayFieldLabels.getListText();
    }

    public boolean isCheckBoxDisplayed(String labelName) {
        dynamicCheckBox.setDynamicValue(labelName);
        return dynamicCheckBox.isVisible(Constants.SHORT_TIME_OUT);
    }
}