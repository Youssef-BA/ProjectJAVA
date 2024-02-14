/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package esi.oncf.vue;

import esi.oncf.control.AddVoyage;
import static esi.oncf.control.AddVoyage.ajouterVoyage;
import static esi.oncf.control.AddVoyage.chargerTrain;
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
 * @author Administrator
 */
public class Admin extends javax.swing.JFrame {
    
   
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        JComboBox<String> NbreTrain = new  JComboBox<>();
        chargerTrain();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    
    public  void  chargerTrain(){
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Admin = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Reinitialiser = new javax.swing.JButton();
        Retour = new javax.swing.JButton();
        JGareDepart = new javax.swing.JLabel();
        JGareArrivee = new javax.swing.JLabel();
        JDate = new javax.swing.JLabel();
        JHeure = new javax.swing.JLabel();
        JDuree = new javax.swing.JLabel();
        JPrix = new javax.swing.JLabel();
        GareDepart = new javax.swing.JComboBox<>();
        GareArrivee = new javax.swing.JComboBox<>();
        Duree = new javax.swing.JTextField();
        PrixFst = new javax.swing.JTextField();
        Heure = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        JNbreTrain = new javax.swing.JLabel();
        NbreTrain = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        PrixNd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Admin.setBackground(new java.awt.Color(255, 125, 16));

        Add.setBackground(new java.awt.Color(0, 255, 51));
        Add.setText("Ajouter");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Reinitialiser.setBackground(new java.awt.Color(255, 0, 0));
        Reinitialiser.setText("Reinitialiser");
        Reinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReinitialiserActionPerformed(evt);
            }
        });

        Retour.setText("< Retour");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });

        JGareDepart.setText("Gare de Départ");

        JGareArrivee.setText("Gare d'Arrivée");

        JDate.setText("Date de voyage");

        JHeure.setText("Heure de départ");

        JDuree.setText("Durée de voyage");

        JPrix.setText("Prix 1 ");

        GareDepart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rabat", "Oujda", "Marrakech", "Fès", "Meknès", "Kénitra", "Casablanca", "Tanger", "Nador", "Oued Zem", "El Jadida", "Safi", "Sidi Kacem" }));
        GareDepart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GareDepartItemStateChanged(evt);
            }
        });

        GareArrivee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oujda", "Marrakech", "Fès", "Meknès", "Kénitra", "Rabat", "Casablanca", "Tanger", "Nador", "Oued Zem", "El Jadida", "Safi", "Sidi Kacem" }));

        Duree.setText("hh:mm");

        PrixFst.setText("Saisir le prix");
        PrixFst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrixFstActionPerformed(evt);
            }
        });

        Heure.setText("hh:mm");

        Date.setText("dd/mm/yyyy");
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        Logo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ma/ac/esi/image/oncf.png"))); // NOI18N

        Title.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Ajouter un Voyage");
        Title.setMaximumSize(new java.awt.Dimension(200, 100));
        Title.setMinimumSize(new java.awt.Dimension(100, 50));

        JNbreTrain.setText("Numero de Train");

        NbreTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbreTrainActionPerformed(evt);
            }
        });

        jLabel1.setText("Prix 2");

        PrixNd.setText("jTextField1");
        PrixNd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrixNdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin);
        Admin.setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 237, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminLayout.createSequentialGroup()
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AdminLayout.createSequentialGroup()
                                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JGareArrivee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JGareDepart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JHeure, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(GareArrivee, 0, 197, Short.MAX_VALUE)
                                    .addComponent(Heure)
                                    .addComponent(GareDepart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Date)))
                            .addGroup(AdminLayout.createSequentialGroup()
                                .addComponent(JDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Retour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reinitialiser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminLayout.createSequentialGroup()
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JNbreTrain)
                            .addComponent(JPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NbreTrain, 0, 196, Short.MAX_VALUE)
                            .addComponent(PrixFst, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(PrixNd)))
                    .addComponent(Add))
                .addGap(101, 101, 101))
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JGareDepart)
                    .addComponent(GareDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JNbreTrain)
                    .addComponent(NbreTrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JGareArrivee)
                    .addComponent(GareArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrixFst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JPrix))
                .addGap(18, 18, 18)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDate)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(PrixNd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JHeure)
                    .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JDuree)
                    .addComponent(Duree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retour)
                    .addComponent(Reinitialiser)
                    .addComponent(Add))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GareDepartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GareDepartItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_GareDepartItemStateChanged

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        String Gdepart = (String) GareDepart.getSelectedItem();
        String Garrive=(String) GareArrivee.getSelectedItem();
        String numTrain=(String) NbreTrain.getSelectedItem();
        String heureEntered = Heure.getText();
        String DureEntered = Duree.getText();
        String DateEntered = Date.getText();
        String ERclasseP = PrixFst.getText();
        String NDclasseP = PrixNd.getText();
        System.out.println(numTrain + Gdepart+Garrive+DureEntered+heureEntered +DateEntered+ERclasseP+NDclasseP);
        ajouterVoyage(numTrain ,Gdepart ,Garrive,DureEntered,heureEntered ,DateEntered,ERclasseP,NDclasseP);
        //public static void ajouterVoyage(String numTrain,String dep,String arrive,String time,String hour,String Date)
        
        

        
        
    }//GEN-LAST:event_AddActionPerformed

    private void PrixFstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrixFstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrixFstActionPerformed

    private void ReinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReinitialiserActionPerformed
        // Réinitialiser tous les JComboBox à leur premier élément
        GareDepart.setSelectedIndex(0);
        GareArrivee.setSelectedIndex(0);
        

        // Réinitialiser les champs de texte avec des valeurs par défaut ou vides
        Date.setText("dd/mm/yyyy");
        Heure.setText("hh:mm");
        Duree.setText("hh:mm");
        PrixFst.setText("Saisir le prix");
    }//GEN-LAST:event_ReinitialiserActionPerformed

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        // TODO add your handling code here:
        AcceuilAdmin FenetreAcceuil = new AcceuilAdmin();
        FenetreAcceuil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RetourActionPerformed

    private void NbreTrainActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

    }                                         

    private void IdPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdPlaceActionPerformed

    private void PrixNdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrixNdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrixNdActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

                                           


    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JPanel Admin;
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Duree;
    private javax.swing.JComboBox<String> GareArrivee;
    private javax.swing.JComboBox<String> GareDepart;
    private javax.swing.JTextField Heure;
    private javax.swing.JLabel JDate;
    private javax.swing.JLabel JDuree;
    private javax.swing.JLabel JGareArrivee;
    private javax.swing.JLabel JGareDepart;
    private javax.swing.JLabel JHeure;
    private javax.swing.JLabel JNbreTrain;
    private javax.swing.JLabel JPrix;
    private javax.swing.JLabel Logo;
    private javax.swing.JComboBox<String> NbreTrain;
    private javax.swing.JTextField PrixFst;
    private javax.swing.JTextField PrixNd;
    private javax.swing.JButton Reinitialiser;
    private javax.swing.JButton Retour;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    Object getGareDepart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getGareArrivee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
