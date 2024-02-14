/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.data;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class Train {
    
    private String type;
    private String numTrain;
    
    public Train(){};

    public Train(String numTrain) {
        this.numTrain = numTrain;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public String getType() {
        return type;
    }

    public String getNumTrain() {
        return numTrain;
    }
    
    public ArrayList<Integer> getIdFirstclasse(){
        ArrayList<Integer> IDlist = new ArrayList<>();
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select IDPlace  from place where trainApp=? AND Classe=1");
            pst.setString(1, this.numTrain);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                IDlist.add(rs.getInt("IDPlace"));
                    }
            return IDlist;
        }
            
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    
        return IDlist;
    
    }
    public ArrayList<Integer> getIdSecondclasse(){
        ArrayList<Integer> IDlist = new ArrayList<>();
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select IDPlace  from place where trainApp=? AND Classe=2");
            pst.setString(1, this.numTrain);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                IDlist.add(rs.getInt("IDPlace"));
                    }
            return IDlist;
        }
            
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    
        return IDlist;
    
    }
    
    
    
}
