package Interface;

import Objects.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AccountPage extends Page {
    private final JButton userInfoButton = new JButton("User Information");
    private final JButton ordersButton = new JButton("Orders");
    private final JButton addressesButton = new JButton("Addresses");
    private final JButton settingsButton = new JButton("Settings");
    private final JButton backButton = new JButton("Back");
    private final JButton specialUserButton = new JButton();

    AccountPage() {
        initPage();
    }

    @Override
    protected void initPage() {
        defaultBackground();
        actionListener();

        setButton(userInfoButton, sidePanel, 0, 0, sidePanelWidth, 100);
        setButton(ordersButton, sidePanel, 0, 100, sidePanelWidth, 100);
        setButton(addressesButton, sidePanel, 0, 200, sidePanelWidth, 100);
        setButton(settingsButton, sidePanel, 0, 300, sidePanelWidth, 100);
        setButton(specialUserButton, sidePanel, 0, 400, sidePanelWidth, 100);
        toolBeltPanel.add(backButton, BorderLayout.WEST);
        mainPanel.addComponentListener(new ComponentListener() {
            @Override
            public void componentShown(ComponentEvent e) {
                updateSpecialUserButton();
            }
            @Override
            public void componentResized(ComponentEvent e) {}
            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });
    }

    @Override
    protected void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
        specialUserButton.addActionListener(e -> {
            if (Main.currentUser.isAdmin()) {
                MyFrame.switchToPage("AdminPage");
            } else if (Main.currentUser.isAdmin()) {
                MyFrame.switchToPage("ManagerPage");
            }
        });
    }

    private void updateSpecialUserButton() {
        if (Main.currentUser.isAdmin()) {
            specialUserButton.setText("Admin settings");
            specialUserButton.setVisible(true);
        } else if (Main.currentUser.isManager()) {
            specialUserButton.setText("Manager settings");
            specialUserButton.setVisible(true);
        } else {
            specialUserButton.setText("");
            specialUserButton.setVisible(false);
        }
    }
}
