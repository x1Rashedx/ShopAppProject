package Objects;

public class Manager extends User {

    public Manager(String iD, String firstName, String lastName, String phoneNumber, String password) {
        super(iD, firstName, lastName, phoneNumber, password);
    }

    // Constructor that generates a new UUID
    public Manager(String firstName, String lastName, String phoneNumber, String password) {
        super(firstName, lastName, phoneNumber, password);
    }
}
