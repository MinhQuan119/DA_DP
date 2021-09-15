package page_objects;

import com.logigear.control.common.imp.Link;

public class DataProfilesPage extends BasePage{
    private Link lnkAddNew = new Link("css=div[class='panel_tag2'] a[href='profile.jsp?action=create']");

    public void clickAddNewLink(){
        lnkAddNew.click();
    }
}