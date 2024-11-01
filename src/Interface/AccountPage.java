package Interface;

import Objects.Admin;
import Objects.Main;
import Objects.Manager;

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

    private void initPage() {
        setButton(userInfoButton, sidePanel, 0, 0, sidePanelWidth, 100);
        setButton(ordersButton, sidePanel, 0, 100, sidePanelWidth, 100);
        setButton(addressesButton, sidePanel, 0, 200, sidePanelWidth, 100);
        setButton(settingsButton, sidePanel, 0, 300, sidePanelWidth, 100);
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
        defaultBackground();
        actionListener();

        toolBeltPanel.add(backButton, BorderLayout.WEST);
    }

    private void updateSpecialUserButton() {
        if (Main.currentUser instanceof Admin) {
            specialUserButton.setText("Admin settings");
            setButton(specialUserButton, sidePanel, 0, 400, sidePanelWidth, 100);
        } else if (Main.currentUser instanceof Manager) {
            specialUserButton.setText("Manager settings");
            setButton(specialUserButton, sidePanel, 0, 400, sidePanelWidth, 100);
        } else {
            specialUserButton.setText("");
            sidePanel.remove(specialUserButton);
        }
    }

    private void actionListener() {
        switchToPageWhenPressed(backButton, "PreviousPage");
    }
}
