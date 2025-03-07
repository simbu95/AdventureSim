import java.util.Random;

public class V5 extends Actor {
    private Random random = new Random();
    ActiveSkill shot = new ActiveSkill("Hard Love SHot", 1, 234, 286, 2, 0, 1.5, 1.5, Scaling.atkint, Element.physmagic,
            false, false);


    public V5() {
        name = "Valentine Hardcore";
        skills.add(shot);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 42000 * strength;
        this.hp = this.hp_max;
        this.exp = 20400 * strength;
        this.atk = 720 * strength;
        this.def = 840 * strength;
        this.intel = 720 * strength;
        this.resist = 840 * strength;
        this.hit = 840 * strength;
        this.speed = 1080 * strength;
        this.fire_res = 0.5;
        this.water_res = 0.5;
        this.earth_res = 0.5;
        this.dark_res = 0.5;
        this.wind_res = -0.2;
        this.debuffs.clear();
        this.casting = null;
    }

    @Override
    public ActiveSkill getCasting() {
        if (casting == null) {
            casting = shot;
        }
        return casting;
    }
}
