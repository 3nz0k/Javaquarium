package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Sole extends PoissonHerbivore {

    public Sole(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Sole(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Sole";
    }
}
