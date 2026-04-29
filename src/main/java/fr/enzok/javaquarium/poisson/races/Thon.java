package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;

public class Thon extends PoissonCarnivore {

    public Thon(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Thon(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Thon";
    }
}
