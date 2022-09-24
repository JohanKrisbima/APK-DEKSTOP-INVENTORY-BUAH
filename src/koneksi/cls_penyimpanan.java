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
public class cls_penyimpanan {
    Connection conn = null;
    ResultSet rs = null ;
    PreparedStatement pst = null;
   
    private String sql;
    public String kd_simpan;
    public String tgl_simpan;
    public String buah;
    public String jumlah;
    
    
     public void submit()throws SQLException{
        conn = conek.GetConnection();
        sql = "INSERT INTO `penyimpanan` (`kd_simpan`, `tgl_simpan`, `buah`, `jumlah`) VALUES(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, kd_simpan);
        pst.setString(2, tgl_simpan);
        pst.setString(3, buah);
        pst.setString(4, jumlah);
        pst.execute();
        pst.close();
 
    }
     
     
   public ResultSet UpdateJTable()throws SQLException{
       conn = conek.GetConnection();
       sql = "select * from penyimpanan";
       pst = conn.prepareStatement(sql);
       rs = pst.executeQuery();
       return rs;
   }
     
   public void hapus()throws SQLException{
       conn = conek.GetConnection();
       String sql = "delete from penyimpanan where kd_simpan=?";
       try{
           pst = conn.prepareStatement(sql);
           pst.setString(1, kd_simpan);
           pst.execute();
       }
       catch(Exception e){
           System.out.println(e);
       }
   }
   
   
   public ResultSet SearchList(String bh)throws SQLException{
       conn = conek.GetConnection();
       sql = "select * from penyimpanan where kd_simpan like ?";         
       pst = conn.prepareStatement(sql);
       pst.setString(1, bh + "%");
       rs = pst.executeQuery();
       return rs;
   }
}
