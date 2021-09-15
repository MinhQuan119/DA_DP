package page_objects;

import base_pages.GeneralSettings_BasePage;
import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.ComboBox;
import com.logigear.control.common.imp.TextBox;

public class GeneralSettingsPage extends GeneralSettings_BasePage {
    private TextBox txtName = new TextBox("id=txtProfileName");
    private ComboBox cbbItemType = new ComboBox("id=cbbEntityType");
    private ComboBox cbbRelatedData = new ComboBox("id=cbbSubReport");
    private Button btnNext = new Button("css=input[value='Next']");

    public void clickNextButton() {
        btnNext.click();
    }

    public void createNewDataProfiles(String name) {
        txtName.enter(name);
    }

    public void selectItemType(String itemType) {
        cbbItemType.select(itemType);
    }

    public void createNewProfile(String name, String type, String relatedData) {
        txtName.enter(name);
        cbbItemType.select(type);
        cbbRelatedData.select(relatedData);
        clickFinishButton();
    }
}