package Objects;

import java.util.ArrayList;
import java.util.UUID;

//add id to constructor later.
public class Store {
    private final UUID iD;
    private String name;
    private String description;
    private final ArrayList<UUID> managers = new ArrayList<>();
    private final ArrayList<UUID> Products = new ArrayList<>();

    public Store(UUID iD, String name, String description) {
        this.iD = iD;
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
        Products.add(product.getId());
    }

    public void removeProduct(Product product) {
        Products.remove(product.getId());
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

    public ArrayList<UUID> getProducts() {
        return Products;
    }

    public int getNumberOfProducts() {
        return Products.size();
    }
}
