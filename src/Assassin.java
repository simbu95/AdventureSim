public class Assassin extends Actor {
    public Assassin(int ml, int cl) {
        name = "Assassin";
        setCLML(cl, ml);
        dark_res = 0.5;
        light_res = -0.5;
        passives.put("Attack Boost", attackBoost);
        passives.put("Drop Boost", dropBoost);
        passives.put("Dagger Mastery", daggerMastery);
        passives.put("Stealth", stealth);
        passives.put("Speed Boost", speedBoost);
        passives.put("Poison Boost", poisonBoost);
        passives.put("Defense Boost", defenseBoost);
        passives.put("Dodge", dodge);
    }

    @Override
    public void setCLML(int cl, int ml) {
        this.cl = cl;
        this.ml = ml;
        base_hp_max = (double) (90 * (cl + 100)) / 10000 * 30 * ml;
        base_atk = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
        base_def = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_int = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
        base_res = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_hit = (double) (100 * (cl + 100)) / 10000 * 4 * ml;
        base_speed = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
        refreshStats();
    }

    public void add_stats(double atk, double def, double intel, double resist, double hit, double speed,
                          double dark) {
        add_stats(atk, def, intel, resist, hit, speed);
        gear_dark += dark;
    }

    public void setPassiveLvls(int atk, int dagger, int speed, int drop, int stealth, int poison, int def, int dodge) {
        this.attackBoost.setLvl(atk);
        this.daggerMastery.setLvl(dagger);
        this.speedBoost.setLvl(speed);
        this.dropBoost.setLvl(drop);
        this.stealth.setLvl(stealth);
        this.poisonBoost.setLvl(poison);
        this.defenseBoost.setLvl(def);
        this.dodge.setLvl(dodge);
    }

    @Override
    public double getDark() {
        return (atk + intel) / 2 + gear_dark;
    }

    @Override
    public double getLight() {
        return (atk + intel) / -2 + gear_light;
    }
}
