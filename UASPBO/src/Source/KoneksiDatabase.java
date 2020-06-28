/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 21.55 WITA
*/
package Source;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KoneksiDatabase {
    private static Connection con;
    public static Connection getConnection(){ 
        if(con==null){ 
            try { 
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry","root","");             
            } catch (SQLException ex) { 
                Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);  
            }
        } 
        return con;
    }
}
