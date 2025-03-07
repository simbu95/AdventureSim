import java.util.Set;

public class Player extends Actor {
    ActiveSkill hide = new ActiveSkill("Hide", 1, 0, 0, 0, 5, 0.5, 0.5, Scaling.atk, Element.none, false, false);
    ActiveSkill ks = new ActiveSkill("Killing Strike", 1, 297, 363, 0.7, 80, 2, 2, Scaling.atk, Element.dark,
            false, false);
    ActiveSkill dp = new ActiveSkill("Dragon Punch", 3, 76.5, 93.5, 0.8, 20, 1, 3, Scaling.atk, Element.phys,
            false, false);
    ActiveSkill pa = new ActiveSkill("Poison Attack", 1, 36, 44, 1, 4, 0.4, 0.9, Scaling.atk, Element.phys, false
            , false);
    ActiveSkill smoke = new ActiveSkill("Smoke Screen", 1, 0, 0, 0.85, 25, 0.8, 1, Scaling.atk, Element.none, true, false);
    ActiveSkill fa = new ActiveSkill("First Aid", 1, 15, 15, 0, 5, 0.9, 1.1, Scaling.atk, Element.none, false,
            true);
    ActiveSkill ss = new ActiveSkill("Sharp Shooting", 1, 207, 253, 1.5, 80, 2, 3, Scaling.atkhit, Element.wind,
            false,
            false);
    ActiveSkill ar = new ActiveSkill("Arrow Rain", 5, 49.5, 60.5, 0.7, 20, 1.5, 1.5,
            Scaling.atkhit, Element.phys,
            false,
            false);
    ActiveSkill ar1535 = new ActiveSkill("Arrow Rain", 5, 49.5, 60.5, 0.7, 25, 1.5,
            1.5,
            Scaling.atkhit, Element.phys,
            false,
            false);
    ActiveSkill db = new ActiveSkill("Defense Break", 1, 90, 110, 1, 10, 1, 1, Scaling.atk, Element.phys, false,
            false);
    ActiveSkill mark = new ActiveSkill("Mark Target", 1, 0, 0, 1.5, 10, 0.5, 0.5, Scaling.atk, Element.none,
            false,
            false);
    ActiveSkill charge = new ActiveSkill("Charge Up", 1, 0, 0, 0, 50, 2, 2, Scaling.atk, Element.none, false,
            false);
    ActiveSkill fball = new ActiveSkill("Fire Ball", 1, 99, 121, 1.35, 20, 1.15, 1, Scaling.intel, Element.fire,
            false, false);
    ActiveSkill fpillar = new ActiveSkill("Fire Pillar", 1, 180, 220, 1.0, 36, 1.5,
            1.5,
            Scaling.intel,
            Element.fire, false, false);
    ActiveSkill fpillar1537 = new ActiveSkill("Fire Pillar", 1, 180, 220, 1.0, 50, 1.5,
            1.5,
            Scaling.intel,
            Element.fire, false, false);
    ActiveSkill explosion = new ActiveSkill("Explosion", 1, 1350, 1650, 1.15, 500, 8, 30, Scaling.intel,
            Element.fire, true, false);
    ActiveSkill eblast = new ActiveSkill("Elemental Blast", 1, 117, 143, 1.0, 20, 1.2, 1.2, Scaling.intel,
            Element.magic, false, false);
    ActiveSkill hlight = new ActiveSkill("Holy Light", 1, 112.5, 137.5, 1.0, 25, 1, 1.1, Scaling.resint,
            Element.light, false, false);
    ActiveSkill heal = new ActiveSkill("Heal", 1, 250, 45, 0, 30, 0.8, 1.5, Scaling.atk, Element.none, false,
            true);
    ActiveSkill bless = new ActiveSkill("Bless", 1, 0, 0, 0, 40, 0.5, 0.5, Scaling.atk, Element.none, false,
            false);
    ActiveSkill push = new ActiveSkill("Push Blast", 1, 99, 121, 0.9, 30, 1.3, 1.3, Scaling.intel,
            Element.magic, true, false);

    protected boolean holylight_enabled;
    protected boolean eblast_enabled;

