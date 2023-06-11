package data_siswa.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wali extends Model {
    
    private String table = "tb_siswa_wali";

    public Integer id = 0, siswa_id;

    public Siswa siswa;

    public String nama, alamat, pekerjaan, nomor_telfon;

    @Override
    public Collection<Wali> getAll() {
        ResultSet result = null;
        Collection<Wali> test = null;
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table);
            test = new Collection<Wali>();
            int i = 0;
            while(result.next()){
                
                test.put(i, convert(result));
                i++;
            }
            System.out.println(test);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return test;
    }

    @Override
    public boolean save() {
        String sql = "";
        int rowsInserted;
        PreparedStatement statement;
        if(id == 0){
            sql = "INSERT INTO " + this.table + " (siswa_id, nama, alamat, pekerjaan, nomor_telfon) VALUES (?, ?, ?, ?, ?)";
        }else{
            sql = "UPDATE " + this.table + " SET siswa_id=?, nama=?, alamat=?, pekerjaan=?, nomor_telfon=? WHERE id=?";
        }
        try {
            statement = getConnection().prepareStatement(sql);
            if(id != 0){
                statement.setInt(6, this.id);
            }
            statement.setInt(1, this.siswa_id);
            statement.setString(2, this.nama);
            statement.setString(3, this.alamat);
            statement.setString(4, this.pekerjaan);
            statement.setString(5, this.nomor_telfon);

            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                this.id = (new Wali()).where("siswa_id", String.valueOf(this.siswa_id)).id;

                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete() {
        String sql = "DELETE FROM " + this.table + " WHERE id=?";
 
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, this.id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public Wali where(String column, String value) {
        
        Wali siswa = null;
        ResultSet result;

        java.sql.Statement statement;
        try {
            statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table + " where " + column + " = '" + value + "'");
            while(result.next()){
                return convert(result);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return siswa;
    }

    @Override
    public Wali convert(ResultSet result) {
        Wali test2 = new Wali();
        try {
            test2.id = result.getInt("id");
            test2.siswa_id = result.getInt("siswa_id");
            test2.nama = result.getString("nama");
            test2.alamat = result.getString("alamat");
            test2.pekerjaan = result.getString("pekerjaan");
            test2.nomor_telfon = result.getString("nomor_telfon");

            test2.siswa = (new Siswa()).get(test2.id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return test2;
    }

    @Override
    public Wali get(int id) {
        Wali siswa = null;
        ResultSet result;

        java.sql.Statement statement;
        try {
            statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table + " where id = " + id + "");
            while(result.next()){
                return convert(result);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return siswa;
    }

    @Override
    public Collection<? extends Model> sql(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sql'");
    }

    
}
