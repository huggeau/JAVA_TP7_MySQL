package fr.btsciel;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.attribute.UserPrincipal;
import java.sql.*;
import java.util.ArrayList;

public class GestionVoiture {
    private ArrayList<Voiture> v = new ArrayList<>();
    private Connection connection ;

    public ArrayList<Voiture> getV() {
        return v;
    }

    public void setV(ArrayList<Voiture> v) {
        this.v = v;
    }

    public void BeginConnection(String url, String user, String password) throws SQLException, ClassNotFoundException {
//            sert a créer la connexion entre la base de donnée et le programme et a le remplir
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection = DriverManager.getConnection(url, user, password);
    }

    public void FillList() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM voiture JOIN marque ON voiture.id_marque = marque.id");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Marque m = new Marque(rs.getInt("id"), rs.getString("nom"));
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("model"), m, rs.getInt("nb_vente"));
            v.add(voiture);
        }
    }
}
