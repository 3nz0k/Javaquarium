package fr.enzok.javaquarium;

import java.util.Random;

import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.races.Bar;
import fr.enzok.javaquarium.poisson.races.Carpe;
import fr.enzok.javaquarium.poisson.races.Merou;
import fr.enzok.javaquarium.poisson.races.PoissonClown;
import fr.enzok.javaquarium.poisson.races.Sole;
import fr.enzok.javaquarium.poisson.races.Thon;
import fr.enzok.javaquarium.poisson.types.PoissonCarnivore;
import fr.enzok.javaquarium.poisson.types.PoissonHerbivore;

public class Application {

    public static void main(String[] args) {
        /* ~~~ [ INITIALISATION ] ~~~ */
 /* ~~~ [ AQUARIUM ] ~~~ */
        Aquarium aqua = new Aquarium();

        /* ~~~ [ POISSON ] ~~~ */
        Bar bar = new Bar("Jeff", Poisson.Sexe.Male);
        Carpe carpe = new Carpe("Patrick", Poisson.Sexe.Male);
        Merou merou = new Merou("Clothilde", Poisson.Sexe.Femelle);
        PoissonClown poissonClown = new PoissonClown("Nemo", Poisson.Sexe.Male);
        Sole sole = new Sole("Dory", Poisson.Sexe.Femelle);
        Thon thon = new Thon("Sandrine", Poisson.Sexe.Femelle);

        aqua.listePoissons.add(bar);
        aqua.listePoissons.add(carpe);
        aqua.listePoissons.add(merou);
        aqua.listePoissons.add(poissonClown);
        aqua.listePoissons.add(sole);
        aqua.listePoissons.add(thon);

        /* ~~~ [ ALGUE ] ~~~ */
        Algue algue1 = new Algue();
        Algue algue2 = new Algue();
        Algue algue3 = new Algue();

        aqua.listeAlgues.add(algue1);
        aqua.listeAlgues.add(algue2);
        aqua.listeAlgues.add(algue3);

        /* ~~~ [ RANDOM ] ~~~ */
        Random r = new Random();

        int nbreTour = 3;
        /* ~~~ [ BOUCLE DE JEU ] ~~~ */
        for (int i = 1; i < nbreTour + 1; i++) {
            System.out.println("TOUR " + i);

            for (int h = 0; h < aqua.listePoissons.size(); h++) {

                /* ~~~ [ VALEURS RANDOM ] ~~~ */
                int randomPoissonValue = r.nextInt(aqua.listePoissons.size());
                int randomAlgueValue = r.nextInt(aqua.listeAlgues.size());

                /* ~~~ [ INITIALISATION ] ~~~ */
                Poisson poissonQuiMange = aqua.listePoissons.get(h);
                Poisson poissonMouru = aqua.listePoissons.get(randomPoissonValue);
                Algue randomAlgue = aqua.listeAlgues.get(randomAlgueValue);

                if (poissonQuiMange instanceof PoissonCarnivore poissonCarnivoreQuiMange) {
                    if (!poissonCarnivoreQuiMange.getNom().equals(poissonMouru.getNom())) {
                        System.out.println(poissonCarnivoreQuiMange.getNom() + " a mangé : " + poissonMouru.getNom());
                        poissonCarnivoreQuiMange.mangerPoisson(poissonMouru);
                    } else {
                        System.out.println("Le poisson : " + poissonCarnivoreQuiMange.getNom() + "ne peut pas se manger lui même");
                    }

                } else if (poissonQuiMange instanceof PoissonHerbivore poissonHerbivoreQuiMange) {
                    System.out.println(poissonHerbivoreQuiMange.getNom() + " a mangé une algue");
                    poissonHerbivoreQuiMange.mangerAlgue(randomAlgue);
                }
            }

            /* ~~~ [ CALCUL DES MORTS ] ~~~ */
            for (int j = 0; j < aqua.listePoissons.size(); j++) {
                Poisson tempPoisson = aqua.listePoissons.get(j);
                if (tempPoisson.getPV() <= 0) {
                    System.out.println("Le poisson : " + tempPoisson.getNom() + " est malheuresement mort");
                } else {
                    System.out.println("Le poisson : " + tempPoisson.getNom() + " a : " + tempPoisson.getPV() + " PV");
                }
            }

            for (int j = 0; j < aqua.listeAlgues.size(); j++) {
                Algue tempAlgue = aqua.listeAlgues.get(j);
                if (tempAlgue.getPV() <= 0) {
                    System.out.println("Une algue est malheuresement morte");
                } else {
                    System.out.println("L'algue a : " + tempAlgue.getPV() + " PV");
                }

            }
        }
    }
}
