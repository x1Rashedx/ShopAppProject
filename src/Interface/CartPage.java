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
    private JButton checkoutButton = new JButton("Checkout");
    private JButton backButton = new JButton("Back");
    private JPanel productsButtonsPanel = new JPanel();
    private JScrollPane productsScrollPane = new JScrollPane(productsButtonsPanel);
    private int productPanelHeight;

    CartPage() {
        initPage();
    }

    private void initPage() {
        setButton(checkoutButton, 750, 500, 200, 25);
        setButton(backButton, 750, 550, 200, 25);

        productsButtonsPanel.setBackground(Color.GRAY);

        productsScrollPane.setBounds(0, 40, 700, 660);
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
        productPanelHeight = 230;

        for (Product product : Main.currentUser.getCart()) {
            productPanelHeight += 230;
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
