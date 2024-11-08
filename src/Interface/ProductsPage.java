package Interface;

import Objects.Product;

import javax.swing.*;

public class ProductsPage extends Page {
    private final JButton BackButton = new JButton();
    private final JButton searchButton = new JButton();

    private final JPanel productsButtonsPanel = new JPanel();
    private final JScrollPane productsScrollPane = new JScrollPane(productsButtonsPanel);

    private final JTextField searchField = new JTextField();

    ProductsPage() {
        initPage();
    }

    @Override
    protected void initPage() {

    }

    @Override
    protected void actionListener() {

    }

    private void setupSearchBarPanel() {

    }

    private void setupProductsPanel() {

    }

    private JButton getProductButton(Product product) {
        JButton button = new JButton();
        return button;
    }

    private JPanel getProductButtonPanel(Product product) {
        JPanel panel = new JPanel();
        return panel;
    }
}
