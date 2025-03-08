public class Main {
    public static int game_version = 1531;

    public static void main(String[] args) {
//        Player disilon = new Player("Assassin", 106, 48);
//        //beech bow+9
//        disilon.add_stats(38, 0, 0, 0, 38, 0, 0);
//        //golden belt
//        disilon.add_stats(21, 21, 21, 21, 21, 21, 0);
//        //accessories
//        disilon.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
//        //leather +9
//        disilon.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
//        //gear
////        disilon.add_stats(111, 81, 27, 46, 137, 62, 0);
//        disilon.enableSet("hit", "good", 9);
//        disilon.setPassiveLvl("Attack Boost", 13);
//        disilon.setPassiveLvl("Dagger Mastery", 14);
//        disilon.setPassiveLvl("Speed Boost", 12);
//        disilon.setPassiveLvl("Drop Boost", 14);
//        disilon.setPassiveLvl("Stealth", 5);
//        disilon.setPassiveLvl("Poison Boost", 4);
//        disilon.setPassiveLvl("Defense Boost", 0);
//        disilon.setPassiveLvl("Dodge", 1);
//        disilon.prepare_lvl = 3;
//        disilon.enablePassives(new String[]{"Drop Boost", "Speed Boost", "Poison Boost"});
//        pa.setSkill(4, SkillMod.basic);
//        smoke.setSkill(3, SkillMod.hithit);
//        Simulation sim3 = new Simulation(10000, disilon, new Enemy("Dagon"));
//        sim3.setupPotions("hp", 2, 85, "mp", 3, 70);
//        sim3.milestone_exp_mult = 1.475;
////        sim3.run(smoke, 1, pa, 10, null, 65, true, 70);
//
//        Player disilon_ks = new Player("Assassin", 160, 90);
//        disilon_ks.add_stats(37.25, 0, 0, 0, 10.25, 11.25, 0);
//        disilon.add_stats(0, 0, 0, 0, 51, 0, 0);
//        disilon_ks.add_stats(21, 21, 21, 21, 21, 21, 0);
//        disilon_ks.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
//        disilon_ks.add_stats(0, 0, 0, 0, 52.5, 0, 0);
//        disilon_ks.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
//        disilon_ks.enableSet("hit", "good", 9);
////        disilon_ks.add_stats(20, 42.5, 0, 25, 7.2, 12.5, 150);
////        disilon_ks.enableSet("physdmg", "good", 0);
//        disilon_ks.setPassiveLvl("Attack Boost", 13);
//        disilon_ks.setPassiveLvl("Dagger Mastery", 14);
//        disilon_ks.setPassiveLvl("Speed Boost", 12);
//        disilon_ks.setPassiveLvl("Drop Boost", 14);
//        disilon_ks.setPassiveLvl("Stealth", 5);
//        disilon_ks.setPassiveLvl("Poison Boost", 4);
//        disilon_ks.setPassiveLvl("Defense Boost", 0);
//        disilon_ks.setPassiveLvl("Dodge", 1);
//        disilon_ks.prepare_lvl = 6;
//        disilon_ks.enablePassives(new String[]{"Drop Boost", "Dagger Mastery", "Attack Boost"});
//
//        fa.setSkill(4, SkillMod.basic);
//        dp.setSkill(8, SkillMod.powpow);
//        ks.setSkill(7, SkillMod.powpow);
//        hide.setSkill(8, SkillMod.fast);
//
//        Simulation sim3_ks = new Simulation(10000, disilon_ks, new Enemy("Dagon"));
//        sim3_ks.setupPotions("hp", 3, 75, "mp", 3, 75);
//        sim3_ks.milestone_exp_mult = 1.725;
////        sim3_ks.run(hide, 1, ks, 1, null, 1, true, 65);
//        disilon_ks.clear_gear_stats();
//        disilon_ks.add_stats(37.25, 0, 0, 0, 10.25, 11.25, 0);
//        disilon_ks.add_stats(21, 21, 21, 21, 21, 21, 0);
//        disilon_ks.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
//        disilon_ks.add_stats(20, 42.5, 0, 25, 7.2, 12.5, 150);
//        disilon_ks.enableSet("physdmg", "good", 0);
////        disilon_ks.add_crit(0.05);
////        sim3_ks.run(hide, 1, ks, 1, null, 1, true, 75);
//
//        Player disilon_s = new Player("Sniper", 122, 69);
//        disilon_s.add_stats(65.75, 94.25, 28.13, 51.88, 83, 45, 0);
//        disilon_s.enableSet("hit", "good", 9);
//        disilon_s.setPassiveLvl("Attack Boost", 14);
//        disilon_s.setPassiveLvl("Bow Mastery", 12);
//        disilon_s.setPassiveLvl("Speed Boost", 12);
//        disilon_s.setPassiveLvl("Drop Boost", 19);
//        disilon_s.setPassiveLvl("Concentration", 7);
//        disilon_s.setPassiveLvl("Ambush", 7);
//        disilon_s.setPassiveLvl("Defense Boost", 0);
//        disilon_s.setPassiveLvl("HP Regen", 9);
//        disilon_s.setPassiveLvl("Hit Boost", 5);
//        disilon_s.prepare_lvl = 6;
//        disilon_s.enablePassives(new String[]{"Hit Boost", "Drop Boost", "Concentration"});
//        Simulation sim4 = new Simulation(10000, disilon_s, new Enemy("Shax"));
//        ss.setSkill(5, SkillMod.powpow);
//        ar.setSkill(5, SkillMod.powpow);
//        db.setSkill(4, SkillMod.powpow);
//        mark.setSkill(2, SkillMod.hithit);
//        charge.setSkill(4, SkillMod.powpow);
//        sim4.setupPotions("mp", 3, 55, "hp", 3, 65);
//        sim4.milestone_exp_mult = 1.55;
////        sim4.run(charge, 1, ss, 1, null, 1, true, 70);
//
//        Player pyro = new Player("Pyromancer", 145, 75);
//        pyro.add_stats(0, 0, 50, 0, 0, 0, 45);
//        //golden belt
//        pyro.add_stats(21, 21, 21, 21, 21, 21, 0);
//        //accessories
//        pyro.add_stats(10, 5, 10, 5, 0, 0, 0);
//        //leather +9
////        pyro.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
////        pyro.enableSet("hit", "good", 9);
////        pyro.add_stats(0, 24, 12, 24, 12, 12);
//        pyro.add_stats(0, 22.5, 20, 40, 7.5, 17.5, 150);
//        pyro.enableSet("magicdmg", "good", 0);
//        //iron +5
////        pyro.add_stats(0, 91.874, 0, 52.5, -11.25, -30);
////        pyro.fire_res = 0.80772;
//        pyro.setPassiveLvl("Int Boost", 15);
//        pyro.setPassiveLvl("Res Boost", 7);
//        pyro.setPassiveLvl("Wand Mastery", 14);
//        pyro.setPassiveLvl("Casting Boost", 6);
//        pyro.setPassiveLvl("Fire Boost", 9);
//        pyro.setPassiveLvl("Fire Resist", 4);
//        pyro.burn_mult = 1.05;
//        pyro.eblast_enabled = true;
//        pyro.fire_res = 0.8128;
//        pyro.enablePassives(new String[]{"Wand Mastery", "Fire Boost", "Fire Resist"});
//        fball.setSkill(2, SkillMod.powpow);
//        fpillar.setSkill(7, SkillMod.powpow);
//        eblast.setSkill(5, SkillMod.fast);
//        explosion.setSkill(5, SkillMod.damage);
//        fa.setSkill(3, SkillMod.powpow);
//        Simulation sim_pyro = new Simulation(10000, pyro, new Enemy("Lamia"));
//        sim_pyro.setupPotions("hp", 3, 65, "mp", 3, 65);
//        sim_pyro.milestone_exp_mult = 1.825;
////        sim_pyro.run(fa, 30, fpillar, 10, eblast, 1, false, 90);
//
//        Player cleric = new Player("Cleric", 127, 44);
//        cleric.add_stats(28, 118, 41, 89, 12, -9);
//        cleric.dark_res = 0.117;
//        cleric.setPassiveLvl("Int Boost", 8);
//        cleric.setPassiveLvl("Res Boost", 4);
//        cleric.setPassiveLvl("Book Mastery", 4);
//        cleric.setPassiveLvl("Ailment Res", 0);
//        cleric.enablePassives(new String[]{"Book Mastery", "Int Boost", "Res Boost"});
//        cleric.holylight_enabled = true;
//        Simulation sim_cleric = new Simulation(10000, cleric, new Enemy("Devil"));
//        sim_cleric.setupPotions("hp", 3, 25, "mp", 3, 25);
//        sim_cleric.milestone_exp_mult = 1.65;
////        sim_cleric.run("Heal", 3, SkillMod.powpow, 70, "Holy Light", 3, SkillMod.powpow, 1, "None", 0,
////                SkillMod.powpow, 1);
////        sim_cleric.run(bless, 1, heal, 60, hlight, 1, false, 60);

        UserForm uf = new UserForm();
    }

}