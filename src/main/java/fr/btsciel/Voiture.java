package fr.btsciel;

public class Voiture {
    private int id;
    private String modele;
    private Marque marque;
    private int nb_vente;

    public Voiture(int id, String modele, Marque marque, int nb_vente) {
        this.id = id;
        this.modele = modele;
        this.marque = marque;
        this.nb_vente = nb_vente;
    }

    public Voiture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public int getNb_vente() {
        return nb_vente;
    }

    public void setNb_vente(int nb_vente) {
        this.nb_vente = nb_vente;
    }
}
