package data_siswa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Model{

    private static String table = "tb_siswa";

    protected static String dbUrl = "jdbc:mysql://localhost:3306/db_siswa";
    protected static String username = "root";
    protected static String password = "";

    private static Connection getConnection(){
       
        String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
        try{
            Connection conn = DriverManager.getConnection(dbUrl + "?" + unicode, username, password);
            return conn;
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet get(){
        ResultSet result = null;
        try {
            java.sql.Statement statement = getConnection().createStatement();
            result = statement.executeQuery("select * from " + table);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}