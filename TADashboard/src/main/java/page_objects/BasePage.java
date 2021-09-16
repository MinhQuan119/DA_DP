package page_objects;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;
import utils.common.Constants;

public class BasePage {
    private final Label lblWelcome = new Label("css=a[href='#Welcome']");
    private final Label lblAdminister = new Label("css=a[href='#Administer']");
    private final Link dynamicAdministerMenu = new Link("xpath=//div[@id='header']//a[text()='%s']");

    public void selectAdministerMenu(String pageName) {
        lblAdminister.waitForElementClickable(Constants.SHORT_TIME_OUT);
        lblAdminister.click();
        dynamicAdministerMenu.setDynamicValue(pageName);
        dynamicAdministerMenu.waitForElementClickable(Constants.SHORT_TIME_OUT);
        dynamicAdministerMenu.click();
    }

    public boolean doesWelcomeLabelDisplay() {
        return lblWelcome.isVisible();
    }
}