package page_objects;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;

public class DashboardPage {
    private Link lnkDataProfiles = new Link("css=li>ul>li>a[href='profiles.jsp']");
    private Link lnkAdminister = new Link("css=a[href='#Administer']");
    private Label lblWelcome = new Label("css=a[href='#Welcome']");

    public boolean doesWelcomeLabelDisplay() {
        return lblWelcome.isVisible();
    }

    public void navigateToDataProfiles() {
        lnkAdminister.click();
        lnkDataProfiles.click();
    }
}