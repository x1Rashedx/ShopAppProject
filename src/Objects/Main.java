package Objects;

import Interface.MyFrame;
import java.util.UUID;

import Services.Service;
import Services.StoresService;
import com.formdev.flatlaf.FlatDarkLaf;


public class Main {
    private static boolean isSignedIn = false;
    private static User currentUser = new User(UUID.randomUUID(),"", "", "", "", "", User.Role.ADMIN);

    public static void setCurrentUser(User user) {
        currentUser = user;
        isSignedIn = (user != null);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isSignedIn() {
        return isSignedIn;
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        new Service();
        new MyFrame();
    }
}
