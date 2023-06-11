package data_siswa.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Siswa_Detail extends Model {
    
    private String table = "tb_siswa_detail";

    public Integer id = 0, siswa_id;

    public Siswa siswa;

    public String di_kelas;

    public Date pada_tanggal;

    @Override
    public Collection<Siswa_Detail> getAll() {
        ResultSet result = null;
        Collection<Siswa_Detail> test = null;
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery("select * from " + table);
            test = new Collection<Siswa_Detail>();
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
            sql = "INSERT INTO " + this.table + " (siswa_id, di_kelas, pada_tanggal) VALUES (?, ?, ?)";
        }else{
            sql = "UPDATE " + this.table + " SET siswa_id=?, di_kelas=?, pada_tanggal=? WHERE id=?";
        }
        try {
            statement = getConnection().prepareStatement(sql);
            if(id != 0){
                statement.setInt(4, this.id);
            }
            statement.setInt(1, this.siswa_id);
            statement.setString(2, this.di_kelas);
            statement.setDate(3, this.pada_tanggal);
            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                this.id = (new Siswa_Detail()).where("siswa_id", String.valueOf(this.siswa_id)).id;

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
    public Siswa_Detail where(String column, String value) {
        
        Siswa_Detail siswa = null;
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
    public Siswa_Detail convert(ResultSet result) {
        Siswa_Detail test2 = new Siswa_Detail();
        try {
            test2.id = result.getInt("id");
            test2.siswa_id = result.getInt("siswa_id");
            test2.di_kelas = result.getString("di_kelas");
            test2.pada_tanggal = result.getDate("pada_tanggal");

            test2.siswa = (new Siswa()).get(test2.id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return test2;
    }

    @Override
    public Siswa_Detail get(int id) {
        Siswa_Detail siswa = null;
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
