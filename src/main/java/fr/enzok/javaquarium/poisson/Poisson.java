package fr.enzok.javaquarium.poisson;

import fr.enzok.javaquarium.EtreVivant;

abstract public class Poisson extends EtreVivant {

    private final String nom;
    private Sexe sexe;

    public enum Sexe {
        Male,
        Femelle
    }

    public Poisson(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
        super.setAge(0);
        super.setPV(10);
    }

    public Poisson(String nom, Sexe sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        super.setAge(age);
        super.setPV(10);
    }

    public String getNom() {
        return this.nom;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public abstract String getRace();

    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Sexe: " + this.sexe;
    }
}
