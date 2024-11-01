package Objects;

import Interface.MyFrame;

import java.util.ArrayList;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;


public class Main {
    public static boolean signedIn = false;
    public static User currentUser;
    public static ArrayList<Store> Stores = new ArrayList<>();

    public static void addStore(String name, String description) {
        Stores.add(new Store(name, description));
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

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        currentUser = new Admin("", "", "", "");
        addStores();
        new MyFrame();
    }
}
