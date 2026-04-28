package fr.enzok.javaquarium.poisson;

import fr.enzok.javaquarium.EtreVivant;

abstract public class Poisson extends EtreVivant {

    private String nom;
    private Sexe sexe;

    public enum Sexe {
        Male,
        Femelle
    }

    public Poisson(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
    }

    public String getNom() {
        return this.nom;
    }

    public Sexe getSexe() {
        return this.sexe;
    }

    @Override
    public String toString() {
        return "Nom: " + this.nom + ", Sexe: " + this.sexe;
    }
}
