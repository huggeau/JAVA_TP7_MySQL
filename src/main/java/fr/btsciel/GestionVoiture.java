package fr.btsciel;

import clavier.In;

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
            Voiture voiture = new Voiture(rs.getInt("id"), rs.getString("modele"), m, rs.getInt("nb_vente"));
            v.add(voiture);
        }
        return v;
    }
    public ArrayList<Voiture> SortBySells(ArrayList<Voiture> v) throws SQLException {
        ps = connection.prepareStatement("SELECT nb_vente FROM voiture JOIN marque ON voiture.id_marque = marque.id Order BY nb_vente");
        return v;
    }
    public ArrayList<Voiture> PrintCars(ArrayList<Voiture> v ) throws SQLException {
        String demande ;
        System.out.println("""
        quel est la maque de voiture dont vous voulez savoir les modèles ? 
        vous avez le choix parmis :
        Renault
        Citroën
        Toyota 
        Peugeot
        Dacia
        """);
        demande = In.readString();
        ps = connection.prepareStatement("SELECT modele FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE marque.nom = " + demande);
        return v;
    }
}
