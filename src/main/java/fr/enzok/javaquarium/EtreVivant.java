package fr.enzok.javaquarium;

abstract public class EtreVivant {

    private int pv;
    private int age;
    private int maxPV;

    public int getPV() {
        return pv;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    public int getMaxPV() {
        return maxPV;
    }

    public void setMaxPV(int maxPV) {
        this.maxPV = maxPV;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void afficherVie() {
        String temp = "";
        for (int i = 0; i < this.pv; i++) {
            temp += "█";
        }
        System.out.println(Color.GREEN + temp + " PV" + Color.RESET);
    }

    public void afficherAge() {
        String temp = "";
        for (int i = 0; i < this.age; i++) {
            temp += "█";
        }
        if (this.age == 1) {
            System.out.println(Color.BLUE + temp + " an" + Color.RESET);
        } else {
            System.out.println(Color.BLUE + temp + " ans" + Color.RESET);
        }
    }

}
