package Objects;

import java.util.ArrayList;

public class User {
    private int iD;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private final ArrayList<Address> addresses = new ArrayList<Address>();
    private final Cart cart = new Cart();

    User(String name, String password, String privileges) {
        this.name = name;
        this.password = password;
    }

    public void setId(int iD) {
        this.iD = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }


    public int getId() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public String getEmail() {
        return email;
    }
}
