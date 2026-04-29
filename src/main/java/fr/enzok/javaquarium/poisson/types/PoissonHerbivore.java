package fr.enzok.javaquarium.poisson.types;

import fr.enzok.javaquarium.Algue;
import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.Herbivore;

abstract public class PoissonHerbivore extends Poisson implements Herbivore {

    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public PoissonHerbivore(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public void mangerAlgue(Algue algue) {
        algue.decrementPV(2);
        this.incrementPV(3);
        System.out.println(Color.YELLOW + this.getNom() + Color.RESET + " a maintenant " + Color.GREEN + this.getPV() + " PV" + Color.RESET + " car il/elle a mangé(e) une algue");
        System.out.println("L'algue a désormait " + Color.RESET + algue.getPV() + " PV" + Color.RESET);
    }
}
