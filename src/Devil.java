import java.util.Random;

public class Devil extends Actor {
    private Random random = new Random();
    ActiveSkill slash = new ActiveSkill("Dark Slash", 1, 135, 165, 1, 0, 0.9, 0.9, Scaling.atk, Element.dark,
            false, false);
    ActiveSkill poison = new ActiveSkill("Poison Attack", 1, 36, 44, 1, 0, 0.4, 0.9, Scaling.atk, Element.phys,
            false, false);

    public Devil() {
        name = "Devil";
        skills.add(poison);
        poison.addDebuff("Poison", 3, 0.1);
        skills.add(slash);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 10350 * strength;
        this.hp = this.hp_max;
        this.exp = 2430 * strength;
        this.atk = 900 * strength;
        this.def = 495 * strength;
        this.intel = 630 * strength;
        this.resist = 270 * strength;
        this.hit = 1080 * strength;
        this.speed = 225 * strength;
        this.dark = 180 * strength;
        this.dark_res = 0.5;
        this.light_res = -0.5;
        this.debuffs.clear();
        this.casting = null;
    }

    public ActiveSkill rollAttack() {
        double roll = this.random.nextDouble() * 100;
        return roll < 70 ? slash : poison; //Chances to select skills were calculated empirically
    }

    @Override
    public ActiveSkill getCasting() {
        if (casting == null) {
            casting = rollAttack();
        }
        return casting;
    }
}
