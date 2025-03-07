import java.util.Random;

public class V3 extends Actor {
    private Random random = new Random();
    ActiveSkill shot = new ActiveSkill("Love SHot", 1, 148.5, 181.5, 1.5, 0, 1.2, 1.2, Scaling.atkint, Element.physmagic,
            false, false);


    public V3() {
        name = "Valentine Normal";
        skills.add(shot);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 15000 * strength;
        this.hp = this.hp_max;
        this.exp = 2100 * strength;
        if (Main.game_version >= 1533) {
            this.exp *= 1.2;
        }
        this.atk = 375 * strength;
        this.def = 375 * strength;
        this.intel = 375 * strength;
        this.resist = 375 * strength;
        this.hit = 375 * strength;
        this.speed = 375 * strength;
        this.fire_res = 0.3;
        this.water_res = 0.3;
        this.earth_res = 0.3;
        this.dark_res = 0.3;
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
