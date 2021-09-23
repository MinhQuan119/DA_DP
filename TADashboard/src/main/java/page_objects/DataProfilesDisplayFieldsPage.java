package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Label;
import utils.common.Constants;

import java.util.List;

public class DataProfilesDisplayFieldsPage extends BasePage {
    private Label lblProfileHeader = new Label("css=#profilesettings > tbody > tr > td.profilesettingheader");
    private Label lblDisplayFields = new Label("css=#profilesettings > tbody label");
    private CheckBox dynamicDisplayFieldCheckBox = new CheckBox("xpath=//table[@id='profilesettings']/tbody//label[contains(text(),'%s')]/input");

    public List<String> getAllDisplayFieldsLabels() {
        lblDisplayFields.waitForDisplay();
        return lblDisplayFields.getListText();
    }

    public boolean isFieldPrefixedWithCheckBox(String labelName) {
        dynamicDisplayFieldCheckBox.setDynamicValue(labelName);
        return dynamicDisplayFieldCheckBox.isVisible(Constants.SHORT_TIME_OUT);
    }
}