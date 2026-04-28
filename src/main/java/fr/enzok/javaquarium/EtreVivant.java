package fr.enzok.javaquarium;

abstract public class EtreVivant {

    private int pv = 10;
    protected int age;

    public int getPV() {
        return pv;
    }

    public void incrementAge() {
        this.age++;
    }

    public void incrementPV(int pv) {
        this.pv += pv;
    }

    public void decrementPV(int pv) {
        this.pv -= pv;
    }
}
