/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class Admin {
    
    private String idAdmin;
    private String psswdAdmin;
    
    public Admin(){}
    
    public boolean loginAdmin(String pswd,String ID) throws SQLException{
        
        
        this.idAdmin=ID;
        
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select pswd from admin where Id_admin =?");
            pst.setString(1, ID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                this.psswdAdmin=rs.getString("pswd");
                System.out.println(this.psswdAdmin);
                
                    }
            
            if (pswd.equals(this.psswdAdmin)){
                System.out.println("Login Succes");
                return true;
                }
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
        
        System.out.println("Login Failed");
               return false;    
    
    }
    
    
}
