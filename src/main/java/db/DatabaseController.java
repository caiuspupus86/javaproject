package db;

import java.sql.*;

public class DatabaseController {

    private static DatabaseController DATABASE = new DatabaseController();

    public static DatabaseController getInstance() {
        return DATABASE;
    }

    private DatabaseController() {
    }

    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:library.db";
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void read(){
        String sql = "SELECT * FROM Oeuvre WHERE idCategory=1";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("titleOeuvre") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
