package data_siswa.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Model{

    private String table = "";

    protected String dbUrl = "";
    protected String username = "";
    protected String password = "";

    protected ResultSet data;

    public Model(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./mysql.properties"));
            this.dbUrl = properties.getProperty("mysql.dburl");
            this.username = properties.getProperty("mysql.username");
            this.password = properties.getProperty("mysql.password");
            System.out.println(this.dbUrl);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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