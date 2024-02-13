/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import esi.oncf.data.Client;
import esi.oncf.data.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class AddTrain_ {
    
    public static void AjouterTrain(String Ntrain,String TypeTrain,String stPlaceS,String ndPlaceS){
             
            int stPlace= Integer.parseInt(stPlaceS);
            int ndPlace=Integer.parseInt(ndPlaceS);
        
            int numberTrain = Integer.parseInt(Ntrain);
            
            try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO train (NumTrain, Type) VALUES (?, ?)");
            pst.setInt(1, numberTrain);
            pst.setString(2, TypeTrain);
            int rowsInserted = pst.executeUpdate();
            System.out.println("Train Aded");
            
            for (int i = 1; i <= ndPlace; i++) {
                   PreparedStatement pstND = con.prepareStatement("INSERT INTO place (trainApp, Classe , numeroPlace ) VALUES (?, ? ,?)");
                   pstND.setInt(1, numberTrain);
                   pstND.setInt(2, 2);
                   pstND.setInt(3, i); 
                   pstND.executeUpdate();
                   
                }
            
            for (int i = 1; i <= stPlace; i++) {
                   PreparedStatement pstST = con.prepareStatement("INSERT INTO place (trainApp, Classe , numeroPlace ) VALUES (?, ? ,?)");
                   pstST.setInt(1, numberTrain);
                   pstST.setInt(2, 1);
                   pstST.setInt(3, i+ndPlace);
                   pstST.executeUpdate();
                }
            
                
            }
            
            
            catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
            
            
    
    
    
    }
    
    
}
