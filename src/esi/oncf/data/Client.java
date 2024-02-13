/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yassi
 */
public class Client {
    private String password;
    private String ID;
    private String nom;

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Client() {
            
        }
    
    public Client(String ID) {
        this.ID = ID;
    }
    
    
    public boolean loginClient(String pswd,String ID) throws SQLException{
        setID(ID);
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select Password from client where ID_USER=?");
            pst.setString(1, ID);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                this.password=rs.getString("Password");
                System.out.println(this.password);
                
                    }
            ;
            if (pswd.equals(this.password)){
                System.out.println("Login Succes");
                return true;
                }
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
        
        System.out.println("Login Failed");
               return false;
        
        
        
        
        
        
  
}}
