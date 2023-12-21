package fr.btsciel;

import java.sql.*;
import java.util.ArrayList;

public class GestionVoiture {
    private Connection connection ;
    private ResultSet rs;
    private PreparedStatement ps;



    public void BeginConnection(String url, String user, String password) throws SQLException, ClassNotFoundException {
//            sert a créer la connexion entre la base de donnée et le programme
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection = DriverManager.getConnection(url, user, password);
    }

    public ArrayList<Voiture> FillList(ArrayList<Voiture> v) throws SQLException {
//        sert a remplir le liste de cahque elements de la base de donnée
        ps = connection.prepareStatement("SELECT * FROM voiture JOIN marque ON voiture.id_marque = marque.id");
        rs = ps.executeQuery();
        while(rs.next()){
            Marque m = new Marque(rs.getInt("id"), rs.getString("nom"));
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("model"), m, rs.getInt("nb_vente"));
            v.add(voiture);
        }
        rs.close();
        ps.close();
        connection.close();
        return v;
    }
}
