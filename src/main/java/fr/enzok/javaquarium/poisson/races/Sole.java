package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.HermaphroditeOpportuniste;
import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Sole extends PoissonHerbivore implements HermaphroditeOpportuniste {

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

    @Override
    public void hermaphroditeAvecOpportunite(Poisson poissonPartenaire) {
        if (this.getSexe() == poissonPartenaire.getSexe()) {
            if (this.getSexe() == Poisson.Sexe.Male) {
                this.setSexe(Poisson.Sexe.Femelle);
            } else {
                this.setSexe(Poisson.Sexe.Male);
            }
            System.out.println(Color.YELLOW + this.getNom() + " deviens opportuniste et change de sexe. Il devient dorénavant : " + this.getSexe() + Color.RESET);
        }
    }
}
