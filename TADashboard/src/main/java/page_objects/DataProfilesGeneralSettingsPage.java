package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.TextBox;

import java.util.List;

import java.util.List;

public class DataProfilesGeneralSettingsPage {
    private Button btnNext = new Button("css=input[value='Next']");
    private Button btnFinish = new Button("css=input[value='Finish']");
    private TextBox txtName = new TextBox("id=txtProfileName");
    private ComboBox cbbItemType = new ComboBox("id=cbbEntityType");
    private ComboBox cbbRelatedData = new ComboBox("id=cbbSubReport");

    public void clickNextButton() {
        btnNext.click();
    }

    public void clickFinishButton() {
        btnFinish.click();
    }

    public void createNewProfile(String name, String type, String relatedData) {
        txtName.enter(name);
        cbbItemType.select(type);
        cbbRelatedData.select(relatedData);
    }

    public List<String> getAllItemTypes() {
        return cbbItemType.getOptions();
    }
}