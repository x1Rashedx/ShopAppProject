package Objects;

import java.util.ArrayList;
import java.util.UUID;

//add id to constructor later.
public class Store {
    private final UUID iD;
    private String name;
    private String description;
    private final ArrayList<UUID> managers = new ArrayList<>();
    private final ArrayList<Product> Products = new ArrayList<>();

    Store(String iD,String name, String description) {
        this.iD = UUID.fromString(iD);
        this.name = name;
        this.description = description;
    }

    Store(String name, String description) {
        this.iD = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addManager(UUID manager) {
        this.managers.add(manager);
    }

    public void removeManager(UUID manager) {
        this.managers.remove(manager);
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public void addProduct(Product product) {
        Products.add(product);
    }

    public void removeProduct(Product product) {
        Products.remove(product);
    }


    public UUID getId() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public ArrayList<UUID> getManagers() {
        return managers;
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
