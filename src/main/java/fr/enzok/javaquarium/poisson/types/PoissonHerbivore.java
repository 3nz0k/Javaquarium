package fr.enzok.javaquarium.poisson.types;

import fr.enzok.javaquarium.Algue;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.Herbivore;

abstract public class PoissonHerbivore extends Poisson implements Herbivore {

    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    @Override
    public void mangerAlgue(Algue algue) {
        algue.decrementPV(2);
        this.incrementPV(3);
    }
}
