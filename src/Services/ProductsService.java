package Services;

import Objects.Product;

import java.util.ArrayList;
import java.util.UUID;

public final class ProductsService extends Service {

    public static ArrayList<Product> getProducts(UUID storeId) {
        return database.getProducts(storeId);
    }
}
