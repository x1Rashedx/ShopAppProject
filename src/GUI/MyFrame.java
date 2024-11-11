package GUI;

import Objects.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public final class MyFrame {
    private static final JFrame frame = new JFrame("ShopSphere");
    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel mainPanel = new JPanel(cardLayout);
    private static final Stack<String> history = new Stack<>();

    private static final int width = 1200;
    private static final int height = 800;

    public MyFrame() {
        initFrame();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(1000, 700));

        loadPanels();
        switchToPage("StartPage");

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void loadPanels() {
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.add(new StartPage(), "StartPage");
        mainPanel.add(new LoginPage(), "LoginPage");
        mainPanel.add(new StoresPage(), "StoresPage");
        mainPanel.add(new CartPage(), "CartPage");
        mainPanel.add(new AccountPage(), "AccountPage");
        mainPanel.add(new AdminPage(), "AdminPage");
        mainPanel.add(new RegisterPage(), "RegisterPage");
    }

    static void switchToPage(String pageName) {
        if (pageName.equals("CheckoutPage") && !Main.isSignedIn()) {pageName = "LoginPage";}
        if (pageName.equals("AccountPage") && !Main.isSignedIn()) {pageName = "LoginPage";}
        if (pageName.equals("PreviousPage")) {history.pop(); pageName = history.pop();}
        cardLayout.show(mainPanel, pageName);
        history.push(pageName);
    }
}