package Services;

import Objects.*;

import java.util.HashMap;
import java.util.UUID;

public final class CartService extends Service {

    public static void addToCart(Product product, int quantity) {
        Main.getCurrentUser().getCart().addProduct(product, quantity);
        if (Main.isSignedIn()) {
            database.addToCart(Main.getCurrentUser().getId(), product.getId());
        }
    }

    //Should get products from database by their userid
    public static HashMap<Product, Integer> getCart() {
        HashMap<UUID, Integer> products = new HashMap<>();
        for (UUID productId : database.getCart(Main.getCurrentUser().getId())) {
            //database should have quantity
            products.put(productId, products.getOrDefault(productId, 0) + 1);
        }
        return null;
    }
}
