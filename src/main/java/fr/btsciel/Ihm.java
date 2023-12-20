package fr.btsciel;

import java.sql.*;
import java.util.ArrayList;

public class Ihm {
    public static void main(String[] args) {
        int menu;
        String url;
        String user;
        String password;
//            sert a créer la connexion entre la base de donnée et le programme et a le remplir
        GestionVoiture gv = new GestionVoiture();;


//            sert de menu pour savoir ce que l'utilisateur veut faire avec la base de donnée.
        System.out.println("""
                que voulez vous faire avec la base de donnée.
                1| la trier par ordre croissant de nom de modele
                2| tri par ordre decroissant des nom de modele
                """);
        System.out.println();
    }
}
