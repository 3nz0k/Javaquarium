package fr.enzok.javaquarium;

import fr.enzok.javaquarium.poisson.Poisson;
import fr.enzok.javaquarium.poisson.races.Bar;
import fr.enzok.javaquarium.poisson.races.Carpe;
import fr.enzok.javaquarium.poisson.races.Merou;
import fr.enzok.javaquarium.poisson.races.PoissonClown;
import fr.enzok.javaquarium.poisson.races.Sole;
import fr.enzok.javaquarium.poisson.races.Thon;

public class Application {

    public static void main(String[] args) {
        /* ~~~ [ INITIALISATION VARIABLES ] ~~~ */
        int nbreAlgues = 3;
        int nbreTour = 21;

        /* ~~~ [ AQUARIUM ] ~~~ */
        Aquarium aqua = new Aquarium();

        /* ~~~ [ POISSON ] ~~~ */
        aqua.listePoissons.add(new Bar("Jeff", Poisson.Sexe.Male));
        aqua.listePoissons.add(new Bar("Jeffette", Poisson.Sexe.Femelle));

        aqua.listePoissons.add(new Carpe("Patrick", Poisson.Sexe.Male));
        aqua.listePoissons.add(new Carpe("Patrickette", Poisson.Sexe.Femelle));

        aqua.listePoissons.add(new Merou("Clothilde", Poisson.Sexe.Male));
        aqua.listePoissons.add(new Merou("Clothildette", Poisson.Sexe.Femelle));

        aqua.listePoissons.add(new PoissonClown("Nemo", Poisson.Sexe.Male));
        aqua.listePoissons.add(new PoissonClown("Nemette", Poisson.Sexe.Femelle));

        aqua.listePoissons.add(new Sole("Dory", Poisson.Sexe.Male));
        aqua.listePoissons.add(new Sole("Doryette", Poisson.Sexe.Femelle));

        aqua.listePoissons.add(new Thon("Sandrine", Poisson.Sexe.Male));
        aqua.listePoissons.add(new Thon("Sandrinette", Poisson.Sexe.Femelle));

        /* ~~~ [ ALGUE ] ~~~ */
        for (int i = 0; i < nbreAlgues; i++) {
            aqua.listeAlgues.add(new Algue());
        }

        /* ~~~ [ BOUCLE DE JEU ] ~~~ */
        for (int i = 1; i < nbreTour + 1; i++) {
            System.out.println(Color.BACKGROUND_NEBULA + Color.BOLD_ON + "==== TOUR " + i + " ====" + Color.RESET);

            /* ~~~ [ CHECK LISTE POISSON ] ~~~ */
            if (aqua.listePoissons.isEmpty()) {
                System.out.println(Color.ERROR + "Tous les poissons sont morts" + Color.RESET);
                break;
            }

            aqua.checkAgePoisson(aqua.listePoissons);
            aqua.checkAgeAlgue(aqua.listeAlgues);
            aqua.chasser(aqua.listePoissons, aqua.listeAlgues);
        }
    }
}
