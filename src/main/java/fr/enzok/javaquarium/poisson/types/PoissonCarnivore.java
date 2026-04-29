package fr.enzok.javaquarium.poisson.types;

import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.Carnivore;

abstract public class PoissonCarnivore extends Poisson implements Carnivore {

    public PoissonCarnivore(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public PoissonCarnivore(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public void mangerPoisson(Poisson poissonVictime) {
        if (this.getNom().equals(poissonVictime.getNom())) {
            System.out.println(Color.RED + this.getNom() + " ne peut pas se manger lui/elle même" + Color.RESET);
            return;
        }

        if (this.getRace().equals(poissonVictime.getRace())) {
            System.out.println(Color.RED + this.getNom() + " ne peut pas manger un autre poisson de son espèce" + Color.RESET);
            return;
        }
        this.incrementPV(5);
        poissonVictime.decrementPV(4);
        System.out.println(Color.YELLOW + this.getNom() + Color.RESET + " a maintenant " + Color.GREEN + this.getPV() + " PV " + Color.RESET + " car il/elle a mangé(e) " + Color.RED + poissonVictime.getNom() + Color.RESET);
        System.out.println(Color.YELLOW + poissonVictime.getNom() + Color.RESET + " a désormait " + poissonVictime.getPV() + " PV");
    }
}
