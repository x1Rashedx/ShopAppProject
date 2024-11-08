package Interface;

import Database.DBConnector;
import Utils.Images;
import javax.swing.*;
import java.awt.*;

public abstract class Page {
    protected JPanel mainPanel = new JPanel();

    protected JPanel toolBeltPanel = new JPanel();
    protected JPanel sidePanel = new JPanel();

    protected int panelWidth = MyFrame.getWidth();
    protected int panelHeight = MyFrame.getHeight();
    protected int sidePanelWidth = 300;
    protected int sidePanelHeight = panelHeight - 40;

    Page() {
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBounds(0, 0, panelWidth, panelHeight);
    }

    protected abstract void initPage();
    protected abstract void actionListener();

    protected void defaultBackground() {
        mainPanel.setBackground(Color.GRAY);

        sidePanel.setLayout(null);
        sidePanel.setBackground(Color.DARK_GRAY);
        sidePanel.setPreferredSize(new Dimension(300, 0));
        //sidePanel.setBounds(panelWidth - 300, 40, sidePanelWidth, sidePanelHeight);

        toolBeltPanel.setLayout(new BorderLayout());
        toolBeltPanel.setBackground(Color.DARK_GRAY);
        toolBeltPanel.setPreferredSize(new Dimension(0, 40));
        toolBeltButtons();
        //toolBeltPanel.setBounds(0, 0, panelWidth, 40);

        mainPanel.add(toolBeltPanel, BorderLayout.NORTH);
        mainPanel.add(sidePanel, BorderLayout.EAST);
    }

    private void toolBeltButtons() {
        JButton accountButton = new JButton();
        JButton cartButton = new JButton();

        cartButton.setPreferredSize(new Dimension(40, 40));
        cartButton.setMargin(new Insets(0, 0, 0, 0));
        cartButton.add(new JLabel(Images.getImage("CartImg", 40, 40)));

        accountButton.setPreferredSize(new Dimension(40, 40));
        accountButton.setMargin(new Insets(0, 0, 0, 0));
        accountButton.add(new JLabel(Images.getImage("UserImg", 40, 40)));

        switchToPageWhenPressed(cartButton, "CartPage");
        switchToPageWhenPressed(accountButton, "AccountPage");

        toolBeltPanel.add(cartButton, BorderLayout.EAST);
        toolBeltPanel.add(accountButton, BorderLayout.WEST);
    }

    protected void setButton(JButton button, JPanel panel, int x , int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        panel.add(button);
    }

    protected void setLabel(JLabel label, JPanel panel, int x , int y, int width, int height) {
        label.setBounds(x, y, width, height);
        panel.add(label);
    }

    protected void setTextField(JTextField textField, JPanel panel, int x, int y, int width, int height) {
        textField.setBounds(x, y, width, height);
        panel.add(textField);
    }

    protected static void switchToPageWhenPressed(JButton button, String pageName) {
        button.addActionListener(e -> MyFrame.switchToPage(pageName));
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
