package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page {
    static MyFrame mainFrame;
    protected JPanel mainPanel = new JPanel();

    protected JPanel toolBeltPanel = new JPanel();
    protected JPanel sidePanel = new JPanel();

    int panelWidth = MyFrame.width;
    int panelHeight = MyFrame.height;
    int sidePanelWidth = 300;
    int sidePanelHeight = panelHeight - 40;

    Page() {
        mainPanel.setLayout(new BorderLayout(0, 0));
    }

    protected void defaultBackground() {
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setBounds(0, 0, panelWidth, panelHeight);

        sidePanel.setLayout(new BorderLayout(0, 0));
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

        ImageIcon icon = new ImageIcon("src/Resources/download.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        cartButton.setPreferredSize(new Dimension(40, 40));
        cartButton.setMargin(new Insets(0, 0, 0, 0));
        cartButton.add(new JLabel(scaledIcon));

        switchToPageWhenPressed(cartButton, "CartPage");

        toolBeltPanel.add(cartButton, BorderLayout.EAST);
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

    protected static void switchToPageWhenPressed(JButton button, String pageName) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPage(pageName);
            }
        });
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
