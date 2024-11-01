package Interface;

import Objects.Main;
import Objects.Product;
import Objects.Store;
import Utils.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class StoresPage extends Page {
    private final JPanel storesButtonsPanel = new JPanel();
    private final JPanel productsButtonsPanel = new JPanel();
    private final JScrollPane productsScrollPane = new JScrollPane(productsButtonsPanel);
    private final JScrollPane storesScrollPane = new JScrollPane(storesButtonsPanel);
    private final JPanel searchPanel = new JPanel();
    private final JTextField searchField = new JTextField(20);
    private final JButton searchButton = new JButton("Search");

    private final Color buttonColor = Color.DARK_GRAY;

    public StoresPage() {
        initPage();
    }

    private void initPage() {
        defaultBackground();
        sidePanel.setLayout(new BorderLayout(0, 0));
        setupStoresPanel();
        setupProductsPanel();
        setupSearchBarPanel();
    }

    private void setupStoresPanel() {
        storesButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        storesButtonsPanel.setBackground(Color.DARK_GRAY);
        //storesScrollPane.setBounds(0, 0, sidePanelWidth, sidePanelHeight);
        storesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        storesScrollPane.setBackground(Color.DARK_GRAY);
        sidePanel.add(storesScrollPane, BorderLayout.CENTER);
        updateStoresPanel("");
    }

    private void setupProductsPanel() {
        productsButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 6));
        productsButtonsPanel.setBackground(Color.GRAY);
        //productsScrollPane.setBounds(0, 90, panelWidth - sidePanelWidth, panelHeight - 90);
        productsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        productsScrollPane.setBackground(Color.GRAY);
        mainPanel.add(productsScrollPane);
    }

    private void setupSearchBarPanel() {
        searchField.setText("Search for stores...");
        searchField.setPreferredSize(new Dimension(400, 30));
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search for stores...")) {
                    searchField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Search for stores...");
                }
            }
        });
        searchButton.addActionListener(e -> {
            String searchTerm = searchField.getText().toLowerCase();
            if (searchTerm.equals("search for stores...")) {
                searchTerm = "";
            }
            updateStoresPanel(searchTerm);
        });
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        toolBeltPanel.add(searchPanel, BorderLayout.CENTER);
    }

    private void updateStoresPanel(String searchTerm) {
        storesButtonsPanel.removeAll();
        int storesPanelHeight = 65;
        for (Store store : Main.Stores) {
            if (store.getName().toLowerCase().contains(searchTerm)) {
                storesPanelHeight += 65;
                JButton storeButton = getStoreButton(store);
                storesButtonsPanel.add(storeButton);
            }
        }
        storesButtonsPanel.setPreferredSize(new Dimension(0, storesPanelHeight));
        storesButtonsPanel.revalidate();
        storesButtonsPanel.repaint();
    }

    //Buttons for Stores:

    private JButton getStoreButton(Store store) {
        JButton storeButton = new JButton();
        storeButton.setPreferredSize(new Dimension(250, 60));
        storeButton.setLayout(new BorderLayout());
        storeButton.setMargin(new Insets(0, 0, 0, 0));

        JLabel imageLabel = new JLabel(Images.getImage("download", 60, 60));
        JPanel textPanel = getStoreButtonPanel(store);

        storeButton.add(imageLabel, BorderLayout.WEST);
        storeButton.add(textPanel, BorderLayout.CENTER);

        storeButton.addActionListener(e -> {
            System.out.println("Store selected: " + store.getName());
            updateProductsPanel(store);
        });

        return storeButton;
    }

    private JPanel getStoreButtonPanel(Store store) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(buttonColor);
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
    private void updateProductsPanel(Store store) {
        productsButtonsPanel.removeAll();
        int productPanelHeight = 230;

        for (Product product : store.getProducts()) {
            productPanelHeight += 230 / ((panelWidth - sidePanelWidth) / 171);
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

        JLabel imageLabel = new JLabel(Images.getImage("download", 165, 165));
        JPanel textPanel = getProductButtonPanel(product);

        productButton.add(imageLabel, BorderLayout.NORTH);
        productButton.add(textPanel, BorderLayout.CENTER);

        productButton.addActionListener(e -> {
            System.out.println("Product selected: " + product.getName());
            Main.currentUser.addToCart(product);
        });

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

}