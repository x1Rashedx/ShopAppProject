package Interface;

import Objects.Main;
import Objects.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class CartPage extends Page {
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton backButton = new JButton("Back");
    private final JPanel productsButtonsPanel = new JPanel();
    private final JScrollPane productsScrollPane = new JScrollPane(productsButtonsPanel);

    private final Color buttonColor = Color.DARK_GRAY;

    CartPage() {
        initPage();
    }

    private void initPage() {
        setButton(checkoutButton, sidePanel, (sidePanelWidth / 2) - 100, sidePanelHeight - 250, 200, 25);
        setButton(backButton, sidePanel,(sidePanelWidth / 2) - 100, sidePanelHeight - 200, 200, 25);

        productsButtonsPanel.setBackground(Color.GRAY);

        productsScrollPane.setBounds(0, 40, panelWidth - sidePanelWidth, panelHeight - 40);
        productsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        productsScrollPane.setBackground(Color.GRAY);

        mainPanel.addComponentListener(new ComponentListener() {
            @Override
            public void componentShown(ComponentEvent e) {
                updateCartProductsPanel();
            }
            @Override
            public void componentResized(ComponentEvent e) {}
            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
        });

        mainPanel.add(productsScrollPane);

        actionListener();
        defaultBackground();
    }

    private void updateCartProductsPanel() {
        productsButtonsPanel.removeAll();
        int productPanelHeight = 20;

        for (Product product : Main.currentUser.getCart()) {
            productPanelHeight += 205;
            JButton productButton = getProductButton(product);
            productsButtonsPanel.add(productButton);
        }

        productsButtonsPanel.setPreferredSize(new Dimension(0, productPanelHeight));
        productsButtonsPanel.revalidate();
        productsButtonsPanel.repaint();
    }

    private JButton getProductButton(Product product) {
        JButton productButton = new JButton();
        productButton.setPreferredSize(new Dimension(630, 200));
        productButton.setLayout(new BorderLayout());
        productButton.setMargin(new Insets(0, 0, 0, 0));

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Product selected: " + product.getName());
            }
        });

        ImageIcon icon = new ImageIcon("src/Resources/download.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel imageLabel = new JLabel(scaledIcon);
        productButton.add(imageLabel, BorderLayout.WEST);

        JPanel textPanel = getProductButtonPanel(product);

        productButton.add(textPanel, BorderLayout.CENTER);

        return productButton;
    }

    private JPanel getProductButtonPanel(Product product) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(buttonColor);
        textPanel.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 3));

        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel descriptionLabel = new JLabel("<html><i>" + product.getDescription() + "</i></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel priceLabel = new JLabel("$" + product.getPrice());
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        priceLabel.setForeground(Color.GREEN);

        textPanel.add(nameLabel, BorderLayout.NORTH);
        textPanel.add(descriptionLabel, BorderLayout.CENTER);
        textPanel.add(priceLabel, BorderLayout.SOUTH);
        return textPanel;
    }

    private void actionListener() {
        switchToPageWhenPressed(checkoutButton, "CheckoutPage");
        switchToPageWhenPressed(backButton, "PreviousPage");
    }
}
