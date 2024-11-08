package Interface;

import javax.swing.*;

public class LoginPage extends Page {

    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Back");
    JLabel emailLabel = new JLabel("Email:");
    JLabel passLabel = new JLabel("Password:");
    JTextField emailField = new JTextField("");
    JPasswordField passwordField = new JPasswordField("");


    LoginPage() {
        initPage();
    }

    @Override
    protected void initPage() {
        defaultBackground();
        actionListener();

        setButton(loginButton, sidePanel,(sidePanelWidth / 2) - 100, sidePanelHeight - 250, 200, 25);
        setButton(backButton, sidePanel, (sidePanelWidth / 2) - 100, sidePanelHeight - 200, 200, 25);

        setLabel(emailLabel, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 75, 200, 25);
        setLabel(passLabel, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 25, 200, 25);

        setTextField(emailField, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 50, 200, 25);
        setTextField(passwordField, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3), 200, 25);
    }

    @Override
    public void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
    }
}
