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
import javax.swing.JComboBox;

/**
 *
 * @author yassi
 */
public class AddVoyage {
    
    public static void  chargerTrain(){
        JComboBox<String> NbreTrain = new  JComboBox<>();
        try {
            System.out.println("esi.oncf.control.AddVoyage.chargerTrain()");
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from train");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int item = rs.getInt("NumTrain");
                System.out.println(item);

                
                NbreTrain.addItem(""+item);
                
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
        
        }
    
    
        public static void ajouterVoyage(String numTrain,String dep,String arrive,String time,String hour,String Date ,String FsPrice,String SdPrice ,String RDC,String RD){
        
        int erClasse=Integer.parseInt(FsPrice);
        int NdClasse=Integer.parseInt(SdPrice);
        
        int numberTrain = Integer.parseInt(numTrain);
        try {
            
            Connection con=DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO voyage (NumTrain,GareDepart,Date,Duree,HeureDepart,GareArrivee,ReductionAmount,Reduction) VALUES (?, ?,?,?,?,?,?,?)");
            pst.setInt(1, numberTrain);
            pst.setString(2, dep);
            pst.setString(3, Date);
            pst.setString(4, time);
            pst.setString(5, hour);
            pst.setString(6, arrive);
            pst.setString(7, RD);
            pst.setString(8, RDC);
            int rowsInserted = pst.executeUpdate();
            System.out.println("Voyage Aded");
            
            PreparedStatement pstUpdate=con.prepareStatement("UPDATE place SET prix = ? WHERE trainApp = ? AND Classe = 1");
            pstUpdate.setInt(2, numberTrain);
            pstUpdate.setInt(1, erClasse);
            pstUpdate.executeUpdate();
            
            PreparedStatement pstUpdatend=con.prepareStatement("UPDATE place SET prix = ? WHERE trainApp = ? AND Classe = 2");
            pstUpdatend.setInt(2, numberTrain);
            pstUpdatend.setInt(1, NdClasse);
            pstUpdatend.executeUpdate();
            
            
            
            
        }
         catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);}
        
        }
        
        
    
        
    
}
