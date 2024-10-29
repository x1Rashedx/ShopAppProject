package Interface;

import Objects.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Stack;

public class MyFrame {
    private final JFrame frame = new JFrame("ShopSphere");
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final Stack<String> history = new Stack<String>();

    static final int width = 1200;
    static final int height = 800;

    public MyFrame() {
        initFrame();
    }

    private void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(1000, 700));
        mainPanel.setPreferredSize(new Dimension(width, height));

        loadPanels();
        switchToPage("StartPage");

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void loadPanels() {
        Page.mainFrame = this;
        mainPanel.add(new StartPage().getPanel(), "StartPage");
        mainPanel.add(new LoginPage().getPanel(), "LoginPage");
        mainPanel.add(new StoresPage().getPanel(), "StoresPage");
        mainPanel.add(new CartPage().getPanel(), "CartPage");
    }

    public void switchToPage(String pageName) {
        if (Objects.equals(pageName, "CheckoutPage") && !Main.signedIn) {pageName = "LoginPage";}
        if (Objects.equals(pageName, "PreviousPage")) {history.pop(); pageName = history.pop();}
        cardLayout.show(mainPanel, pageName);
        history.push(pageName);
    }
}