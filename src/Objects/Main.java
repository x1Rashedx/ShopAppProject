package Objects;

import Interface.*;
import java.util.ArrayList;
import com.formdev.flatlaf.FlatDarkLaf;

public class Main {
    public static boolean signedIn = false;
    public static User currentUser;
    public static ArrayList<Store> Stores = new ArrayList<Store>();

    public static void addStore(String name, String description, String manager) {
        Stores.add(new Store(name, description, manager));
    }

    public static void addStores() {
        addStore("Gigabyte", "this is a description", "");
        addStore("Zara", "", "");
        addStore("Nike", "", "");
        addStore("Adidas", "this is a description", "");
        addStore("Samsung", "", "");
        addStore("Apple", "", "");
        addStore("GAP", "", "");
        addStore("H&M", "this is a description", "");
        addStore("Fifine", "", "");
        addStore("Ikea", "", "");
        addStore("", "", "");
        addStore("hello", "", "");
        addStore("hello", "", "");
        addStore("hello", "", "");
        addStore("hello", "", "");
        int j = 0;
        for (Store store : Stores) {
            for (int i = 1; i <= 15; i++) {
                store.addProduct("Product name" + (i + j), "this is a description", 10);
            }
            j += 15;
        }
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        currentUser = new User("", "", "");
        addStores();
        new MyFrame();
    }
}
