/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author toshiba
 */
public class cls_pengeluaran {
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
   
    private String sql;
    public String kd_keluar;
    public String tgl_keluar;
    public String buah;
    public String jumlah;
    public String kirim;
    
    
     public void submit()throws SQLException{
        conn = conek.GetConnection();
        sql = "INSERT INTO `pengeluaran` (`kd_keluar`, `tgl_keluar`, `buah`, `jumlah`, `dikirim`) VALUES(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, kd_keluar);
        pst.setString(2, tgl_keluar);
        pst.setString(3, buah);
        pst.setString(4, jumlah);
        pst.setString(5, kirim);
        pst.execute();
        pst.close();
 
    }
     
     
   public ResultSet UpdateJTable()throws SQLException{
       conn = conek.GetConnection();
       sql = "select * from pengeluaran";
       pst = conn.prepareStatement(sql);
       rs = pst.executeQuery();
       return rs;
   }
     
   public void hapus()throws SQLException{
       conn = conek.GetConnection();
       String sql = "delete from pengeluaran where kd_keluar=?";
       try{
           pst = conn.prepareStatement(sql);
           pst.setString(1, kd_keluar);
           pst.execute();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
   
   public ResultSet SearchTextList(String bh)throws SQLException{
       conn = conek.GetConnection();
       sql = "select * from pengeluaran where kd_keluar like ?";         
       pst = conn.prepareStatement(sql);
       pst.setString(1, bh + "%");
       rs = pst.executeQuery();
       return rs;
   }
}
