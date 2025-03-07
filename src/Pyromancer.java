public class Pyromancer extends Actor {
    protected boolean eblast_enabled;
    public Pyromancer(int ml, int cl) {
        name = "Pyromancer";
        setCLML(cl, ml);
        fire_res = 0.5;
        water_res = -0.5;
        passives.put("Int Boost", intBoost);
        passives.put("Res Boost", resBoost);
        passives.put("Wand Mastery", wandMastery);
        passives.put("Casting Boost", castBoost);
        passives.put("Fire Boost", fireBoost);
        passives.put("Fire Resist", fireResist);
    }

    @Override
    public void setCLML(int cl, int ml) {
        this.cl = cl;
        this.ml = ml;
        base_hp_max = (double) (70 * (cl + 100)) / 10000 * 30 * ml;
        base_atk = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_def = (double) (70 * (cl + 100)) / 10000 * 4 * ml;
        base_int = (double) (180 * (cl + 100)) / 10000 * 4 * ml;
        base_res = (double) (120 * (cl + 100)) / 10000 * 4 * ml;
        base_hit = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
        base_speed = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
        refreshStats();
    }

    public void add_stats(double atk, double def, double intel, double resist, double hit, double speed,
                          double fire) {
        add_stats(atk, def, intel, resist, hit, speed);
        gear_fire += fire;
    }

    public void add_eleblast(){
        eblast_enabled = true;
    }

    public void setPassiveLvls(int intel, int res, int wand, int cast, int fire, int fire_res) {
        this.intBoost.setLvl(intel);
        this.resBoost.setLvl(res);
        this.wandMastery.setLvl(wand);
        this.castBoost.setLvl(cast);
        this.fireBoost.setLvl(fire);
        this.fireResist.setLvl(fire_res);
    }

    @Override
    public double getFire() {
        double eblast = eblast_enabled ? getIntel() * 0.05 : 0;
        return (getAtk() + getIntel()) * (fireBoost.enabled ? 0.5 + fireBoost.bonus : 0.5) + gear_fire + eblast;
    }

    @Override
    public double getWater() {
        double eblast = eblast_enabled ? getIntel() * 0.05 : 0;
        return (getAtk() + getIntel()) / -2 + gear_water + eblast;
    }

    @Override
    public double getWind() {
        double eblast = eblast_enabled ? getIntel() * 0.05 : 0;
        return gear_wind + eblast;
    }

    @Override
    public double getEarth() {
        double eblast = eblast_enabled ? getIntel() * 0.05 : 0;
        return gear_earth + eblast;
    }
}
