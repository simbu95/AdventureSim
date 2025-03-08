package Disilon;

public class Buff {
    public int duration;
    public double effect;
    public String name;

    public Buff(String name, int duration, double effect) {
        this.name = name;
        this.duration = duration;
        this.effect = effect;
    }
}
