package Services;

import Database.DBUtils;

public class Service {
    protected static DBUtils database;

    public Service() {
        initDatabase();
    }

    private void initDatabase() {
        database = new DBUtils();
    }
}
