package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.driver.DriverUtils;

public class GeneralSettingsPage {
    private Button btnNext = new Button("css=input[value='Next']");
    private Button btnFinish = new Button("css=input[value='Finish']");

    public void clickNextButton() {
        btnNext.click();
    }

    public void clickFinishButton() {
        btnFinish.click();
    }

    public String getAlertText() {
        return DriverUtils.getWebDriver().switchTo().alert().getText();
    }
}