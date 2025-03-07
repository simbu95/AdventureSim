public class Sniper extends Actor{
    public Sniper(int ml, int cl) {
        name = "Sniper";
        setCLML(cl, ml);
        this.wind_res = 0.5;
        this.fire_res = -0.5;
        passives.put("Attack Boost", attackBoost);
        passives.put("Drop Boost", dropBoost);
        passives.put("Bow Mastery", bowMastery);
        passives.put("Speed Boost", speedBoost);
        passives.put("Defense Boost", defenseBoost);
        passives.put("Ambush", ambush);
        passives.put("HP Regen", hpRegen);
        passives.put("Concentration", concentration);
        passives.put("Hit Boost", hitBoost);
    }

    @Override
    public void setCLML(int cl, int ml) {
        this.cl = cl;
        this.ml = ml;
        base_hp_max = (double) (90 * (cl + 100)) / 10000 * 30 * ml;
        base_atk = (double) (150 * (cl + 100)) / 10000 * 4 * ml;
        base_def = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_int = (double) (60 * (cl + 100)) / 10000 * 4 * ml;
        base_res = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_hit = (double) (160 * (cl + 100)) / 10000 * 4 * ml;
        base_speed = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        refreshStats();
    }

    public void setPassiveLvls(int atk, int bow, int speed, int drop, int concentration, int ambush, int def,
                               int hpregen, int hit) {
        this.attackBoost.setLvl(atk);
        this.bowMastery.setLvl(bow);
        this.speedBoost.setLvl(speed);
        this.dropBoost.setLvl(drop);
        this.concentration.setLvl(concentration);
        this.ambush.setLvl(ambush);
        this.defenseBoost.setLvl(def);
        this.hpRegen.setLvl(hpregen);
        this.hitBoost.setLvl(hit);
    }

    public void add_stats(double atk, double def, double intel, double resist, double hit, double speed,
                          double wind) {
        add_stats(atk, def, intel, resist, hit, speed);
        gear_wind = wind;
    }

    @Override
    public double getWind() {
        return (atk + intel) / 2 + gear_wind;
    }

    @Override
    public double getLight() {
        return (atk + intel) / -2 + gear_light;
    }
}
