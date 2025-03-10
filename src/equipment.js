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
                return this.multiplier_from_tier(quality) * (1 + upgrade * 0.1);
            case Equipment.SCALING.RESISTANCE:
                return (0.5 + this.multiplier_from_tier(quality) * 0.5) * (1 + upgrade * 0.025);
            default:
                return 1;
        }
    }

    multiplier_from_tier(quality) {
        // search for quality in dict. Return 1 if not found.
        return Equipment.Quality?.[quality.toLowerCase()] ?? 1;
    }
}
var WeaponData;
var ArmorData;
var AccessoryData;

var qualityList = []
Object.keys(Equipment.Quality).forEach(quality => {
    qualityList.push(quality);
});

function viewModel() {
    var self = this;
    self.qualitySelection = ko.observableArray(qualityList);
    // These are the initial options
    self.mainhandWeapons = ko.observableArray([]);
    self.selectedMainWeapon = ko.observable();
    //self.mainQuality = ko.observableArray(qualityList);
    self.mainSelectedQuality = ko.observable();
    self.mainUpgrade = ko.observable(0);
   
    self.offhandWeapons = ko.observableArray([]);
    self.selectedOffWeapon = ko.observable();
    //self.offQuality = ko.observableArray(qualityList);
    self.offSelectedQuality = ko.observable();
    self.offUpgrade = ko.observable(0);
   
    
    self.helmets = ko.observableArray([]);
    self.selectedHelmet = ko.observable();
    //self.helmetQuality = ko.observableArray(qualityList);
    self.helmetSelectedQuality = ko.observable();
    self.helmetUpgrade = ko.observable(0);
   
    self.boots = ko.observableArray([]);
    self.selectedBoot = ko.observable();
    //self.bootQuality = ko.observableArray(qualityList);
    self.bootSelectedQuality = ko.observable();
    self.bootUpgrade = ko.observable(0);
   
    self.chests = ko.observableArray([]);
    self.selectedChest = ko.observable();
    //self.chestQuality = ko.observableArray(qualityList);
    self.chestSelectedQuality = ko.observable();
    self.chestUpgrade = ko.observable(0);
   
    self.hands = ko.observableArray([]);
    self.selectedHand = ko.observable();
    //self.handQuality = ko.observableArray(qualityList);
    self.handSelectedQuality = ko.observable();
    self.handUpgrade = ko.observable(0);
   
    self.legs = ko.observableArray([]);
    self.selectedLeg = ko.observable();
    //self.legQuality = ko.observableArray(qualityList);
    self.legSelectedQuality = ko.observable();
    self.legUpgrade = ko.observable(0);
   
    self.necklaces = ko.observableArray([]);
    self.selectedNecklace = ko.observable();
    //self.necklaceQuality = ko.observableArray(qualityList);
    self.necklaceSelectedQuality = ko.observable();
    self.necklaceUpgrade = ko.observable(0);
   
    self.rings = ko.observableArray([]);
   
    self.selectedRing1 = ko.observable();
    //self.ring1Quality = ko.observableArray(qualityList);
    self.ring1SelectedQuality = ko.observable();
    self.ring1Upgrade = ko.observable(0);
   
    self.selectedRing2 = ko.observable();
    //self.ring2Quality = ko.observableArray(qualityList);
    self.ring2SelectedQuality = ko.observable();
    self.ring2Upgrade = ko.observable(0);
   
    self.equipmentText = ko.computed(function() {
        let Armors = []
        if(self.selectedHelmet()) { // Make sure something has been inited.
            Armors.push(new Equipment(ArmorData.HEADGEAR[self.selectedHelmet()], self.helmetSelectedQuality(), self.helmetUpgrade()));
            Armors.push(new Equipment(ArmorData.BOOTS[self.selectedBoot()], self.bootSelectedQuality(), self.bootUpgrade()));
            Armors.push(new Equipment(ArmorData.CHEST[self.selectedChest()], self.chestSelectedQuality(), self.chestUpgrade()));
            Armors.push(new Equipment(ArmorData.BRACERS[self.selectedHand()], self.handSelectedQuality(), self.handUpgrade()));
            Armors.push(new Equipment(ArmorData.PANTS[self.selectedLeg()], self.legSelectedQuality(), self.legUpgrade()));
        }
       
        let ATK = Armors.reduce((n, {atk}) => n + atk, 0);
        return ATK
    });
};

var vm = new viewModel();

$.getJSON("data/Weapons.json", function (data) {
    WeaponData = data;
    Object.keys(WeaponData["2H"]).forEach(weapon => {
        vm.mainhandWeapons.push(weapon);
        vm.offhandWeapons.push(weapon);
    });
    Object.keys(WeaponData.MH).forEach(weapon => {
        vm.mainhandWeapons.push(weapon);
        vm.offhandWeapons.push(weapon);
    });
    Object.keys(WeaponData.OH).forEach(weapon => {
        vm.mainhandWeapons.push(weapon);
        vm.offhandWeapons.push(weapon);
    });
});

$.getJSON("data/Armor.json", function (data) {
    ArmorData = data;
    Object.keys(ArmorData.HEADGEAR).forEach(head => {
        vm.helmets.push(head);
    });
    Object.keys(ArmorData.BOOTS).forEach(boot => {
        vm.boots.push(boot);
    });
    Object.keys(ArmorData.BRACERS).forEach(hand => {
        vm.hands.push(hand);
    });
    Object.keys(ArmorData.PANTS).forEach(leg => {
        vm.legs.push(leg);
    });
    Object.keys(ArmorData.CHEST).forEach(chest => {
        vm.chests.push(chest);
    });
});

$.getJSON("data/Accessories.json", function (data) {
    AccessoryData = data;
    Object.keys(AccessoryData.NECK).forEach(neck => {
        vm.necklaces.push(neck);
    });
    Object.keys(AccessoryData.RING).forEach(ring => {
        vm.rings.push(ring);
    });
});

ko.applyBindings(vm)