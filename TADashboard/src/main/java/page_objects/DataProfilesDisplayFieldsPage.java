package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Label;
import utils.common.Constants;

import java.util.List;

public class DataProfilesDisplayFieldsPage extends BasePage {
    private Label lblProfileHeader = new Label("css=#profilesettings > tbody > tr > td.profilesettingheader");
    private Label lblDisplayFieldsLabels = new Label("css=#profilesettings > tbody label");
    private CheckBox dynamicCheckBoxOfField = new CheckBox("xpath=//table[@id='profilesettings']/tbody//label[contains(text(),'%s')]/input");

    public List<String> getAllDisplayFieldsLabels() {
        lblDisplayFieldsLabels.waitForDisplay();
        return lblDisplayFieldsLabels.getListText();
    }

    public boolean isFieldPrefixedWithCheckBox(String labelName) {
        dynamicCheckBoxOfField.setDynamicValue(labelName);
        return dynamicCheckBoxOfField.isVisible(Constants.SHORT_TIME_OUT);
    }
}