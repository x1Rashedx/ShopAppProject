package Interface;

import Services.UsersService;

import javax.swing.*;

public class RegisterPage extends Page {
    UsersService registrationService = new UsersService();

    private final JButton registerButton = new JButton("Register");
    private final JButton backButton = new JButton("Back");
    private final JTextField firstNameField = new JTextField();
    private final JTextField lastNameField = new JTextField();
    private final JTextField phoneNumberField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JTextField passwordField = new JTextField();
    private final JTextField confirmPasswordField = new JTextField();
    private final JLabel firstNameLabel = new JLabel("First Name:*");
    private final JLabel lastNameLabel = new JLabel("Last Name:*");
    private final JLabel phoneNumberLabel = new JLabel("Phone Number:*");
    private final JLabel emailLabel = new JLabel("(optional) Email Address:");
    private final JLabel passwordLabel = new JLabel("Password:*");
    private final JLabel confirmPasswordLabel = new JLabel("Confirm Password:*");
    private final JLabel warningLabel = new JLabel("", JLabel.CENTER);
    private final JLabel titleLabel = new JLabel();

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\+?\\d{10,15}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";


    RegisterPage() {
        initPage();
    }

    @Override
    protected void initPage() {
        defaultBackground();
        actionListener();

        setButton(registerButton, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) + 300, 250, 25);
        setButton(backButton, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) + 350, 250, 25);

        setTextField(firstNameField, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 150, 110, 25);
        setTextField(lastNameField, sidePanel, (sidePanelWidth / 2) + 15, (sidePanelHeight / 2) - 150, 110, 25);
        setTextField(phoneNumberField, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 100, 110, 25);
        setTextField(emailField, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 50, 250, 25);
        setTextField(passwordField, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) + 10, 250, 25);
        setTextField(confirmPasswordField, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) + 60, 250, 25);
        setLabel(firstNameLabel, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 175, 110, 25);
        setLabel(lastNameLabel, sidePanel, (sidePanelWidth / 2) + 15, (sidePanelHeight / 2) - 175, 110, 25);
        setLabel(phoneNumberLabel, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 125, 100, 25);
        setLabel(emailLabel, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 75, 250, 25);
        setLabel(passwordLabel, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) - 15, 250, 25);
        setLabel(confirmPasswordLabel, sidePanel, (sidePanelWidth / 2) - 125, (sidePanelHeight / 2) + 35, 250, 25);
        setLabel(warningLabel, sidePanel, (sidePanelWidth / 2) - 100, (sidePanelHeight / 2) + 225, 200, 25);
    }

    @Override
    protected void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
        registerButton.addActionListener(e -> getInput());
    }

    private void getInput() {
        int response;
        if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || phoneNumberField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            updateWarningLabel("Fill mandatory fields.");
        } else if (!phoneNumberField.getText().matches(PHONE_REGEX)) {
            updateWarningLabel("Enter a valid phone number.");
        } else if (!emailField.getText().isEmpty() && !emailField.getText().matches(EMAIL_REGEX)) {
            updateWarningLabel("Enter a valid email address.");
        } else if (!passwordField.getText().matches(PASSWORD_REGEX)){
            updateWarningLabel("Enter a valid password.");
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            updateWarningLabel("Password not the same.");
        } else {
            response = registrationService.Register(firstNameField.getText(), lastNameField.getText(), phoneNumberField.getText(), emailField.getText(), passwordField.getText());
            if (response == -1) {
                updateWarningLabel("Phone number already in use.");
            } else if (response == 1) {
                updateWarningLabel("email already in use.");
            } else {
                updateWarningLabel("");
            }
        }
    }

    public void updateWarningLabel(String warning) {
        warningLabel.setText(warning);
        warningLabel.revalidate();
        warningLabel.repaint();
    }

}
