/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esi.oncf;

import esi.oncf.data.Client;
import esi.oncf.data.Train;
import esi.oncf.vue.AUthentification;
import esi.oncf.vue.Admin;
import esi.oncf.vue.TrainInterface;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yassi
 */
public class EsiOncf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World!");
        //AUthentification home = new AUthentification();
        //home.setVisible(true);
        
        //TrainInterface train_ = new TrainInterface();
        //train_.setVisible(true);
        
        Admin voyage = new  Admin();
        voyage.setVisible(true);
        
        Train t1 = new Train("2031");
        System.out.println(t1.getIdFirstclasse());
        
    }
    
}
