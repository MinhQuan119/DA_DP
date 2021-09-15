package page_objects;

import com.logigear.control.common.imp.Link;

public class BasePage {
    private Link dynamicNavigateToPage = new Link("xpath=//ul[@id='ulAdminister']/li/a[text()='%s']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");

    public void selectAdministerMenu(String pageName) {
        lnkAdminister.click();
        dynamicNavigateToPage.setDynamicValue(pageName);
        dynamicNavigateToPage.click();
    }
}
