package page_objects;

import com.logigear.control.common.imp.Link;

public class DataProfilesPage {
    private Link lnkAddNew = new Link("css=div[class='panel_tag2'] a[href='profile.jsp?action=create']");
    private Link lnkDataProfiles = new Link("css=li>ul>li>a[href='profiles.jsp']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");

    public void clickAddNewLink(){
        lnkAddNew.click();
    }
    public void selectAdministerMenu(String string) {
        lnkAdminister.click();
        lnkDataProfiles.click();
    }
}
