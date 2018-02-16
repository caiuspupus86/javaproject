package db;


import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public abstract class CarDatabaseModel extends DatabaseModel<ResultSet, HashMap<String,Object>> {

    public CarDatabaseModel() throws SQLException,
            ClassNotFoundException, NoSuchFieldException {
        super((Object[]) null);
    }

    @Override
    protected DatabaseDriverInterface<ResultSet,HashMap<String,Object>> onInitializeDatabaseDriverInterface(Object... args) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }
}