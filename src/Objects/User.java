package Objects;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    public enum Role {
        ADMIN, MANAGER, CUSTOMER
    }

    private final UUID iD;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
    private final ArrayList<UUID> addresses = new ArrayList<>();
    private final Cart cart;
    private final ArrayList<UUID> managedStores = new ArrayList<>();

    public User(UUID iD, String firstName, String lastName, String phoneNumber, String email, String password, Role role) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.cart = new Cart(iD);
    }


    // Update methods
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

    public void changeRole(Role role) {
        this.role = role;
    }

    // Address management
    public void addAddress(UUID iD, String country, String city, String postalCode, String additionalInfo) {
        addresses.add(iD);
    }

    public void removeAddress(UUID addressId) {
        addresses.remove(addressId);
    }

    // Cart management
    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    // Managed store management
    public void addManagedStore(Store store) {
        managedStores.add(store.getId());
    }

    public void removeManagedStore(Store store) {
        managedStores.remove(store.getId());
    }

    // Role checks
    public boolean isAdmin() {
        return role == Role.ADMIN;
    }

    public boolean isManager() {
        return role == Role.MANAGER;
    }

    // Getters
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

    public ArrayList<UUID> getAddresses() {
        return addresses;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<UUID> getManagedStores() {
        return managedStores;
    }
}
