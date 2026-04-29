package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;

public class Merou extends PoissonCarnivore {

    public Merou(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Merou(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Merou";
    }
}
