public class Cleric extends Actor {
    protected boolean holylight_enabled;
    public Cleric(int ml, int cl) {
        name = "Cleric";
        setCLML(cl, ml);
        passives.put("Int Boost", intBoost);
        passives.put("Res Boost", resBoost);
        passives.put("Book Mastery", bookMastery);
        passives.put("Ailment Res", ailmentRes);
    }

    @Override
    public void setCLML(int cl, int ml) {
        this.cl = cl;
        this.ml = ml;
        base_hp_max = (double) (80 * (cl + 100)) / 10000 * 30 * ml;
        base_atk = (double) (70 * (cl + 100)) / 10000 * 4 * ml;
        base_def = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
        base_int = (double) (100 * (cl + 100)) / 10000 * 4 * ml;
        base_res = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
        base_hit = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
        base_speed = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
        refreshStats();
    }

    public void add_stats(double atk, double def, double intel, double resist, double hit, double speed,
                          double light) {
        add_stats(atk, def, intel, resist, hit, speed);
        gear_light += light;
    }

    public void setPassiveLvls(int intel, int res, int book, int ail_res) {
        this.intBoost.setLvl(intel);
        this.resBoost.setLvl(res);
        this.bookMastery.setLvl(book);
        this.ailmentRes.setLvl(ail_res);
    }

    public void add_holylight(){
        holylight_enabled = true;
    }

    @Override
    public double getLight() {
        double hlight = holylight_enabled ? getResist() * 0.25 : 0;
        return gear_light + hlight; //todo: find how it really works
        //return (atk + intel) * (fireBoost.enabled ? 0.5 + fireBoost.bonus : 0.5) + gear_fire + eblast;
    }
}
