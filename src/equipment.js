class Equipment {
    static SCALING = {
        NORMAL: "normal",
        RESISTANCE: "resistance"
    }
    static Quality = {
        poor: 0.5,
        flawed: 0.75,
        normal: 1,
        good: 1.25,
        superior: 1.5,
        exceptional: 2,
        divine: 2.5,
        legendary: 3,
        mythic: 4,
        godly: 5
    }
    constructor(equipData, quality, upgrade){
        let multi = this.multiplier(quality, upgrade, Equipment.SCALING.NORMAL);

        // If you don't understand this syntax, look up optional chaining and nullish coalescing

        // Stats
        this.atk = multi * (equipData?.ATK ?? 0); // If equip data has atk field, use it, else use 0
        this.def = multi * (equipData?.DEF ?? 0);
        this.intel = multi * (equipData?.INT ?? 0);
        this.resist = multi * (equipData?.RES ?? 0);
        this.hit = multi * (equipData?.HIT ?? 0);
        this.speed = multi * (equipData?.SPD ?? 0);

        // Elements
        this.fire = multi * (equipData?.FIRE ?? 0);
        this.water = multi * (equipData?.WATER ?? 0);
        this.wind = multi * (equipData?.WIND ?? 0);
        this.earth = multi * (equipData?.EARTH ?? 0);
        this.dark = multi * (equipData?.DARK ?? 0);
        this.light = multi * (equipData?.LIGHT ?? 0);

        // Damage Mit
        multi = this.multiplier(quality, upgrade, Equipment.SCALING.RESISTANCE);

        this.phy_res = multi * (equipData?.PHY_RES ?? 0);
        this.mag_res = multi * (equipData?.MAG_RES ?? 0);
        this.fire_res = multi * (equipData?.FIRE_RES ?? 0);
        this.water_res = multi * (equipData?.WATER_RES ?? 0);
        this.wind_res = multi * (equipData?.WIND_RES ?? 0);
        this.earth_res = multi * (equipData?.EARTH_RES ?? 0);
        this.light_res = multi * (equipData?.DARK_RES ?? 0);
        this.dark_res = multi * (equipData?.LIGHT_RES ?? 0);
        
        // Special
        multi = 1; // Need to figure out scaling
        this.burn = multi * (equipData?.BURN ?? 0);
        this.crit = multi * (equipData?.CRIT ?? 0);
        this.stun = multi * (equipData?.STUN ?? 0);

        // Set
        this.setType = equipData?.SET ?? "NONE";
        this.setBonus = 0; // Need to calc
    }


    multiplier(quality, upgrade, scaling_type) {
        switch (scaling_type) {
            case Equipment.SCALING.NORMAL:
                return multiplier_from_tier(quality) * (1 + upgrade * 0.1);
            case Equipment.SCALING.RESISTANCE:
                return (0.5 + multiplier_from_tier(quality) * 0.5) * (1 + upgrade * 0.025);
            default:
                return 1;
        }
    }

    multiplier_from_tier(quality) {
        // search for quality in dict. Return 1 if not found.
        return Quality?.[quality.toLowerCase()] ?? 1;
    }
}
var WeaponData;
$.getJSON("data/Weapons.json", function (data) {
    WeaponData = data;
    console.log(new Equipment(WeaponData.SHORT_BOW, "poor", 10));
});