package Objects;

public class Admin extends User {

    public Admin(String iD, String firstName, String lastName, String phoneNumber, String password) {
        super(iD, firstName, lastName, phoneNumber, password);
    }

    // Constructor that generates a new UUID
    public Admin(String firstName, String lastName, String phoneNumber, String password) {
        super(firstName, lastName, phoneNumber, password);
    }

    public void removeStore(Store store) {

    }

    public void removeUser(User user) {

    }
}
