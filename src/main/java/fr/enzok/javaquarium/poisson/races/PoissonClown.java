package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;

public class PoissonClown extends PoissonCarnivore {

    public PoissonClown(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public PoissonClown(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "PoissonClown";
    }
}
