package page_objects;

import com.logigear.control.common.imp.Link;

public class BasePage {
    private Link dynamicAdministerMenu = new Link("xpath=//ul[@id='ulAdminister']/li/a[text()='%s']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");

    public void selectAdministerMenu(String menu) {
        lnkAdminister.click();
        dynamicAdministerMenu.setDynamicValue(menu);
        dynamicAdministerMenu.click();
    }
}