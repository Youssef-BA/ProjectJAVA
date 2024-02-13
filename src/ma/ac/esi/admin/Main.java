package ma.ac.esi.admin;  // Assurez-vous que le package correspond à la structure de votre projet

public class Main {
    public static void main(String[] args) {
        // Cette ligne est nécessaire pour exécuter l'interface graphique dans le fil d'exécution de l'interface graphique (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Créez une instance de votre interface graphique Admin et rendez-la visible
            Admin adminFrame = new Admin();
            adminFrame.setVisible(true);
        });
    }
}