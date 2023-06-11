package data_siswa.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrangTua extends Model {
    
    private String table = "tb_siswa_ortu";

    public Integer id = 0, siswa_id;

    public Siswa siswa;

    public String nama_ayah, nama_ibu, alamat, pekerjaan_ayah, pekerjaan_ibu, nomor_telfon;

    @Override
    public Collection<OrangTua> getAll() {
        ResultSet result = null;
        Collection<OrangTua> test = null;
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table);
            test = new Collection<OrangTua>();
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
            sql = "INSERT INTO " + this.table + " (siswa_id, nama_ayah, nama_ibu, alamat, pekerjaan_ayah, pekerjaan_ibu, nomor_telfon) VALUES (?, ?, ?, ?, ?, ?, ?)";
        }else{
            sql = "UPDATE " + this.table + " SET siswa_id=?, nama_ayah=?, nama_ibu=?, alamat=?, pekerjaan_ayah=?, pekerjaan_ibu=?, nomor_telfon=? WHERE id=?";
        }
        try {
            statement = getConnection().prepareStatement(sql);
            if(id != 0){
                statement.setInt(8, this.id);
            }
            statement.setInt(1, this.siswa_id);
            statement.setString(2, this.nama_ayah);
            statement.setString(3, this.nama_ibu);
            statement.setString(4, this.alamat);
            statement.setString(5, this.pekerjaan_ayah);
            statement.setString(6, this.pekerjaan_ibu);
            statement.setString(7, this.nomor_telfon);

            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                this.id = (new OrangTua()).where("siswa_id", String.valueOf(this.siswa_id)).id;

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
    public OrangTua where(String column, String value) {
        
        OrangTua siswa = null;
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
    public OrangTua convert(ResultSet result) {
        OrangTua test2 = new OrangTua();
        try {
            test2.id = result.getInt("id");
            test2.siswa_id = result.getInt("siswa_id");
            test2.nama_ayah = result.getString("nama_ayah");
            test2.nama_ibu = result.getString("nama_ibu");
            test2.alamat = result.getString("alamat");
            test2.pekerjaan_ayah = result.getString("pekerjaan_ayah");
            test2.pekerjaan_ibu = result.getString("pekerjaan_ibu");
            test2.nomor_telfon = result.getString("nomor_telfon");

            test2.siswa = (new Siswa()).get(test2.id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return test2;
    }

    @Override
    public OrangTua get(int id) {
        OrangTua siswa = null;
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
