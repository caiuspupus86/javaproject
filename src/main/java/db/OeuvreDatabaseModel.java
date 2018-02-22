package db;

import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


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

        objectModels.put(Support.class, new JdbcObjectModel<Support>(this) {});
        objectModels.put(Category.class, new JdbcObjectModel<Category>(this) {});
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

        Category[] categories = new Category[]{
                new Category("Films"),
                new Category("Musique"),
                new Category("Livres"),
                new Category("Jeux-Vidéo")
        };

        Support dvd = new Support();
        dvd.setNameSupport("DVD");
        Support cd = new Support();
        cd.setNameSupport("CD");

        Film film = new Film();
        film.setTitleOeuvre("Pulp Fiction");
        film.setEditionDate("1993");
        film.setIdSupport(1);

        Music musique = new Music();
        musique.setTitleOeuvre("Know your ennemy");
        musique.setEditionDate("1998");
        musique.setIdSupport(2);


        try {
            for (Category category : categories) {
                getObjectModel(Category.class).insert(category);
            }
            getObjectModel(Support.class).insert(dvd);
            getObjectModel(Support.class).insert(cd);
            getObjectModel(Oeuvre.class).insert(film);
            getObjectModel(Oeuvre.class).insert(musique);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
