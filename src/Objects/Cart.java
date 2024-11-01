package Objects;

import java.util.ArrayList;

public class Cart {
    private double totalPrice = 0;
    private int numberOfProducts = 0;
    private final ArrayList<Product> Products = new ArrayList<>();

    public void addProduct(Product product) {
        Products.add(product);
        numberOfProducts++;
        totalPrice = totalPrice + product.getPrice();
    }

    public void removeProduct(Product product) {
        Products.remove(product);
        numberOfProducts--;
        totalPrice = totalPrice - product.getPrice();
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
