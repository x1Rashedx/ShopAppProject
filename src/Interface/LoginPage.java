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

        setButton(loginButton, 750, 500, 200, 25);
        setButton(backButton, 750, 550, 200, 25);

        setLabel(emailLabel, 750, 175, 200, 25);
        setLabel(passLabel, 750, 225, 200, 25);

        emailField.setBounds(750, 200, 200, 25);
        passField.setBounds(750, 250, 200, 25);

        mainPanel.add(emailField);
        mainPanel.add(passField);

        actionListener();
        defaultBackground();
    }

    public void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
    }
}
