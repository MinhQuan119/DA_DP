package page_objects;

import com.logigear.control.common.imp.Label;

import java.util.List;

public class DataProfilesDisplayFieldsPage {
    private Label lblDisplayField = new Label("css=table[id='profilesettings'] tbody label");

    public List<String> getAllDisplayFieldsLabels() {
        lblDisplayField.waitForDisplay();
        return lblDisplayField.getListText();
    }
}
