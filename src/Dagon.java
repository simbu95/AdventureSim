import java.util.Random;

public class Dagon extends Actor {
    private Random random = new Random();
    ActiveSkill waterpunch = new ActiveSkill("Water Punch", 1, 99, 121, 1, 0, 0.9, 0.9, Scaling.atkint, Element.water,
            false, false);
    ActiveSkill killingstrike = new ActiveSkill("Killing Strike", 1, 207.9, 254.1, 0.7, 0, 2, 2, Scaling.atk,
            Element.dark, false, false);
    ActiveSkill tsunami = new ActiveSkill("Tsunami", 1, 252, 308, 1, 0, 4, 6, Scaling.intel, Element.water, true, false);

    public Dagon() {
        name = "Dagon";
        skills.add(waterpunch);
        skills.add(killingstrike);
        skills.add(tsunami);
        tsunami.addDebuff("Poison", 3, 0.1);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 16000 * strength;//16000
        this.hp = this.hp_max;
        this.exp = 13200 * strength;
        this.atk = 1100 * strength;
        this.def = 2000 * strength;//2000
        this.intel = 1000 * strength;
        this.resist = 2000 * strength;//2000
        this.hit = 400 * strength;
        this.speed = 600 * strength;
        this.water = 400 * strength;
        this.fire_res = 0.5;
        this.wind_res = 0.5;
        this.debuffs.clear();
        this.casting = null;
    }

    public ActiveSkill rollAttack() {
        double roll = this.random.nextDouble() * 100;
        return roll < 50 ? waterpunch : roll >= 50 && roll < 80 ? killingstrike : tsunami;
    }

    @Override
    public ActiveSkill getCasting() {
        if (casting == null) {
            casting = rollAttack();
        }
        return casting;
    }
}
