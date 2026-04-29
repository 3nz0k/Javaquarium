package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Bar extends PoissonHerbivore {

    public Bar(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Bar(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Bar";
    }
}
