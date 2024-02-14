/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import esi.oncf.data.Client;
import esi.oncf.data.DatabaseConnection;
import esi.oncf.vue.AUthentification;
import esi.oncf.vue.RechercherTrain;
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
                return rs.getString("IDPlace");
                
                
                    }
    
        }
        catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}return null;
    
        }
    
    public static void Addreservation(String typeClasse){
        
        try {
            
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reservation (ID_USER,VoyageReserve,placeReserve) VALUES (?, ? ,?)");
            pst.setString(1, AUthentification.id);
            pst.setString(2, RechercherTrain.ID_Voyage);
            pst.setString(3, getPlace(typeClasse));
            
            pst.executeUpdate();
        
        }
        catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
    
}}
