package Services;

import Objects.*;
import Database.*;

public final class CartService extends Service {
    private static DBConnector DBConnection;

    CartService(DBConnector conn) {
        this.DBConnection = conn;
    }

    public void addToCart(User currentUser, Product product) {
        currentUser.addToCart(product);
        if (Main.signedIn) {

        }
    }
}
