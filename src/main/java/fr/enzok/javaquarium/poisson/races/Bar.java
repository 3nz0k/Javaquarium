package fr.enzok.javaquarium.poisson.races;

import fr.enzok.javaquarium.Color;
import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.interfaces.HermaphroditeAge;
import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Bar extends PoissonHerbivore implements HermaphroditeAge {

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

    @Override
    public void hermaphroditeAvecAge() {
        if (this.getSexe() == Poisson.Sexe.Male) {
            this.setSexe(Poisson.Sexe.Femelle);
            System.out.println(Color.YELLOW + this.getNom() + " est devenu une femelle" + Color.RESET);
        } else {
            this.setSexe(Poisson.Sexe.Male);
            System.out.println(Color.YELLOW + this.getNom() + " est devenu un male" + Color.RESET);
        }
    }
}
