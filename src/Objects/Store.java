package Objects;

import java.util.ArrayList;

public class Store {
    private String name;
    private String description;
    private String manager;
    private ArrayList<Product> Products = new ArrayList<Product>();

    Store(String name, String description, String manager) {
        this.name = name;
        this.description = description;
        this.manager = manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addProduct(String name, String description, double price) {
        Products.add(new Product(name, description, price));
    }


    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Product> getProducts() {
        return Products;
    }

    public int getNumberOfProducts() {
        return Products.size();
    }
}
