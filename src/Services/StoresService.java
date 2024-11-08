package Services;

import Objects.Store;
import java.util.ArrayList;

public final class StoresService extends Service {

    public static ArrayList<Store> getStores() {
        return database.getStores();
    }
}
