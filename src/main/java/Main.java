

import db.DatabaseController;
import db.OeuvreDatabaseModel;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

       /* DatabaseController connection = DatabaseController.getInstance();
        connection.connect();
        connection.read();*/

        try {
            OeuvreDatabaseModel e = new OeuvreDatabaseModel();
            e.onInsertDefaultValues();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        }
    }

}

