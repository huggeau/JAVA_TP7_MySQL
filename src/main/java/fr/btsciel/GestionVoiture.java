package fr.btsciel;

import clavier.In;

import java.sql.*;
import java.util.ArrayList;

public class GestionVoiture{
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
        return v;
    }
    public ArrayList<Voiture> SortBySells() throws SQLException {
        ArrayList<Voiture> result = new ArrayList<>();
        ps = connection.prepareStatement("SELECT nb_vente, model, marque.nom FROM voiture JOIN marque ON voiture.id_marque = marque.id Order BY nb_vente DESC");
        rs = ps.executeQuery();
        while(rs.next()){
            Voiture v = new Voiture();
            v.setNb_vente(rs.getInt("nb_vente"));
            v.setModele(rs.getString("model"));
            v.setMarque(new Marque(0, rs.getString("marque.nom")));
            result.add(v);
        }
        return result;
    }
    public ArrayList<Voiture> PrintCars() throws SQLException {
        ArrayList<Voiture> v =new ArrayList<>();
        String demande ;
        System.out.println("""
        quel est la marque de voiture dont vous voulez savoir les modèles ? 
        vous avez le choix parmis :
        Renault
        Citroën
        Toyota 
        Peugeot
        Dacia
        """);
        demande = In.readString();
        ps = connection.prepareStatement("SELECT marque.nom, model FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE marque.nom = " + demande);
        rs = ps.executeQuery();
        while(rs.next()){
            Voiture vo = new Voiture();
            vo.setModele(rs.getString("model"));
            vo.setMarque(new Marque(0, rs.getString("marque.nom")));
            v.add(vo);
        }
        return v;
    }
    public ArrayList<Voiture> PrintSumCarSell() throws SQLException {
        ArrayList<Voiture> v = new ArrayList<>();
        String demande ;
        System.out.println("""
        quel est la marque de voiture dont vous voulez savoir les modèles ? 
        vous avez le choix parmis :
        Renault
        Citroën
        Toyota 
        Peugeot
        Dacia
        """);
        demande = In.readString();
        ps = connection.prepareStatement("SELECT SUM(nb_vente) FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE marque.nom = "+ demande);
        rs = ps.executeQuery();
        while(rs.next()){

        }
        return v;
    }
    public ArrayList<Voiture> PrintCarByBeginningLetter(ArrayList<Voiture> v) throws SQLException {
        char demande ;
        System.out.println("quel est la lettre que vous voulez choisir dans votre recherche de modele ");
        demande = In.readChar();
        ps = connection.prepareStatement("SELECT marque.nom, model FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE model LIKE '"+ demande + "'");
        rs = ps.executeQuery();
        return v;
    }
    public int PrintNumberOfSaves() throws SQLException {
        int result = 0;
        ps = connection.prepareStatement("SELECT COUNT(*) AS nombre FROM voiture JOIN marque ON voiture.id_marque = marque.id");
        rs = ps.executeQuery();
        while(rs.next()){
            result = rs.getInt("nombre");
        }
        return result;
    }
    public int PrintSumAllSells() throws SQLException {
        int result  = 0;
        ps = connection.prepareStatement("SELECT SUM(nb_vente) AS nombre FROM voiture JOIN marque ON voiture.id_marque = marque.id");
        rs = ps.executeQuery();
        while(rs.next()){
            result = rs.getInt("nombre");
        }
        return result;
    }
    public ArrayList<Voiture> PrintCarByLetters(ArrayList<Voiture> v) throws SQLException {
        char demande ;
        System.out.println("quel est la lettre que vous choisicez pour votre recherche de modele ");
        demande = In.readChar();
        ps = connection.prepareStatement("SELECT marque.nom, model FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE model like '%"+ demande+"%'");
        rs = ps.executeQuery();
        return v;
    }
    public ArrayList<Voiture> PrintCarBySecondLetters(ArrayList<Voiture> v) throws SQLException {
        char demande ;
        System.out.println("quel est la lettre que vous choisirez dans votre recherche de modele ");
        demande = In.readChar();
        ps = connection.prepareStatement("SELECT marque.nom, model FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE model LIKE '_"+ demande+"%'");
        rs = ps.executeQuery();
        return v;
    }
    public ArrayList<Voiture> PrintCarByLastLetter(ArrayList<Voiture> v) throws SQLException {
        char demande ;
        System.out.println("quel est la lettre que vous choisirez pour votre recherche de modele ");
        demande = In.readChar();
        ps = connection.prepareStatement("SELECT marque.nom, model FROM voiture JOIN marque ON voiture.id_marque = marque.id WHERE model LIKE '%"+demande+"'");
        rs = ps.executeQuery();
        return v;
    }
}
