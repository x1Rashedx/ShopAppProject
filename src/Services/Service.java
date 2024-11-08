package Services;

import Database.DBUtils;

public class Service {
    protected static DBUtils database;

    Service() {
        database = new DBUtils();
    }
}
