/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author toshiba
 */
public class conek {
    private static Connection koneksi;
    
    public static Connection GetConnection()throws SQLException{
        if(koneksi==null){
          try{
          String url;          
          url="jdbc:mysql://localhost:3306/db_inventory";
          String user = "root";
          String pass = "";
          DriverManager.registerDriver(new com.mysql.jdbc.Driver());
          koneksi =DriverManager.getConnection(url, user, pass);
          }
          catch(SQLException e){
              JOptionPane.showMessageDialog(null, "eror koneksi");
          }
        }    
        return koneksi;
    }
  
}
