package page_objects;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;
import com.logigear.driver.DriverUtils;

public class BasePage {
    private final Label lblWelcome = new Label("css=a[href='#Welcome']");
    private final Label lblAdminister = new Label("css=a[href='#Administer']");
    private final Link dynamicMenu = new Link("xpath=//div[@id='header']//a[text()='%s']");

    public void selectWelcomeMenu(String pageName) {
        lblWelcome.click();
        dynamicMenu.setDynamicValue(pageName);
        dynamicMenu.click();
    }

    public void selectAdministerMenu(String pageName) {
        lblAdminister.click();
        dynamicMenu.setDynamicValue(pageName);
        dynamicMenu.click();
    }

    public boolean doesWelcomeLabelDisplay() {
        return lblWelcome.isVisible();
    }

    public boolean doesAdministerLabelDisplay() {
        return lblAdminister.isVisible();
    }

    public String getAlertText() {
        return DriverUtils.getAlertText();
    }

    public void clickOkOnAlert() {
        DriverUtils.acceptAlert();
    }
}