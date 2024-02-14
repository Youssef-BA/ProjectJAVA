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
    
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT train.* FROM train JOIN voyage ON train.NumTrain = voyage.NumTrain WHERE voyage.Date = ? AND voyage.GareArrivee = ? AND voyage.GareDepart = ?");
            pst.setString(1, Date);
            pst.setString(2, Garrive);
            pst.setString(3, Gdep);
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                
                String typeTrain=rs.getString("Type");
                
                model.addRow(new Object[]{"Test", typeTrain, "Test", "prix2"});
                
                
                    }
            
            
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    
    
    }
    
}
