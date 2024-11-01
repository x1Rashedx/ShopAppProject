package Interface;

import javax.swing.*;

public class LoginPage extends Page {

    JButton loginButton = new JButton("Login");
    JButton backButton = new JButton("Back");
    JLabel emailLabel = new JLabel("Email:");
    JLabel passLabel = new JLabel("Password:");
    JTextField emailField = new JTextField("");
    JPasswordField passField = new JPasswordField("");


    LoginPage() {
        initPage();
    }

    void initPage() {
        defaultBackground();
        actionListener();

        setButton(loginButton, sidePanel,(sidePanelWidth / 2) - 100, sidePanelHeight - 250, 200, 25);
        setButton(backButton, sidePanel, (sidePanelWidth / 2) - 100, sidePanelHeight - 200, 200, 25);

        setLabel(emailLabel, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 75, 200, 25);
        setLabel(passLabel, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 25, 200, 25);

        emailField.setBounds((sidePanelWidth / 2) - 100, (sidePanelHeight / 3) - 50, 200, 25);
        passField.setBounds((sidePanelWidth / 2) - 100, (sidePanelHeight / 3), 200, 25);

        sidePanel.add(emailField);
        sidePanel.add(passField);

    }

    public void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
    }
}
