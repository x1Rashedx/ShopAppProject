package Interface;

import javax.swing.*;

public class StartPage extends Page {

    private final JButton LoginButton = new JButton("Login");
    private final JButton RegisterButton = new JButton("Register");
    private final JButton GuestButton = new JButton("Continue as guest");

    public StartPage() {
        initPage();
    }

    public void initPage() {

        setButton(LoginButton, 750, 200, 200, 25);
        setButton(RegisterButton, 750, 250, 200, 25);
        setButton(GuestButton, 750, 300, 200, 25);

        actionListener();
        defaultBackground();
    }

    public void actionListener() {
        switchToPageWhenPressed(LoginButton, "LoginPage");
        switchToPageWhenPressed(RegisterButton, "RegisterPage");
        switchToPageWhenPressed(GuestButton, "StoresPage");
    }
}