    public Player(String name, int ml, int cl) {
        this.name = name;
        setCLML(cl, ml);
        pa.addDebuff("Poison", 3, 0.1);
        smoke.addDebuff("Smoke", 3, 0);
        db.addDebuff("Defense Break", 3, 0.25);
        mark.addDebuff("Mark", 1, 0.2);
        charge.addBuff("Charge Up", 1, 1.5);
        fball.addDebuff("Burn", 3, 1);
        fpillar.addDebuff("Burn", 3, 1);
        fpillar1537.addDebuff("Burn", 3, 1);
        explosion.addDebuff("Burn", 3, 1);
        bless.addBuff("Bless", 2, 0.3);
        switch (name) {
            case "Assassin" -> {
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
            case "Pyromancer" -> {
                fire_res = 0.5;
                water_res = -0.5;
                passives.put("Int Boost", intBoost);
                passives.put("Res Boost", resBoost);
                passives.put("Wand Mastery", wandMastery);
                passives.put("Casting Boost", castBoost);
                passives.put("Fire Boost", fireBoost);
                passives.put("Fire Resist", fireResist);
            }
            case "Sniper" -> {
                wind_res = 0.5;
                fire_res = -0.5;
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
            case "Cleric" -> {
                passives.put("Int Boost", intBoost);
                passives.put("Res Boost", resBoost);
                passives.put("Book Mastery", bookMastery);
                passives.put("Ailment Res", ailmentRes);
            }
        }
    }

    public ActiveSkill getSkill(String name) {
        switch (name) {
            case "Heal" -> {
                return heal;
            }
            case "Bless" -> {
                return bless;
            }
            case "Push Blast" -> {
                return push;
            }
            case "Elemental Blast" -> {
                return eblast;
            }
            case "Holy Light" -> {
                return hlight;
            }
            case "Fireball" -> {
                return fball;
            }
            case "Fire Pillar" -> {
                if (Main.game_version >= 1537) {
                    return fpillar1537;
                } else {
                    return fpillar;
                }
            }
            case "Explosion" -> {
                return explosion;
            }
            case "Smoke Screen" -> {
                return smoke;
            }
            case "Mark" -> {
                return mark;
            }
            case "Charge Up" -> {
                return charge;
            }
            case "Poison Attack" -> {
                return pa;
            }
            case "Defense Break" -> {
                return db;
            }
            case "Arrow Rain" -> {
                if (Main.game_version >= 1535) {
                    return ar1535;
                } else {
                    return ar;
                }
            }
            case "Sharpshooter" -> {
                return ss;
            }
            case "Dragon Punch" -> {
                return dp;
            }
            case "Hide" -> {
                return hide;
            }
            case "Killing Strike" -> {
                return ks;
            }
            case "First Aid" -> {
                return fa;
            }
        }
        return null;
    }

    @Override
    public void setCLML(int cl, int ml) {
        this.cl = cl;
        this.ml = ml;
        switch (name) {
            case "Assassin" -> {
                base_hp_max = (double) (90 * (cl + 100)) / 10000 * 30 * ml;
                base_atk = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
                base_def = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_int = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
                base_res = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_hit = (double) (100 * (cl + 100)) / 10000 * 4 * ml;
                base_speed = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
            }
            case "Pyromancer" -> {
                base_hp_max = (double) (70 * (cl + 100)) / 10000 * 30 * ml;
                base_atk = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_def = (double) (70 * (cl + 100)) / 10000 * 4 * ml;
                base_int = (double) (180 * (cl + 100)) / 10000 * 4 * ml;
                base_res = (double) (120 * (cl + 100)) / 10000 * 4 * ml;
                base_hit = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
                base_speed = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
            }
            case "Sniper" -> {
                base_hp_max = (double) (90 * (cl + 100)) / 10000 * 30 * ml;
                base_atk = (double) (150 * (cl + 100)) / 10000 * 4 * ml;
                base_def = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_int = (double) (60 * (cl + 100)) / 10000 * 4 * ml;
                base_res = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_hit = (double) (160 * (cl + 100)) / 10000 * 4 * ml;
                base_speed = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
            }
            case "Cleric" -> {
                base_hp_max = (double) (80 * (cl + 100)) / 10000 * 30 * ml;
                base_atk = (double) (70 * (cl + 100)) / 10000 * 4 * ml;
                base_def = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
                base_int = (double) (100 * (cl + 100)) / 10000 * 4 * ml;
                base_res = (double) (130 * (cl + 100)) / 10000 * 4 * ml;
                base_hit = (double) (80 * (cl + 100)) / 10000 * 4 * ml;
                base_speed = (double) (90 * (cl + 100)) / 10000 * 4 * ml;
            }
        }
        refreshStats();
    }

    public void setPassiveLvl(String passive, int lvl) {
        passives.get(passive).setLvl(lvl);
    }

    public void add_stats(double atk, double def, double intel, double resist, double hit, double speed,
                          double attribute) {
        add_stats(atk, def, intel, resist, hit, speed);
        switch (name) {
            case "Assassin" -> {
                gear_dark += attribute;
            }
            case "Pyromancer" -> {
                gear_fire += attribute;
            }
            case "Sniper" -> {
                gear_wind += attribute;
            }
            case "Cleric" -> {
                gear_light += attribute;
            }
        }
    }

    public double getEblast() {
        return eblast_enabled ? getIntel() * 0.05 : 0;
    }

    @Override
    public double getFire() {
        switch (name) {
            case "Pyromancer" -> {
                return (getAtk() + getIntel()) * (fireBoost.enabled ? 0.5 + fireBoost.bonus : 0.5) + gear_fire + getEblast();
            }
            default -> {
                return gear_dark;
            }
        }
    }

    @Override
    public double getWater() {
        switch (name) {
            case "Pyromancer" -> {
                return (getAtk() + getIntel()) / -2 + gear_water + getEblast();
            }
            default -> {
                return gear_dark;
            }
        }
    }

    @Override
    public double getWind() {
        switch (name) {
            case "Sniper" -> {
                return (atk + intel) / 2 + gear_wind;
            }
            case "Pyromancer" -> {
                return gear_wind + getEblast();
            }
            default -> {
                return gear_wind;
            }
        }
    }

    @Override
    public double getEarth() {
        switch (name) {
            case "Pyromancer" -> {
                return gear_earth + getEblast();
            }
            default -> {
                return gear_earth;
            }
        }
    }

    @Override
    public double getDark() {
        switch (name) {
            case "Assassin" -> {
                return (atk + intel) / 2 + gear_dark;
            }
            default -> {
                return gear_dark;
            }
        }
    }

    @Override
    public double getLight() {
        switch (name) {
            case "Assassin", "Sniper" -> {
                return (atk + intel) / -2 + gear_light;
            }
            case "Cleric" -> {
                return gear_light + (holylight_enabled ? getResist() * 0.25 : 0);
            }
            default -> {
                return gear_light;
            }
        }
    }
}
