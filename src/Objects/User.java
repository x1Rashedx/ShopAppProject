package Objects;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private final UUID iD;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private final ArrayList<Address> addresses = new ArrayList<>();
    private final Cart cart = new Cart();

    User(String iD, String firstName, String lastName, String phoneNumber, String password) {
        this.iD = UUID.fromString(iD);
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    // Constructor that generates a new UUID
    User(String firstName, String lastName, String phoneNumber, String password) {
        this.iD = UUID.randomUUID();
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void addAddress(String country, String city, String postalCode, String additionalInfo) {
        String addressId = "";
        addresses.add(new Address(addressId, country, city, postalCode, additionalInfo));
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    public UUID getId() {
        return iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
