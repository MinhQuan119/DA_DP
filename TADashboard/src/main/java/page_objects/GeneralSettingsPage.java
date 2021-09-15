package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Link;
import com.logigear.driver.DriverUtils;

public class GeneralSettingsPage {
    private Button btnNext = new Button("css=input[value='Next']");
    private Button btnFinish = new Button("css=input[value='Finish']");
    private Link lnkDataProfiles = new Link("css=li>ul>li>a[href='profiles.jsp']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");

    public void clickNextButton() {
        btnNext.click();
    }

    public void clickFinishButton() {
        btnFinish.click();
    }

    public void selectAdministerMenu(DataProfilesPage dataProfilesPage) {
        lnkAdminister.click();
        lnkDataProfiles.click();
    }
}