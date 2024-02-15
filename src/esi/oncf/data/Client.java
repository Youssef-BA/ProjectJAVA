package esi.oncf.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private String password;
    private String ID;
    private String nom;

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client() {
    }

    public Client(String ID) {
        this.ID = ID;
    }

    public boolean loginClient(String enteredPassword, String userID) {
        setID(userID);

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT Password FROM client WHERE ID_USER=?");
            pst.setString(1, userID);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String storedPassword = rs.getString("Password");

                // Use a secure method to compare passwords
                if (checkPassword(enteredPassword, storedPassword)) {
                    System.out.println("Login Successful");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Login Failed");
        return false;
    }

    public void reserver(String idVoyage, String idPlace) {
        int IDV = Integer.parseInt(idVoyage);
        int IDP = Integer.parseInt(idPlace);
        int IDU = Integer.parseInt(this.ID);

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO reservation (VoyageReserve, placeReserve, ID_USER) VALUES (?, ?, ?)");
            pst.setInt(1, IDV);
            pst.setInt(2, IDP);
            pst.setInt(3, IDU);
            int rowsInserted = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkPassword(String enteredPassword, String storedPassword) {

        return enteredPassword.equals(storedPassword);
    }
}
