/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esi.oncf.control;

import javax.swing.JOptionPane;
import esi.oncf.data.Client;
import esi.oncf.data.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yassi
 */
public class RechercherVoyage {

    public static void AfficherVoyage(JTable table){
        String Ntrain = null;
        String IDV = null;
        int FSClasse = 0;
        int NdClasse = 0;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        HashMap<String, String> rowData = new HashMap<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM VOYAGE");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                IDV = rs.getString("IDvoyage");
                Ntrain=rs.getString("NumTrain");// Set the flag to true as at least one row is processed

                try {
                    
                    PreparedStatement pst1 = con.prepareStatement("SELECT COUNT(place.classe) as FSClasse FROM reservation JOIN place ON reservation.placeReserve = place.idplace WHERE reservation.VoyageReserve = ? AND place.classe=1");
                    pst1.setString(1, IDV);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                     FSClasse = rs1.getInt("FSClasse");
                    }
            
            }
                catch (SQLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    // Handle SQLException as needed
                }
                try {
                    
                    PreparedStatement pst2 = con.prepareStatement("SELECT COUNT(place.classe) as FSClasse FROM reservation JOIN place ON reservation.placeReserve = place.idplace WHERE reservation.VoyageReserve = ? AND place.classe=2");
                    pst2.setString(1, IDV);
                    ResultSet rs1 = pst2.executeQuery();
                    while (rs1.next()) {
                     NdClasse = rs1.getInt("FSClasse");
                     
                        model.addRow(new Object[]{IDV, Ntrain, FSClasse, NdClasse});
                    }
            
            }
                catch (SQLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    // Handle SQLException as needed
                }
                
                
            }
                        
        
        }
        catch (SQLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    // Handle SQLException as needed
                }
    }


    public static void searchVoyage(String date, String Gdep, String Garrive, JTable table) {
        String prixF = null;
        String prixNd = null;
        boolean rowsProcessed = false;

        try {
            // Validate the date format
            if (!isValidDateFormat(date)) {
                JOptionPane.showMessageDialog(null, "Format de date invalide. Utilisez le format yyyy-MM-dd.");
                return;
            }

            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT train.* ,voyage.* FROM train JOIN voyage ON train.NumTrain = voyage.NumTrain WHERE voyage.Date = ? AND voyage.GareArrivee = ? AND voyage.GareDepart = ?");
            pst.setString(1, date);
            pst.setString(2, Garrive);
            pst.setString(3, Gdep);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                rowsProcessed = true; // Set the flag to true as at least one row is processed

                try {
                    String numTrain = rs.getString("NumTrain");
                    PreparedStatement pst1 = con.prepareStatement("SELECT * from place where trainApp = ? AND Classe = 1");
                    pst1.setString(1, numTrain);
                    ResultSet rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        prixF = rs1.getString("prix");
                    }

                    pst1 = con.prepareStatement("SELECT * from place where trainApp = ? AND Classe = 2");
                    pst1.setString(1, numTrain);
                    rs1 = pst1.executeQuery();
                    while (rs1.next()) {
                        prixNd = rs1.getString("prix");
                    }
                } catch (NumberFormatException ex) {
                    // Handle the format-related error (e.g., when parsing numeric values)
                    JOptionPane.showMessageDialog(null, "Erreur de format dans les données.");
                    return; // Exit the method to avoid further processing
                } catch (SQLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    // Handle SQLException as needed
                }

                String typeTrain = rs.getString("Type");
                String departure = rs.getString("HeureDepart");
                String IDV = rs.getString("IDvoyage");

                model.addRow(new Object[]{departure, typeTrain, prixF, prixNd, IDV});
            }

            if (!rowsProcessed) {
                JOptionPane.showMessageDialog(null, "Aucun train disponible avec ces spécifications.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            // Handle SQLException as needed
        }
    }

    private static boolean isValidDateFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
