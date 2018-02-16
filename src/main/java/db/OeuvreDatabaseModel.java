package db;

import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import static db.Category.FILMS;

public class OeuvreDatabaseModel extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public OeuvreDatabaseModel() throws SQLException,
            ClassNotFoundException, NoSuchFieldException {
        super((Object[])null);
    }

    @Override
    protected DatabaseDriverInterface<ResultSet,HashMap<String,Object>> onInitializeDatabaseDriverInterface(Object... args) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {};
    }

    @Override
    public void onRegisterObjectModels(HashMap<Type, ObjectModel<?,ResultSet,HashMap<String,Object>>> objectModels) throws ClassNotFoundException, NoSuchFieldException {
        /*
         * Tables Managed By This Model
         */
        // Register the ObjectModel for the Oeuvre class with the DatabaseModel
        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {});
        objectModels.put(Oeuvre.class, new JdbcObjectModel<Oeuvre>(this) {});

    }

    @Override

    public String getDatabaseName() {
        return "library.db";
    }

    @Override
    public int getDatabaseVersion() {
        return 1;
    }

    @Override
    public void onInsertDefaultValues() {

        Oeuvre film = new Oeuvre();
        film.setTitleOeuvre("Pulp Fiction");
        film.setCategory(FILMS);
        film.setEditionDate("1993");

        try {
            getObjectModel(Oeuvre.class).insert(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }







}
