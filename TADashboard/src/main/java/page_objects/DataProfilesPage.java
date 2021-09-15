package page_objects;

import com.logigear.control.common.imp.Link;

public class DataProfilesPage {
    private Link lnkAddNew = new Link("css=div[class='panel_tag2'] a[href='profile.jsp?action=create']");
    private Link dynamicNavigateToPage = new Link("xpath=//ul[@id='ulAdminister']/li/a[text()='%s']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");

    public void clickAddNewLink(){
        lnkAddNew.click();
    }

    public void selectInAdministerMenu(String pageName) {
        lnkAdminister.click();
        dynamicNavigateToPage.setDynamicValue(pageName);
        dynamicNavigateToPage.click();
    }
}