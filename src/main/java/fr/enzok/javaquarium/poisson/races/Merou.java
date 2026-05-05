package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.HermaphroditeAge;
import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;

public class Merou extends PoissonCarnivore implements HermaphroditeAge {

    public Merou(String nom, Sexe sexe) {
        super(nom, sexe);
    }

    public Merou(String nom, Sexe sexe, int age) {
        super(nom, sexe, age);
    }

    @Override
    public String getRace() {
        return "Merou";
    }

    @Override
    public void hermaphroditeAvecAge() {
        if (this.getSexe() == Poisson.Sexe.Male) {
            this.setSexe(Poisson.Sexe.Femelle);
        } else {
            this.setSexe(Poisson.Sexe.Male);
        }
        System.out.println(Color.YELLOW + this.getNom() + " est devenu : " + this.getSexe() + Color.RESET);
    }
}
