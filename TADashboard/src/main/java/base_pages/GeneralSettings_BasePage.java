package base_pages;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.Label;

public class GeneralSettings_BasePage extends BasePage {
    private Button btnFinish = new Button("css=input[value='Finish']");
    private Button btnCancel = new Button("css=input[value='Cancel']");
    private Label dynamicLabel = new Label("xpath=//ul[@id='wstep']/li[text()='%s']");

    public void clickFinishButton(){
        btnFinish.click();
    }

    public void clickCancelButton(){
        btnCancel.click();
    }

    public void selectLabel(String lblName){
        dynamicLabel.setDynamicValue(lblName);
        dynamicLabel.click();
    }
}