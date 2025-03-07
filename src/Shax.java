import java.util.Random;

public class Shax extends Actor {
    private Random random = new Random();
    ActiveSkill gust = new ActiveSkill("Gust", 1, 56.7, 69.3, 1, 0, 0.8, 0.8, Scaling.intel, Element.wind,
            false, false);
    ActiveSkill compression = new ActiveSkill("Air Compression", 1, 91.35, 111.65, 1, 0, 1.2, 1.2, Scaling.intel,
            Element.wind,
            false, false);

    public Shax() {
        name = "Shax";
        skills.add(gust);
        skills.add(compression);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
//        strength = 1;
        this.hp_max = 19200 * strength;
        this.hp = this.hp_max;
        this.exp = 9200 * strength;
        this.atk = 1100 * strength;
        this.def = 600 * strength;
        this.intel = 1000 * strength;
        this.resist = 1100 * strength;
        this.hit = 1200 * strength;
        this.speed = 3500 * strength;
        this.wind = 100 * strength;
        this.earth_res = 0.5;
        this.wind_res = -0.5;
        this.counter_dodge = true;
        this.debuffs.clear();
        this.casting = null;
    }

    public ActiveSkill rollAttack() {
        double roll = this.random.nextDouble() * 100;
        return roll < 30 ? compression : gust;
    }

    @Override
    public ActiveSkill getCasting() {
        if (casting == null) {
            casting = rollAttack();
        }
        return casting;
    }
}
