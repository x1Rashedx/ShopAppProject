package Objects;

import javax.swing.*;
import java.util.ArrayList;
import java.util.UUID;

public class Product {
    private final UUID iD;
    private final String storeName;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private ImageIcon imageIcon;
    private final ArrayList<ImageIcon> images = new ArrayList<>();

    Product(String iD, String storeName, String name, String description, double price, int quantity, ImageIcon imageIcon) {
        this.iD = UUID.fromString(iD);
        this.name = name;
        this.storeName = storeName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageIcon = imageIcon;
    }

    Product(String name, String storeName, String description, double price, int quantity, ImageIcon imageIcon) {
        this.iD = UUID.randomUUID();
        this.name = name;
        this.storeName = storeName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageIcon = imageIcon;
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

    public void changeImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }


    public UUID getId() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getStoreName() {
        return storeName;
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

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}