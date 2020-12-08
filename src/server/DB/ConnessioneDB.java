package server.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneDB {
    private static ConnessioneDB instance = null;

    private Connection connection;

    private final String db_name = "rubrica";
    private final String db_user = "root";
    private final String db_password = "";
    private final String db_host = "localhost";

    public static ConnessioneDB getInstance(){
        instance = new ConnessioneDB();
        return instance;
    }

    private ConnessioneDB() {
        if(this.connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://"+db_host+":3306/"+db_name+"", db_user, db_password); //databse url, username e password
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
