package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive{
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private String name;
    private double udderCapacity;
    private double milkVolume;


    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.milkVolume = 0;
        this.udderCapacity = 15 + new Random().nextInt(26);
    }
    public Cow(String name) {
        this.name = name;
        this.udderCapacity = 15 + new Random().nextInt(26);
        this.milkVolume = 0;
    }



    public String getName() {
        return name;
    }

    public double getCapacity() {
        return udderCapacity;
    }

    public double getAmount() {
        return milkVolume;
    }

    public String toString() {
        return this.name + " " + Math.ceil(milkVolume) + "/" + Math.ceil(udderCapacity);
    }

    @Override
    public void liveHour() {
        milkVolume += (0.7 + (Math.random() * 1.3));
        if (milkVolume > udderCapacity) {
            milkVolume = udderCapacity;
        }
    }

    @Override
    public double milk() {
        double milk = milkVolume;
        milkVolume = 0;
        return milk;
    }
}
