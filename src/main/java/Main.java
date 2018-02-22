import db.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        try {
            OeuvreDatabaseModel oeuvres = new OeuvreDatabaseModel();
            List<Oeuvre> list = oeuvres.getObjectModel(Oeuvre.class).getAll();

            for (Oeuvre oeuvre: list) {
                System.out.println(oeuvre.getIdCategory());
                System.out.println(oeuvre.getCategory().getName());
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
    }
}
