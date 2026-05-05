package fr.enzok.javaquarium;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

public class Aquarium implements Serializable {

    List<Poisson> listePoissons = new ArrayList<>();
    List<Algue> listeAlgues = new ArrayList<>();

    public Aquarium() {
    }

    public void sauvegarder(String fichier) {
        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(fichier))) {

            oos.writeObject(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ~~~ [ AGE / PV POISSON ] ~~~ */
    public void checkAgePoisson(List<Poisson> listePoissons) {
        for (int j = listePoissons.size() - 1; j >= 0; j--) {
            Poisson poissonTemp = listePoissons.get(j);

            poissonTemp.decrementPV(2);
            poissonTemp.incrementAge();

            if (poissonTemp.getAge() < 20) {
                if (poissonTemp.getPV() > 0) {
                    System.out.println(poissonTemp.getNom() + " :");
                    poissonTemp.afficherVieAge();
                    if (poissonTemp.getAge() == 10) {
                        switch (poissonTemp) {
                            case Bar barHerma ->
                                barHerma.hermaphroditeAvecAge();
                            case Merou merouHerma ->
                                merouHerma.hermaphroditeAvecAge();
                            default -> {
                            }
                        }
                    }
                } else {
                    System.out.println(poissonTemp.getNom() + " est mort(e) de faim");
                    listePoissons.remove(j);
                }
            } else {
                if (poissonTemp.getSexe() == Poisson.Sexe.Male) {
                    System.out.println(poissonTemp.getNom() + " est mort de vieillesse");
                } else {
                    System.out.println(poissonTemp.getNom() + " est morte de vieillesse");
                }
                listePoissons.remove(j);
            }
        }
        System.out.println();
    }

    /* ~~~ [ AGE / PV ALGUE] ~~~ */
    public void checkAgeAlgue(List<Algue> listeAlgues) {
        for (int j = listeAlgues.size() - 1; j >= 0; j--) {
            Algue algueTemp = listeAlgues.get(j);
            algueTemp.incrementPV(1);
            algueTemp.incrementAge();

            if (algueTemp.getAge() < 20) {
                System.out.printf("Algue | ");
                algueTemp.afficherVieAge();
            } else {
                System.out.println("Une algue est malheuresement morte de viellesse.");
                listeAlgues.remove(algueTemp);
            }

            /* ~~~ [ NAISSANCE ALGUE ] ~~~ */
            if (algueTemp.getPV() >= 10) {
                Algue newAlgue = new Algue();
                naissanceAlgue(algueTemp, newAlgue);
                listeAlgues.add(newAlgue);
            }
        }
        System.out.println();
    }

    /* ~~~ [ NAISSANCE POISSON ] ~~~ */
    public void naissancePoisson(Poisson poissonPredateur, Poisson poissonVictime, int numero) {

        Random r = new Random();
        if (poissonPredateur.getClass() == poissonVictime.getClass()) {
            if (poissonPredateur instanceof Sole sole && poissonPredateur.getSexe() == poissonVictime.getSexe()) {
                sole.hermaphroditeAvecOpportunite(poissonVictime);
            } else if (poissonPredateur instanceof PoissonClown poissonClown && poissonPredateur.getSexe() == poissonVictime.getSexe()) {
                poissonClown.hermaphroditeAvecOpportunite(poissonVictime);
            }

            if (poissonPredateur.getSexe() != poissonVictime.getSexe()) {

                System.out.println(poissonPredateur.getNom() + " est de même race que : " + poissonVictime.getNom() + " et sont de sexes opposés !");

                /* ~~~ [ SEXE DU BEBE RANDOM ] ~~~ */
                int randomSexe = r.nextInt(2);
                Poisson.Sexe sexeBebe;

                if (randomSexe == 0) {
                    sexeBebe = Poisson.Sexe.Male;
                } else {
                    sexeBebe = Poisson.Sexe.Femelle;
                }

                switch (poissonPredateur) {
                    case Bar b -> {
                        listePoissons.add(new Bar("Bébé " + b.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + b.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    case Carpe c -> {
                        listePoissons.add(new Carpe("Bébé " + c.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + c.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    case Merou m -> {
                        listePoissons.add(new Merou("Bébé " + m.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + m.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    case PoissonClown pc -> {
                        listePoissons.add(new PoissonClown("Bébé " + pc.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + pc.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    case Sole s -> {
                        listePoissons.add(new Sole("Bébé " + s.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + s.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    case Thon t -> {
                        listePoissons.add(new Thon("Bébé " + t.getRace() + " " + numero, sexeBebe));
                        System.out.println(Color.PURPLE + "Le bébé de " + t.getNom() + " vient de naitre !" + Color.RESET);
                    }
                    default ->
                        throw new IllegalStateException("Unexpected value: " + poissonPredateur);
                }
            }
        }
    }

    /* ~~~ [ NAISSANCE ALGUE ] ~~~ */
    public void naissanceAlgue(Algue algueMere, Algue nouvelleAlgue) {
        int newPV = algueMere.getPV() / 2;
        algueMere.setPV(newPV);
        nouvelleAlgue.setPV(newPV);
        System.out.println(Color.BLUE + Color.BOLD_ON + "Une algue vient de naitre !" + Color.RESET);
    }

    public void chasser(List<Poisson> listePoissons, List<Algue> listeAlgues) {
        Random r = new Random();
        int randomAlgueValue;
        Algue randomAlgue;
        Poisson poissonPredateur, poissonVictime;

        for (int j = listePoissons.size() - 1; j >= 0; j--) {

            /* ~~~ [ RANDOM POISSONS MIAM ] ~~~ */
            poissonPredateur = listePoissons.get(j);
            poissonVictime = listePoissons.get(r.nextInt(listePoissons.size()));

            if (poissonPredateur.getPV() > 5) {
                System.out.println(Color.GREEN + poissonPredateur.getNom() + " a trop de vie pour manger" + Color.RESET);
                naissancePoisson(poissonPredateur, poissonVictime, j);
                continue;
            }

            if (poissonPredateur instanceof PoissonCarnivore poissonPredateurCarnivore) {
                poissonPredateurCarnivore.mangerPoisson(poissonVictime);

                /* ~~~ [ POISSONS MOURU ? ] ~~~ */
                if (poissonVictime.getPV() <= 0) {
                    System.out.println(Color.RED + poissonVictime.getNom() + Color.RESET + " a été tué(e) par " + Color.YELLOW + poissonPredateur.getNom() + Color.RESET);
                    listePoissons.remove(poissonVictime);
                }
            } else if (poissonPredateur instanceof PoissonHerbivore poissonPredateurHerbivore) {
                /* ~~~ [ CHECK LISTE ALGUE ] ~~~ */
                if (listeAlgues.isEmpty()) {
                    System.out.println(Color.ERROR + "Toutes les algues sont mortes" + Color.RESET);
                    return;
                }

                /* ~~~ [ RANDOM ALGUES MIAM ] ~~~ */
                randomAlgueValue = r.nextInt(listeAlgues.size());
                randomAlgue = listeAlgues.get(randomAlgueValue);

                poissonPredateurHerbivore.mangerAlgue(randomAlgue);

                if (randomAlgue.getPV() <= 0) {
                    System.out.println(Color.ERROR + "Une algue est malheuresement morte" + Color.RESET);
                    listeAlgues.remove(randomAlgue);
                }
            }
        }
        System.out.println();
    }
}
