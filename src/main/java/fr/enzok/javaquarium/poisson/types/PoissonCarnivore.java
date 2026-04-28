package fr.enzok.javaquarium.poisson.types;

import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.Carnivore;

abstract public class PoissonCarnivore extends Poisson implements Carnivore {

    public enum EnumCarnivore {
        Thon,
        Merou,
        Poisson_Clown
    }

    public PoissonCarnivore(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    @Override
    public void mangerPoisson(Poisson poisson) {
        this.incrementPV(5);
        poisson.decrementPV(4);
    }

}
