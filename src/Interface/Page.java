package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page {
    static MyFrame mainFrame;

    protected JPanel mainPanel = new JPanel();
    protected JPanel drawingPanel = new JPanel();
    protected JPanel BackGroundPanel = new JPanel();
    protected JPanel ToolBeltPanel = new JPanel();

    private final JButton accountButton = new JButton();
    private final JButton cartButton = new JButton();

    Page() {
        mainPanel.setLayout(null);
    }

    protected void defaultBackground() {
        BackGroundPanel.setBackground(Color.GRAY);
        BackGroundPanel.setBounds(0, 0, 700, 700);

        ToolBeltPanel.setLayout(new BorderLayout());
        ToolBeltPanel.setBackground(Color.DARK_GRAY);
        ToolBeltPanel.setBounds(0, 0, 987, 40);

        drawingPanel.setLayout(null);
        drawingPanel.setBounds(0, 0, 1000, 700);

        toolBeltButtons();

        drawingPanel.add(ToolBeltPanel);
        drawingPanel.add(BackGroundPanel);

        mainPanel.add(drawingPanel);
    }

    private void toolBeltButtons() {
        ImageIcon icon = new ImageIcon("src/Resources/download.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        cartButton.setPreferredSize(new Dimension(40, 40));
        cartButton.setMargin(new Insets(0, 0, 0, 0));
        cartButton.add(new JLabel(scaledIcon));

        switchToPageWhenPressed(cartButton, "CartPage");

        ToolBeltPanel.add(cartButton, BorderLayout.EAST);
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    protected void setButton(JButton button, int x , int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setFocusable(false);
        mainPanel.add(button);
    }

    protected void setLabel(JLabel label, int x , int y, int width, int height) {
        label.setBounds(x, y, width, height);
        mainPanel.add(label);
    }

    protected static void switchToPageWhenPressed(JButton button, String pageName) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.switchToPage(pageName);
            }
        });
    }
}
