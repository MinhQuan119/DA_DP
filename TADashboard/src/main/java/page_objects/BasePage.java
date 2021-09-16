package page_objects;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;

public class BasePage {
    private final Label lblWelcome = new Label("css=a[href='#Welcome']");
    private final Label lblAdminister = new Label("css=a[href='#Administer']");
    private final Link dynamicAdministerMenu = new Link("xpath=//div[@id='header']//a[text()='%s']");

    public void selectAdministerMenu(String pageName) {
        lblAdminister.click();
        dynamicAdministerMenu.setDynamicValue(pageName);
        dynamicAdministerMenu.waitForElementClickable();
        dynamicAdministerMenu.click();
    }

    public boolean doesWelcomeLabelDisplay() {
        return lblWelcome.isVisible();
    }
}