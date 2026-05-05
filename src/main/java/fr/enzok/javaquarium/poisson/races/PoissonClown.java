package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.HermaphroditeOpportuniste;
import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;

public class PoissonClown extends PoissonCarnivore implements HermaphroditeOpportuniste {

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
