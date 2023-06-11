package data_siswa.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Siswa extends Model {
    
    private String table = "tb_siswa";

    public Integer id = 0, anak_ke;

    public String nama_lengkap, nomor_induk, nisn, gender, agama, status_dalam_keluarga, alamat, nomor_telfon, sekolah_asal, tempat_lahir;

    public Date tanggal_lahir;

    @Override
    public Collection<Siswa> getAll() {
        ResultSet result = null;
        Collection<Siswa> test = null;
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table);
            test = new Collection<Siswa>();
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
    public Siswa get(int id) {
        Siswa siswa = null;
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
    public boolean save() {
        String sql = "";
        int rowsInserted;
        PreparedStatement statement;
        if(id == 0){
            sql = "INSERT INTO " + this.table + " (nama_lengkap, nomor_induk, nisn, gender, agama, status_dalam_keluarga, anak_ke, alamat, nomor_telfon, sekolah_asal, tempat_lahir, tanggal_lahir) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }else{
            sql = "UPDATE " + this.table + " SET nama_lengkap=?, nomor_induk=?, nisn=?, gender=?, agama=?, status_dalam_keluarga=?, anak_ke=?, alamat=?, nomor_telfon=?, sekolah_asal=?, tempat_lahir=?, tanggal_lahir=? WHERE id=?";
        }
        try {
            statement = getConnection().prepareStatement(sql);
            if(id != 0){
                statement.setInt(13, this.id);
            }
            statement.setString(1, this.nama_lengkap);
            statement.setString(2, this.nomor_induk);
            statement.setString(3, this.nisn);
            statement.setString(4, this.gender);
            statement.setString(5, this.agama);
            statement.setString(6, this.status_dalam_keluarga);
            statement.setInt(7, this.anak_ke);
            statement.setString(8, this.alamat);
            statement.setString(9, this.nomor_telfon);
            statement.setString(10, this.sekolah_asal);
            statement.setString(11, this.tempat_lahir);
            statement.setDate(12, this.tanggal_lahir);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                this.id = (new Siswa()).where("nama_lengkap", this.nama_lengkap).id;
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
    public Siswa where(String column, String value) {
        
        Siswa siswa = null;
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
    public Siswa convert(ResultSet result) {
        Siswa test2 = new Siswa();
        try {
            test2.id = result.getInt("id");
            test2.anak_ke = result.getInt("anak_ke");
            test2.nama_lengkap = result.getString("nama_lengkap");
            test2.nomor_induk = result.getString("nomor_induk");
            test2.nisn = result.getString("nisn");
            test2.gender = result.getString("gender");
            test2.agama = result.getString("agama");
            test2.status_dalam_keluarga = result.getString("status_dalam_keluarga");
            test2.alamat = result.getString("alamat");
            test2.nomor_telfon = result.getString("nomor_telfon");
            test2.sekolah_asal = result.getString("sekolah_asal");
            test2.tempat_lahir = result.getString("tempat_lahir");
            test2.tanggal_lahir = result.getDate("tanggal_lahir");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return test2;
    }

    @Override
    public Collection<Siswa> sql(String sql) {
        ResultSet result = null;
        Collection<Siswa> test = null;
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery(sql);
            test = new Collection<Siswa>();
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

    
}
