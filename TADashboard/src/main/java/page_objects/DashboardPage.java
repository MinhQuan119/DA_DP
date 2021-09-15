package page_objects;

import com.logigear.control.common.imp.Label;
import com.logigear.control.common.imp.Link;

public class DashboardPage {
    private Label lblWelcome = new Label("css=a[href='#Welcome']");

    public boolean doesWelcomeLabelDisplay() {
        return lblWelcome.isVisible();
    }

}