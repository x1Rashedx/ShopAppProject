package Interface;

import Objects.Main;
import Objects.Product;
import Objects.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoresPage extends Page {
    private final JPanel storesButtonsPanel = new JPanel();
    private final JPanel productsButtonsPanel = new JPanel();
    private final JScrollPane productsScrollPane = new JScrollPane(productsButtonsPanel);
    private final JScrollPane storesScrollPane = new JScrollPane(storesButtonsPanel);

    public StoresPage() {
        initPage();
    }

    private void initPage() {

        storesButtonsPanel.setLayout(new GridLayout(0, 1, 2, 0));

        productsButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 6));
        productsButtonsPanel.setBackground(Color.GRAY);

        for (Store store : Main.Stores) {
            JButton storeButton = getStoreButton(store);
            storesButtonsPanel.add(storeButton);
        }

        storesScrollPane.setBounds(700, 40, 290, 625);
        storesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        productsScrollPane.setBounds(0, 90, 700, 575);
        productsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        productsScrollPane.setBackground(Color.GRAY);

        mainPanel.add(storesScrollPane);
        mainPanel.add(productsScrollPane);
        defaultBackground();
    }

    //Buttons for Stores:

    private JButton getStoreButton(Store store) {
        JButton storeButton = new JButton();
        storeButton.setPreferredSize(new Dimension(250, 60));
        storeButton.setLayout(new BorderLayout());
        storeButton.setMargin(new Insets(0, 0, 0, 0));

        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Store selected: " + store.getName());
                getStoreProductsPanel(store);
            }
        });

        ImageIcon icon = new ImageIcon("src/Resources/download.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel imageLabel = new JLabel(scaledIcon);
        storeButton.add(imageLabel, BorderLayout.WEST);

        JPanel textPanel = getStoreButtonPanel(store);

        storeButton.add(textPanel, BorderLayout.CENTER);

        return storeButton;
    }

    private JPanel getStoreButtonPanel(Store store) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel nameLabel = new JLabel(store.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel descriptionLabel = new JLabel("<html><i>" + store.getDescription() + "</i></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        textPanel.add(nameLabel, BorderLayout.NORTH);
        textPanel.add(descriptionLabel, BorderLayout.CENTER);
        return textPanel;
    }

    //Panel that displays products when clicking on a store:

    private void getStoreProductsPanel(Store store) {
        productsButtonsPanel.removeAll();
        int productPanelHeight = 240;

        for (Product product : store.getProducts()) {
            productPanelHeight += 58;
            JButton productButton = getProductButton(product);
            productsButtonsPanel.add(productButton);
        }

        productsButtonsPanel.setPreferredSize(new Dimension(0, productPanelHeight));
        productsButtonsPanel.revalidate();
        productsButtonsPanel.repaint();
    }

    //Buttons for Products

    private JButton getProductButton(Product product) {
        JButton productButton = new JButton();
        productButton.setPreferredSize(new Dimension(165, 230));
        productButton.setLayout(new BorderLayout());
        productButton.setMargin(new Insets(0, 0, 0, 0));

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Product selected: " + product.getName());
                Main.currentUser.addToCart(product);
            }
        });

        ImageIcon icon = new ImageIcon("src/Resources/download.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(165, 165, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel imageLabel = new JLabel(scaledIcon);
        productButton.add(imageLabel, BorderLayout.NORTH);

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

}