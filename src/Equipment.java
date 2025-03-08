public class Equipment {
    String name;
    String quality;
    int upgrade = 0;
    double atk = 0;
    double def = 0;
    double intel = 0;
    double resist = 0;
    double hit = 0;
    double speed = 0;
    double fire = 0;
    double water = 0;
    double wind = 0;
    double earth = 0;
    double dark = 0;
    double light = 0;
    double fire_res = 0;
    double water_res = 0;
    double wind_res = 0;
    double earth_res = 0;
    double dark_res = 0;
    double light_res = 0;
    double phys_res = 0;
    double magic_res = 0;
    double burn = 0;
    double crit = 0;
    double stun = 0;

    public Equipment() {
        name = "None";
    }

    public void setEquipment(String name, String quality, int upgrade) {
        this.name = name;
        this.quality = quality;
        this.upgrade = upgrade;
        switch (name) {
            case "Beech Bow" -> setStats(16, 0, 0, 0, 16, 0);
            case "Oak Bow" -> {
                setStats(32, 0, 0, 0, 32, 0);
                stun = 0.05; //todo:add scaling and functionality
            }
            case "Iron Wand" -> setStats(0, 12, 24, 0, 0, 0);
            case "Blazing Wand" -> {
                setStats(0, 0, 40, 0, 0, 0);
                setAttribute("Fire", 36);
                burn = 0.05; //todo:add scaling
            }
            case "Hidden Book" -> setStats(0, 0, 10, 6, 0, 0);
            case "Iron Knuckles" -> setStats(16, 0, 0, 0, 0, 16);
            case "Iron Sword" -> setStats(16, 0, 0, 0, 2, 0);
            case "Iron Shield" -> setStats(0, 12, 0, 8, 0, -4);
            case "Iron Dagger" -> setStats(6, 0, 0, 0, 4, 6);
            case "Bronze Dagger" -> {
                setStats(12, 0, 0, 0, 8, 12);
                crit = 0.02;//todo:add scaling
            }
            case "Golden Belt" -> setStats(3, 3, 3, 3, 3, 3);
            case "Metal Ring" -> setStats(3, 3, 0, 0, 0, 0);
            case "Bronze Ring" -> setStats(8, 4, 0, 0, 0, 0);
            case "Metal Necklace" -> setStats(0, 0, 3, 3, 0, 0);
            case "Bronze Necklace" -> setStats(0, 0, 6, 4, 0, 0);
            case "Cloth Helmet" -> setStats(0, 0, 0, 6, 0, 0);
            case "Cloth Bracers" -> setStats(0, 0, 0, 0, 6, 0);
            case "Cloth Pants" -> setStats(0, 8, 0, 0, 0, 0);
            case "Cloth Boots" -> setStats(0, 0, 0, 0, 0, 6);
            case "Cloth Chest" -> setStats(0, 4, 0, 6, 0, 0);
            case "Leather Helmet" -> setStats(0, 6, 0, 4, 0, 0);
            case "Leather Bracers" -> setStats(0, 0, 0, 0, 10, 0);
            case "Leather Pants" -> setStats(0, 10, 0, 0, 0, 0);
            case "Leather Boots" -> setStats(0, 0, 0, 0, 0, 10);
            case "Leather Chest" -> setStats(0, 12, 0, 6, 0, 0);
            case "Iron Helmet" -> {
                setStats(0, 11, 0, 6, -6, -2);
                setResists(1.5, 0, 0, 0, 0, 0, 0, 0);
            }
            case "Iron Bracers" -> {
                setStats(0, 5, 0, 4, 6, -4);
                setResists(1.5, 0, 0, 0, 0, 0, 0, 0);
            }
            case "Iron Pants" -> {
                setStats(0, 9, 0, 6, 0, -6);
                setResists(1.5, 0, 0, 0, 0, 0, 0, 0);
            }
            case "Iron Boots" -> {
                setStats(0, 4, 0, 4, 0, 2);
            }
            case "Iron Chest" -> {
                setStats(0, 20, 0, 8, -6, -6);
                setResists(5, 0, 0, 0, 0, 0, 0, 0);
            }
            case "Blazing Helmet" -> {
                setStats(0, 4, 2, 8, 0, 0);
                setResists(0, 0, 4, -2, 0, 0, 0, 0);
            }
            case "Blazing Bracers" -> {
                setStats(0, 0, 6, 0, 6, 0);
                setAttribute("Fire", 60);
                setResists(0, 0, 0, -4, 0, 0, 0, 0);
            }
            case "Blazing Pants" -> {
                setStats(0, 6, 2, 10, 0, 0);
                setAttribute("Fire", 20);
                setResists(0, 0, 2, 0, 0, 0, 0, 0);
            }
            case "Blazing Boots" -> {
                setStats(0, 4, 0, 4, 0, 2);
                setAttribute("Fire", 10);
                setResists(0, 0, 2, 0, 0, 0, 0, 0);
            }
            case "Blazing Chest" -> {
                setStats(0, 8, 4, 14, 0, 0);
                setAttribute("Fire", 30);
                setResists(0, 0, 6, -6, 0, 0, 0, 0);
            }
            case "Windy Helmet" -> {
                setStats(0, 6, 0, 6, 2, 0);
                setResists(0, 0, -2, 0, 4, 0, 0, 0);
            }
            case "Windy Bracers" -> {
                setStats(0, 0, 0, 0, 12, 0);
                setAttribute("Wind", 60);
                setResists(0, 0, -4, 0, 0, 0, 0, 0);
            }
            case "Windy Pants" -> {
                setStats(0, 10, 0, 6, 2, 0);
                setAttribute("Wind", 20);
                setResists(0, 0, 2, 0, 0, 0, 0, 0);
            }
            case "Windy Boots" -> {
                setStats(0, 2, 0, 0, 2, 12);
                setAttribute("Wind", 10);
                setResists(0, 0, 0, 0, 2, 0, 0, 0);
            }
            case "Windy Chest" -> {
                setStats(0, 14, 0, 8, 4, 0);
                setAttribute("Wind", 30);
                setResists(0, 0, -6, 0, 6, 0, 0, 0);
            }
            case "Dark Helmet" -> {
                setStats(0, 6, 0, 6, 2, 0);
                setResists(0, 0, 0, 0, 0, 0, -2, 4);
            }
            case "Dark Bracers" -> {
                setStats(6, 0, 0, 0, 6, 0);
                setAttribute("Dark", 60);
                setResists(0, 0, 0, 0, 0, 0, -4, 0);
            }
            case "Dark Pants" -> {
                setStats(2, 10, 0, 6, 0, 0);
                setAttribute("Dark", 20);
                setResists(0, 0, 0, 0, 0, 0, 0, 2);
            }
            case "Dark Boots" -> {
                setStats(2, 2, 0, 0, 0, 12);
                setAttribute("Dark", 10);
                setResists(0, 0, 0, 0, 0, 0, 0, 2);
            }
            case "Dark Chest" -> {
                setStats(4, 14, 0, 8, 0, 0);
                setAttribute("Dark", 30);
                setResists(0, 0, 0, 0, 0, 0, -6, 6);
            }
        }
    }

    public void setStats(double atk, double def, double intel, double resist, double hit, double speed) {
        double mult = multiplier(quality, upgrade, 1);
        this.atk = atk * mult;
        this.def = def * mult;
        this.intel = intel * mult;
        this.resist = resist * mult;
        this.hit = hit * mult;
        this.speed = speed * mult;
    }

    public void setAttribute(String type, double value) {
        double value_m = value * multiplier(quality, upgrade, 1);
        switch (type) {
            case "Fire" -> {
                fire = value_m;
            }
            case "Water" -> {
                water = value_m;
            }
            case "Wind" -> {
                wind = value_m;
            }
            case "Earth" -> {
                earth = value_m;
            }
            case "Light" -> {
                light = value_m;
            }
            case "Dark" -> {
                dark = value_m;
            }
        }
    }

    public void setResists(double phys, double magic, double fire, double water, double wind, double earth,
                           double light, double dark) {
        double mult = multiplier(quality, upgrade, 2);
        phys_res = phys * mult;
        magic_res = magic * mult;
        fire_res = fire * mult;
        water_res = water * mult;
        wind_res = wind * mult;
        earth_res = earth * mult;
        light_res = light * mult;
        dark_res = dark * mult;
    }

    public static double multiplier(String quality, int upgrade, int scaling_type) {
        switch (scaling_type) {
            case 1 -> {
                return multiplier_from_tier(quality) * (1 + upgrade * 0.1);
            }
            case 2 -> {
                return (1 + multiplier_from_tier(quality) * 0.5) * (1 + upgrade * 0.025);
            }
            default -> {
                return 1;
            }
        }
    }

    public static double multiplier_from_tier(String quality) {
        return switch (quality.toLowerCase()) {
            case "poor" -> 0.5;
            case "flawed" -> 0.75;
            case "normal" -> 1;
            case "good" -> 1.25;
            case "superior" -> 1.5;
            case "exceptional" -> 2;
            case "divine" -> 2.5;
            case "legendary" -> 3;
            case "mythic" -> 4;
            case "godly" -> 5;
            default -> 1;
        };
    }
}
