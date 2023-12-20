package fr.btsciel;

import clavier.In;

import java.sql.*;
import java.util.ArrayList;

public class Ihm {
    public static void main(String[] args) {
        int menu;
        String url;
        String user;
        String password;
        GestionVoiture gv = new GestionVoiture();
        ArrayList<Voiture> v = new ArrayList<>();

//            sert a créer la connexion entre la base de donnée et le programme et a le remplir
        System.out.println("quel est l'url de connexion de la base de donnée ? ");
        url = In.readString();
        System.out.println("quel est le nom du user ? ");
        user = In.readString();
        System.out.println(" quel est le password du user ? ");
        password = In.readString();

        try {
            gv.BeginConnection(url, user, password);
            gv.FillList(v);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


//            sert de menu pour savoir ce que l'utilisateur veut faire avec la base de donnée.
        System.out.println("""
                que voulez vous faire avec la base de donnée.
                1| lister par nombre de voiture vendu
                2| afficher les voiture d'une marque précise
                3| afficher la somme des nombre de ventes des voitures d'une marque précise
                4| afficher les voiture dont le modele commence par une lettre donnée
                5| afficher le nombre d'enregistrement de la base de donnée
                6| afficher la somme de tout les voiture vendue
                7| afficher les voiture dont le modele contient une lettre donnée
                8| afficher les modele de voiture qui ont pour deuxième lettre, une lettre donnée
                9| afficher tout les modeles ce terminant par une lettre donnée
                """);
        menu = In.readInteger();
        switch(menu) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
    }
}
