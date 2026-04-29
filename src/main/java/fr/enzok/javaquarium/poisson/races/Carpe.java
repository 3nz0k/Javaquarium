package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Carpe extends PoissonHerbivore {

    public Carpe(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Carpe(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Carpe";
    }

}
