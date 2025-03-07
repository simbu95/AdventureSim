import java.util.Random;

public class Lamia extends Actor {
    private Random random = new Random();
    ActiveSkill ball = new ActiveSkill("Fire Ball", 1, 69.3, 84.7, 1.35, 0, 1.15, 1, Scaling.intel, Element.fire,
            false, false);
    ActiveSkill pillar = new ActiveSkill("Fire Pillar", 1, 126, 154, 1, 0, 1.5, 1.5, Scaling.intel,
            Element.fire, false, false);
    ActiveSkill explosion = new ActiveSkill("Explosion", 1, 945, 1155, 1.15, 0, 8, 30, Scaling.intel, Element.fire, true, false);

    public Lamia() {
        name = "Lamia";
        skills.add(ball);
        skills.add(pillar);
        skills.add(explosion);
        ball.addDebuff("Burn", 3, 1);
        pillar.addDebuff("Burn", 3, 1);
        explosion.addDebuff("Burn", 3, 1);
        reroll();
    }

    @Override
    public void reroll() {
        double strength = (this.random.nextInt(21) + 90) / 100.0;
        this.hp_max = 48000 * strength;//16000
        this.hp = this.hp_max;
        this.exp = 14400 * strength;
        this.atk = 500 * strength;
        this.def = 1200 * strength;//2000
        this.intel = 1100 * strength;
        this.resist = 1100 * strength;//2000
        this.hit = 1200 * strength;
        this.speed = 500 * strength;
        this.fire = 400 * strength;
        this.earth_res = 0.5;
        this.wind_res = 0.5;
        this.debuffs.clear();
        this.casting = null;
    }

    public ActiveSkill rollAttack() {
        double roll = this.random.nextDouble() * 100;
        return roll < 50 ? ball : roll >= 50 && roll < 85 ? pillar : explosion;
    }

    @Override
    public ActiveSkill getCasting() {
        if (casting == null) {
            casting = rollAttack();
        }
        return casting;
    }
}
