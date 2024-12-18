package GUI;

import javax.swing.*;

public class StartPage extends Page {

    private final JButton LoginButton = new JButton("Login");
    private final JButton RegisterButton = new JButton("Register");
    private final JButton GuestButton = new JButton("Continue as guest");

    StartPage() {
        initPage();
    }

    @Override
    protected void initPage() {
        defaultBackground();
        actionListener();

        setButton(LoginButton, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 2) - 150, 200, 25);
        setButton(RegisterButton, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 2) - 100, 200, 25);
        setButton(GuestButton, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 2) - 50, 200, 25);
    }

    @Override
    protected void actionListener() {
        switchToPageWhenPressed(LoginButton, "LoginPage");
        switchToPageWhenPressed(RegisterButton, "RegisterPage");
        switchToPageWhenPressed(GuestButton, "StoresPage");
    }
}
