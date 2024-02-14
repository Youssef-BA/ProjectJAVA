/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import esi.oncf.data.Client;
import esi.oncf.data.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yassi
 */
public class RechercherVoyage {
    
    public static void searchVoyage(String Date,String Gdep,String Garrive,JTable table){
        String prixF = null;
        String prixNd = null;
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT train.* ,voyage.* FROM train JOIN voyage ON train.NumTrain = voyage.NumTrain WHERE voyage.Date = ? AND voyage.GareArrivee = ? AND voyage.GareDepart = ?");
            pst.setString(1, Date);
            pst.setString(2, Garrive);
            pst.setString(3, Gdep);
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                try {
                    
                    String numTrain=rs.getString("NumTrain");
                    PreparedStatement pst1 = con.prepareStatement("SELECT * from place where trainApp = ? AND Classe = 1");
                    pst1.setString(1, numTrain);
                    ResultSet rs1=pst1.executeQuery();
                    while(rs1.next()){ prixF=rs1.getString("prix");}
                    
                    pst1 = con.prepareStatement("SELECT * from place where trainApp = ? AND Classe = 2");
                    pst1.setString(1, numTrain);
                    rs1=pst1.executeQuery();
                    while(rs1.next()){ prixNd=rs1.getString("prix");}
                   
                    
                    
                    
                }
                catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
                
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                String typeTrain=rs.getString("Type");
                String departure=rs.getString("HeureDepart");
                String IDV=rs.getString("IDvoyage");
                
                model.addRow(new Object[]{departure, typeTrain, prixF, prixNd,IDV});
                
                
                    }
            
            
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    
    
    }
    
}
