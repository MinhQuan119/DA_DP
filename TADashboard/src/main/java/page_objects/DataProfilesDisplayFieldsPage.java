package page_objects;

import com.logigear.control.common.imp.CheckBox;

import java.util.List;

public class DataProfilesDisplayFieldsPage {
    private CheckBox dynamicCheckBox = new CheckBox("css=table[id='profilesettings'] tbody label");

    public List<String> getTextOfCheckBox() {
        dynamicCheckBox.waitForDisplay();
        return dynamicCheckBox.getListText();
    }
}
