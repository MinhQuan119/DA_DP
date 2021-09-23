package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class DataProfilesPage extends BasePage {
    private CheckBox dynamicDataProfileCheckbox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td[.='%s']/preceding-sibling::td/input");
    private Label dynamicDataProfile = new Label("xpath=//table[@class='GridView']/tbody/tr/td[.='%s']");
    private Link dynamicDataProfileAction = new Link("xpath=//table[@class='GridView']/tbody/tr/td[.='%s']/following-sibling::td[@class='center']/a/parent::td");
    private Link lnkAddNew = new Link("css=div[class='panel_tag2'] a[href='profile.jsp?action=create']");

    public String getTextOfAction(String profileName) {
        dynamicDataProfileAction.setDynamicValue(profileName.replace(" ", " "));
        return dynamicDataProfileAction.getText();
    }

    public void clickOnDataProfile(String profileName) {
        dynamicDataProfile.getChildElement(String.format("//table[@class='GridView']/tbody/tr/td[.='%s']/a", profileName.replace(" ", " "))).click();
    }

    public boolean doesDataProfileHasLink(String profileName) {
        dynamicDataProfile.setDynamicValue(profileName.replace(" ", " "));
        return (dynamicDataProfile.getAttribute("href") != null);
    }

    public boolean isCheckBoxDisplayed(String profileName) {
        dynamicDataProfileCheckbox.setDynamicValue(profileName.replace(" ", " "));
        return dynamicDataProfileCheckbox.isVisible(Constants.SHORT_TIME_OUT);
    }

    public void clickAddNewLink() {
        lnkAddNew.waitForElementClickable(Constants.SHORT_TIME_OUT);
        lnkAddNew.click();
    }

    public boolean isDataProfileVisible(String dataProfile) {
        dynamicDataProfile.setDynamicValue(dataProfile.replace(" ", " "));
        return dynamicDataProfile.isVisible();
    }
}