package page_objects;

import com.logigear.control.common.imp.Button;
import com.logigear.control.common.imp.TextBox;

public class LoginPage {
    private TextBox txtUsername = new TextBox("id=username");
    private TextBox txtPassword = new TextBox("id=password");
    private Button btnLogin = new Button("class=btn-login");

    public void login(String username, String password) {
        txtUsername.waitForDisplay();
        txtUsername.enter(username);
        txtPassword.enter(password);
        btnLogin.click();
    }
}
