package esi.oncf.vue;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RapportVoyage extends JFrame {
    private JTable table;

    public RapportVoyage() {
        super("Rapport des Voyages");
    
        // Définir la couleur de fond de la fenêtre
        getContentPane().setBackground(new Color(255, 200, 150)); // Une couleur entre l'orange et le rouge
    
        // Création des composants
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
    
        // Ajout des composants à la fenêtre
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    
        // Configuration de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    
        // Affichage des voyages
        afficherVoyages();
    }
    

    private void afficherVoyages() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oncf", "root", "");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Voyage")) {

            // Création du modèle de table
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Ajout des données au modèle de table
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }

            // Attribution du modèle de table à la JTable
            table.setModel(model);

        } catch (SQLException e) {
            afficherErreur("Erreur lors de la récupération des voyages: " + e.getMessage());
        }
    }

    private void afficherErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RapportVoyage::new);
    }
}
