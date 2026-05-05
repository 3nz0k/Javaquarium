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

    public void afficherVieAge() {
        String tempVie = "█".repeat(this.pv);
        String tempAge = "█".repeat(this.age);

        System.out.printf(Color.GREEN + tempVie + " " + this.pv + " PV" + Color.RESET + " | ");

        if (this.age == 1) {
            System.out.printf(Color.BLUE + tempAge + " " + this.age + " an" + Color.RESET);
        } else {
            System.out.printf(Color.BLUE + tempAge + " " + this.age + " ans" + Color.RESET);
        }
        System.out.println();
    }
}
