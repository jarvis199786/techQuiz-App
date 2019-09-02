/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class DBConnection {
    private static Connection conn;
    static{
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","onlineexam","student");
            JOptionPane.showMessageDialog(null,"Connected Sucessfully to DB","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error connecting to the DB :"+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection(){
        if(conn!=null){
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"Disconnected successfully from DB","Suceess",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error disconnecting from the DB"+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
    }    
    
}
