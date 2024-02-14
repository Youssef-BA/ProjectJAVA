package esi.oncf.vue;  // Assurez-vous que le package correspond à la structure de votre projet
import esi.oncf.vue.Client;



public class Main1 {
    public static void main(String[] args) {
        // Cette ligne est nécessaire pour exécuter l'interface graphique dans le fil d'exécution de l'interface graphique (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Créez une instance de votre interface graphique Admin et rendez-la visible
            Client adminFrame = new Client();
            adminFrame.setVisible(true);
        });
    }
}
