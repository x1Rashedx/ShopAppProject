package Database;

import java.sql.*;
import java.util.UUID;

@SuppressWarnings("CallToPrintStackTrace")
public class DBUtils {
    private final Connection conn = DBConnector.getInstance().getConnection();

    public boolean login(String phoneNumberOrEmail, String password) {
        String query = "SELECT password FROM Users WHERE email = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, phoneNumberOrEmail);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // hash function should be here
                return password.equals(storedPassword);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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

    public void addProduct(UUID id, UUID storeId, String name, String description, double price, int quantity) {
        String query = "INSERT INTO Products (id, store_id, name, description, price, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id.toString());
            stmt.setString(2, storeId.toString());
            stmt.setString(3, name);
            stmt.setString(4, description);
            stmt.setDouble(5, price);
            stmt.setInt(6, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean retrieveUser(String uniqueIdentifier) {
        String query = "SELECT " + uniqueIdentifier + " FROM User";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void retrieveAddresses() {
        String query = "SELECT * FROM Address";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveStores() {
        String query = "SELECT * FROM Store";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveProducts() {
        String query = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
