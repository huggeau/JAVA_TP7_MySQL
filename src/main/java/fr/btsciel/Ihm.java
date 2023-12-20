package fr.btsciel;

import java.sql.*;
import java.util.ArrayList;

public class Ihm {
    public static void main(String[] args) {
        try {
            ArrayList<Voiture> v = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connecteur present");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventes_de_voitures_2", "root", "");
            System.out.println("connexion effectué");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM voiture JOIN marque ON voiture.id_marque = marque.id");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Marque m = new Marque(rs.getInt("id"), rs.getString("nom"));
                Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("model"), m, rs.getInt("nb_vente"));
                v.add(voiture);
            }
            for (Voiture vo : v) {
                System.out.println(vo.getModele());
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("connecteur non-present" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("la connexion n'a pas pu être effectue "+ e.getMessage());
        }
    }
}
