package Services;

import Objects.Main;
import Objects.User;

import java.util.UUID;

public final class UsersService extends Service {

    public static int Register(String firstName, String lastName, String phoneNumber, String email, String password) {
        UUID iD = UUID.randomUUID();

        int response = database.addUser(iD, firstName, lastName, phoneNumber, email, password);

        if (response == 0) {
            Main.setCurrentUser(new User(iD, firstName, lastName, phoneNumber, email, password, User.Role.CUSTOMER));
        }

        return response;
    }

    public static boolean login(String phoneNumberOrEmail, String password) {
        User user = database.login(phoneNumberOrEmail, password);
        if (user != null) {
            Main.setCurrentUser(user);
            return true;
        } else {
            return false;
        }
    }
}
