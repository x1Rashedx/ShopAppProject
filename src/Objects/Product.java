package Objects;

import javax.swing.*;
import java.util.ArrayList;
import java.util.UUID;

public class Product {
    private final UUID iD;
    private final UUID storeId;  // Links product to a specific store
    private String name;
    private String description;
    private double price;
    private int quantity;
    private ImageIcon mainImageIcon;
    private final ArrayList<ImageIcon> images = new ArrayList<>();

    public Product(UUID iD, UUID storeId, String name, String description, double price, int quantity, ImageIcon mainImageIcon) {
        this.iD = iD;
        this.storeId = storeId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.mainImageIcon = mainImageIcon;
    }

    public void changesetName(String name) {
        this.name = name;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void changePrice(double price) {
        this.price = price;
    }

    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void changeMainImageIcon(ImageIcon mainImageIcon) {
        this.mainImageIcon = mainImageIcon;
    }


    public UUID getId() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public UUID getStoreId() {
        return storeId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ImageIcon getMainImageIcon() {
        return mainImageIcon;
    }
}