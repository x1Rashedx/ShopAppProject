package Database;

import Objects.*;
import Utils.Images;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

@SuppressWarnings("CallToPrintStackTrace")
public class DBUtils {
    private final Connection conn = DBConnector.getInstance().getConnection();

    public User login(String identifier, String password) {
        String query = "SELECT * FROM Users WHERE (email = ? OR phone_number = ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, identifier); // Matches email
            stmt.setString(2, identifier); // Matches phone number
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (password.equals(storedPassword)) {
                        UUID iD = UUID.fromString(rs.getString("id"));
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String phoneNumber = rs.getString("phone_number");
                        String email = rs.getString("email");
                        return new User(iD, firstName, lastName, phoneNumber, email, password, User.Role.ADMIN);
                    }
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addUser(UUID iD, String firstName, String lastName, String phoneNumber, String email, String password) {
        String query = "INSERT INTO Users (id, first_name, last_name, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, iD.toString());
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, email);
            stmt.setString(6, password);
            stmt.executeUpdate();
            return 0;
        } catch (SQLException e) {
            if (!(e.getErrorCode() == 1062)) {
                e.printStackTrace();
            } else if (e.getMessage().contains("phone_number")) {
                return -1;
            } else if (e.getMessage().contains("email")) {
                return 1;
            }
            e.printStackTrace();
            return 2;
        }
    }

    public void addToCart(UUID id, UUID userId) {
        String query = "INSERT INTO Cart (id, user_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.setString(2, userId.toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAddress(UUID id, UUID userId, String country, String city, String postalCode, String additionalInfo) {
        String query = "INSERT INTO Address (id, user_id, country, city, postal_code, additional_info) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.setString(2, userId.toString());
            stmt.setString(3, country);
            stmt.setString(4, city);
            stmt.setString(5, postalCode);
            stmt.setString(6, additionalInfo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStore(UUID id, String name, String description) {
        String query = "INSERT INTO Stores (id, name, description) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(UUID id, UUID storeId, String name, String description, double price, int quantity, byte[] image) {
        String query = "INSERT INTO Products (id, store_id, name, description, price, quantity, main_image_icon) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.setString(2, storeId.toString());
            stmt.setString(3, name);
            stmt.setString(4, description);
            stmt.setDouble(5, price);
            stmt.setInt(6, quantity);
            stmt.setBytes(7, image);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts(UUID storeId) {
        String query;
        ArrayList<Product> products = new ArrayList<>();

        // Check if storeId is provided
        if (storeId == null) {
            query = "SELECT * FROM Products";
        } else {
            query = "SELECT * FROM Products WHERE store_id = ?";
        }

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            if (storeId != null) {
                stmt.setString(1, storeId.toString());
            }

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    UUID iD = UUID.fromString(rs.getString("id"));
                    UUID pStoreId = UUID.fromString(rs.getString("id"));
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    byte[] image = rs.getBytes("main_image_icon");

                    Product product = new Product(iD, pStoreId, name, description, price, quantity, Images.byteArrayToImageIcon(image));
                    products.add(product);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public ArrayList<User> getUsers(User.Role role) {
        String query = "SELECT * FROM ?";
        ArrayList<User> users = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, role.name().toLowerCase() + "s");

            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    UUID iD = UUID.fromString(rs.getString("id"));
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String phoneNumber = rs.getString("phone_number");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    users.add(new User(iD, firstName, lastName, phoneNumber, email, password, role));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<Address> getAddresses(UUID userId) {
        String query = "SELECT * FROM Address WHERE user_id = ?";
        ArrayList<Address> addresses = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userId.toString());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    UUID iD = UUID.fromString(rs.getString("id"));
                    String country = rs.getString("name");
                    String city = rs.getString("description");
                    String postalCode = rs.getString("price");
                    String additionalInfo = rs.getString("quantity");

                    addresses.add(new Address(iD, country, city, postalCode, additionalInfo));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }


    public ArrayList<Store> getStores() {
        String query = "SELECT * FROM Stores";
        ArrayList<Store> stores = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                UUID iD = UUID.fromString(rs.getString("id"));
                String name = rs.getString("name");
                String description = rs.getString("description");
                stores.add(new Store(iD, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stores;
    }

    public ArrayList<UUID> getCart(UUID userId) {
        String query = "SELECT * FROM Cart WHERE user_id = ?";
        ArrayList<UUID> productId = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userId.toString());
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String iD = rs.getString("id");
                    productId.add(UUID.fromString(iD));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;
    }
}