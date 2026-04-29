package fr.enzok.javaquarium;

public class Algue extends EtreVivant {

    public Algue() {
        super.setAge(0);
        super.setPV(10);
    }

    @Override
    public String toString() {
        return "Algue";
    }
}
