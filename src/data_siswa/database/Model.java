package data_siswa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Model{

    private String table = "";

    protected String dbUrl = "jdbc:mysql://localhost:3306/db_siswa";
    protected String username = "root";
    protected String password = "";

    protected ResultSet data;

    protected Connection getConnection(){
       
        String unicode="useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
        try{
            Connection conn = DriverManager.getConnection(dbUrl + "?" + unicode, username, password);
            return conn;
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return null;
    }

    abstract public Collection<? extends Model> getAll();

    abstract public <T extends Model> T get(int id);    
    
    abstract public <T extends Model> T where(String column, String value);

    abstract public Collection<? extends Model> sql(String sql);

    abstract public boolean save();

    abstract public boolean delete();

    abstract public <T extends Model> T convert(ResultSet result);


}