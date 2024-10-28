package Objects;

import Interface.ProductPage;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String password;
    private String privileges;
    private ArrayList<Product> cart = new ArrayList<Product>();

    User(String name, String password, String privileges) {
        this.name = name;
        this.password = password;
        this.privileges = privileges;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPrivileges() {
        return privileges;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }
}
