package page_objects;

import com.logigear.control.common.imp.CheckBox;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class DataProfilesPage {
    private CheckBox inFrontCheckBox = new CheckBox("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/preceding-sibling::td/input");
    private Link dataProfileLink = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']");
    private Link actionLink = new Link("xpath=//table[@class='GridView']/tbody/tr/td[text()='%s']/following-sibling::td[count(//table[@class='GridView']/tbody/tr/th)-2]");

    public String getTextOfAction(String string) {
        actionLink.setDynamicValue(string);
        return actionLink.getText();
    }

    public void clickOnPreSetDataProfile(String string) {
        dataProfileLink.setDynamicValue(string);
        dataProfileLink.click();
    }

    public boolean isCheckBoxDisplayed(String string) {
        inFrontCheckBox.setDynamicValue(string);
        return inFrontCheckBox.isVisible(Constants.SHORT_TIME_OUT);
    }
}