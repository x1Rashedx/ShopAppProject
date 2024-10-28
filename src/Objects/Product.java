package Objects;

public class Product {
    private int id;
    private String store;
    private String name;
    private String description;
    private double price;

    Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getStore() {
        return store;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}