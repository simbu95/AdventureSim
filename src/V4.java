import java.util.Random;

public class V4 extends Actor {
    private Random random = new Random();
    ActiveSkill shot = new ActiveSkill("Hard Love Shot", 1, 189, 231, 1.75, 0, 1.4, 1.4, Scaling.atkint, Element.physmagic,
            false, false);


    public V4() {
        name = "Valentine Hard";
        skills.add(shot);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 30000 * strength;
        this.hp = this.hp_max;
        this.exp = 14400 * strength;
        if (Main.game_version >= 1533) {
            this.exp *= 0.9;
        }
        this.atk = 600 * strength;
        this.def = 600 * strength;
        this.intel = 600 * strength;
        this.resist = 600 * strength;
        this.hit = 600 * strength;
        this.speed = 600 * strength;
        this.fire_res = 0.4;
        this.water_res = 0.4;
        this.earth_res = 0.4;
        this.dark_res = 0.4;
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
