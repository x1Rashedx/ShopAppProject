package Objects;

import Interface.MyFrame;

import java.util.ArrayList;
import java.util.UUID;
import com.formdev.flatlaf.FlatDarkLaf;


public class Main {
    private static boolean isSignedIn = false;
    private static User currentUser = new User(UUID.randomUUID(),"", "", "", "", User.Role.ADMIN);

    public static void setCurrentUser(User user) {
        currentUser = user;
        isSignedIn = (user != null);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isSignedIn() {
        return isSignedIn;
    }

    /*
    public static void addStore(String name, String description) {
        Stores.add(new Store(UUID.randomUUID(), name, description));
    }


    public static void addStores() {
        addStore("Gigabyte", "this is a description");
        addStore("Zara", "");
        addStore("Nike", "");
        addStore("Adidas", "this is a description");
        addStore("Samsung", "");
        addStore("Apple", "");
        addStore("GAP", "");
        addStore("H&M", "this is a description");
        addStore("Fifine", "");
        addStore("Ikea", "");
        addStore("", "");
        addStore("hello", "");
        addStore("hello", "");
        addStore("hello", "");
        addStore("hello", "");
        int j = 0;
        for (Store store : Stores) {
            for (int i = 1; i <= 15; i++) {
                store.addProduct(new Product("Product name" + (i + j), "", "this is a description", 10, 5, new ImageIcon("src/Resources/download.png")));
            }
            j += 15;
        }
    }
     */

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        new MyFrame();
    }
}
