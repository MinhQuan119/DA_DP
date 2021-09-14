package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.driver.DriverUtils;

public class GeneralSettingsPage {
    private Button btnNext = new Button("css=input[value='Next']");
    private Button btnFinish = new Button("css=input[value='Finish']");

    public void clickBtnNext() {
        btnNext.click();
    }

    public void clickBtnFinish() {
        btnFinish.click();
    }

    public String isAlertVisible() {
        return DriverUtils.getWebDriver().switchTo().alert().getText();
    }

    public void clickOKInAlert() {
        DriverUtils.acceptAlert();
    }
}
