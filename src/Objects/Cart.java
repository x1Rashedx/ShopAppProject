package Objects;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cart {
    private final UUID userId;
    private double totalPrice = 0;
    private int numberOfProducts = 0;
    private final Map<UUID, Integer> products = new HashMap<>();

    public Cart(UUID userId) {
        this.userId = userId;
    }


    public void addProduct(Product product, int quantity) {
        UUID productId = product.getId();
        products.put(productId, products.getOrDefault(productId, 0) + quantity);
        totalPrice += product.getPrice();
        numberOfProducts++;
    }

    public void removeProduct(Product product) {
        UUID productId = product.getId();
        if (products.containsKey(productId)) {
            if (products.get(productId) <= 1) {
                totalPrice -= product.getPrice();
                products.remove(productId);
            } else {
                totalPrice -= product.getPrice();
                products.put(productId, products.get(productId) - 1);
            }
        }
        numberOfProducts--;
    }

    public Map<UUID, Integer> getProducts() {
        return products;
    }

    public UUID getUserId() {
        return userId;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
