/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import esi.oncf.data.Client;
import esi.oncf.data.DatabaseConnection;
import esi.oncf.vue.AUthentification;
import static esi.oncf.vue.ConfirmerReservationMessage.redCode;
import esi.oncf.vue.RechercherTrain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yassi
 */
public class Reservation {
    
    
    public static String getTrainbyVoyage(String IDV){
    
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from voyage where IDvoyage = ?");
            pst.setString(1, IDV);
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("NumTrain"));
                return rs.getString("NumTrain");
                
                
                    }
    
        }
        catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}return null;
}
    
    public static String  getPlace(String typeClasse){
        
        try {
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from place where trainApp = ? AND Classe = ? AND Etat IS NULL");
            pst.setString(2, typeClasse);
            pst.setString(1, getTrainbyVoyage(RechercherTrain.ID_Voyage));
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("IDPlace"));
                String IDp =rs.getString("IDPlace");
                return IDp;
                
                
                    }
    
        }
        catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}return null;
    
        }
    
    public static boolean Addreservation(String typeClasse,String CodeReser){
        int RED=0;
        int prix=0;
        try {
            
            Connection con=DatabaseConnection.getConnection();
            
            
            PreparedStatement pst3 = con.prepareStatement("SELECT * FROM voyage WHERE IDvoyage=? ");
            pst3.setString(1, RechercherTrain.ID_Voyage);
            
            ResultSet rs1 = pst3.executeQuery();
                    while (rs1.next()) {
                       String REDc = rs1.getString("Reduction");
                       RED=rs1.getInt("ReductionAmount");
                       if (!REDc.equals(CodeReser) && !CodeReser.isEmpty()){ 
                               JOptionPane.showMessageDialog(null, "Code de Reduction Erroné");
                               
                               return false;}
                        if (CodeReser.isEmpty())      
                        {RED=0;}
                       
                    }
            
            
            PreparedStatement pst = con.prepareStatement("INSERT INTO reservation (ID_USER,VoyageReserve,placeReserve) VALUES (?, ? ,?)");
            pst.setString(1, AUthentification.id);
            pst.setString(2, RechercherTrain.ID_Voyage);
            pst.setString(3, getPlace(typeClasse));
            
            
            
            pst.executeUpdate();
            
            PreparedStatement pst4 = con.prepareStatement("SELECT * FROM place WHERE IDPlace=? ");
            pst4.setString(1,getPlace(typeClasse));
            ResultSet rs4 = pst4.executeQuery();
            while (rs4.next()){
            prix =rs4.getInt("prix") ;}
            
            PreparedStatement pst1 = con.prepareStatement("UPDATE place SET Etat = 1 , prix = ? WHERE IDPlace = ? ");
            pst1.setInt(1, prix - RED);
            pst1.setString(2, getPlace(typeClasse));
            pst1.executeUpdate();
            return true;
            
            
            
            
        
        }
        catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
        return false;
    
}
    public static Map<String, Object> addAndRetrieveReservationDetails(String typeClasse, String redCode1) {
        String pID=getPlace(typeClasse);
       if( Reservation.Addreservation(typeClasse,redCode)){

        // Then, fetch the reservation details
        Map<String, Object> details = new HashMap<>();
        String query = "SELECT v.IDvoyage, v.NumTrain, p.numeroPlace, p.Prix, v.GareDepart, v.GareArrivee, v.Date, v.Duree, v.HeureDepart, p.Classe "
                     + "FROM Voyage v "
                     + "JOIN Place p ON v.NumTrain = p.TrainApp "
                     + "WHERE v.IDvoyage = ?  AND p.IDPlace =? "
                     + "LIMIT 1";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setString(1, RechercherTrain.ID_Voyage);
            pst.setString(2, pID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                details.put("IDvoyage", rs.getString("IDvoyage"));
                details.put("NumTrain", rs.getString("NumTrain"));
                details.put("numeroPlace", rs.getString("numeroPlace"));
                details.put("GareDepart", rs.getString("GareDepart"));
                details.put("GareArrivee", rs.getString("GareArrivee"));
                details.put("Date", rs.getString("Date"));
                details.put("Duree", rs.getString("Duree"));
                details.put("HeureDepart", rs.getString("HeureDepart"));
                details.put("Prix", rs.getString("Prix"));
                details.put("Classe", typeClasse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return details;}
       return null;
    }
}
