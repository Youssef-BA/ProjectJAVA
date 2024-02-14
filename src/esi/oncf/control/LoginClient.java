/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import esi.oncf.EsiOncf;
import esi.oncf.data.Admin;
import esi.oncf.data.Client;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class LoginClient {
    
    public LoginClient(){}
    
    public static boolean loginClientaction(String pswdEntered, String Identred, boolean adminChecked){
            
        if (adminChecked == true){
            adminChecked=false;
            Admin admin = new Admin();
            
        try {
            return admin.loginAdmin(pswdEntered,Identred);
            
        } catch (SQLException ex) {
            Logger.getLogger(EsiOncf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
        else{            
            Client c1 = new Client();
           
            
        try {
            return c1.loginClient(pswdEntered,Identred);
        } catch (SQLException ex) {
            Logger.getLogger(EsiOncf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;}
        
        
    }
    
}
