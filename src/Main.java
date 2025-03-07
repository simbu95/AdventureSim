public class Main {
    public static int game_version = 1531;

    public static void main(String[] args) {
        Actor z11 = new Dagon();
        Actor z12 = new Lamia();
        Actor v3 = new V3();
        Actor v4 = new V4();
        Actor v5 = new V5();
        Actor z10 = new Shax();
        Actor z9 = new Devil();
        ActiveSkill hide = new ActiveSkill("Hide", 1, 0, 0, 0, 5, 0.5, 0.5, Scaling.atk, Element.none, false, false);
        ActiveSkill ks = new ActiveSkill("Killing Strike", 1, 297, 363, 0.7, 80, 2, 2, Scaling.atk, Element.dark,
                false, false);
        ActiveSkill dp = new ActiveSkill("Dragon Punch", 3, 76.5, 93.5, 0.8, 20, 1, 3, Scaling.atk, Element.phys,
                false, false);
        ActiveSkill pa = new ActiveSkill("Poison Attack", 1, 36, 44, 1, 4, 0.4, 0.9, Scaling.atk, Element.phys, false
                , false);
        pa.addDebuff("Poison", 3, 0.1);
        ActiveSkill smoke = new ActiveSkill("Smoke Screen", 1, 0, 0, 0.85, 25, 0.8, 1, Scaling.atk, Element.none, true, false);
        smoke.addDebuff("Smoke", 3, 0);
        ActiveSkill fa = new ActiveSkill("First Aid", 1, 15, 15, 0, 5, 0.9, 1.1, Scaling.atk, Element.none, false,
                true);
        ActiveSkill ss = new ActiveSkill("Sharp Shooting", 1, 207, 253, 1.5, 80, 2, 3, Scaling.atkhit, Element.wind,
                false,
                false);
        ActiveSkill ar = new ActiveSkill("Arrow Rain", 5, 49.5, 60.5, 0.7, game_version >= 1535 ? 25 : 20, 1.5, 1.5,
                Scaling.atkhit, Element.phys,
                false,
                false);
        ActiveSkill db = new ActiveSkill("Defense Break", 1, 90, 110, 1, 10, 1, 1, Scaling.atk, Element.phys, false,
                false);
        db.addDebuff("Defense Break", 3, 0.25);
        ActiveSkill mark = new ActiveSkill("Mark Target", 1, 0, 0, 1.5, 10, 0.5, 0.5, Scaling.atk, Element.none,
                false,
                false);
        mark.addDebuff("Mark", 1, 0.2);
        ActiveSkill charge = new ActiveSkill("Charge Up", 1, 0, 0, 0, 50, 2, 2, Scaling.atk, Element.none, false,
                false);
        charge.addBuff("Charge Up", 1, 1.5);
        ActiveSkill fball = new ActiveSkill("Fire Ball", 1, 99, 121, 1.35, 20, 1.15, 1, Scaling.intel, Element.fire,
                false, false);
        fball.addDebuff("Burn", 3, 1);
        ActiveSkill fpillar = new ActiveSkill("Fire Pillar", 1, 180, 220, 1.0, game_version >= 1537 ? 50 : 36, 1.5, 1.5,
                Scaling.intel,
                Element.fire, false, false);
        fpillar.addDebuff("Burn", 3, 1);
        ActiveSkill explosion = new ActiveSkill("Explosion", 1, 1350, 1650, 1.15, 500, 8, 30, Scaling.intel,
                Element.fire, true, false);
        explosion.addDebuff("Burn", 3, 1);
        ActiveSkill eblast = new ActiveSkill("Elemental Blast", 1, 117, 143, 1.0, 20, 1.2, 1.2, Scaling.intel,
                Element.magic, false, false);
        ActiveSkill hlight = new ActiveSkill("Holy Light", 1, 112.5, 137.5, 1.0, 25, 1, 1.1, Scaling.resint,
                Element.light, false, false);
        ActiveSkill heal = new ActiveSkill("Heal", 1, 250, 45, 0, 30, 0.8, 1.5, Scaling.atk, Element.none, false,
                true);
        ActiveSkill bless = new ActiveSkill("Bless", 1, 0, 0, 0, 40, 0.5, 0.5, Scaling.atk, Element.none, false,
                false);
        bless.addBuff("Bless", 2, 0.3);
        ActiveSkill push = new ActiveSkill("Push Blast", 1, 99, 121 , 0.9, 30, 1.3, 1.3, Scaling.intel,
                Element.magic, true, false);

        Assassin player = new Assassin(115, 71);
        //weapons
        player.add_stats(30, 0, 0, 0, 20, 30, 0);
        //golden belt
        player.add_stats(21, 21, 21, 21, 21, 21, 0);
        //accessories
        player.add_stats(12, 6, 12, 6, 0, 0, 0);
        //good dark +0
        player.add_stats(20, 42.5, 0, 25, 7.5, 12.5, 150);
        player.enableSet("physdmg", "good", 0);
        player.add_crit(0.04);
        player.setPassiveLvls(13, 8, 11, 11, 0, 7, 0, 2);

        player.enablePassives(new String[]{"Drop Boost", "Dagger Mastery", "Attack Boost"});

        Assassin player2 = new Assassin(105, 72);
        //weapons + accessories
        player2.add_stats(50.25, 27.75, 28.13, 28.13, 36, 43.5, 0);
        //leather t1 +9
        player2.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
        player2.enableSet("hit", "good", 9);
        player2.setPassiveLvls(13, 14, 11, 18, 0, 7, 0, 2);
        player2.enablePassives(new String[]{"Drop Boost", "Dagger Mastery", "Attack Boost"});

        ks.setSkill(5, SkillMod.powpow);
        hide.setSkill(5, SkillMod.fast);

        Simulation sim1 = new Simulation(100000, player, z11, 6);
        sim1.setupPotions("hp", 3, 75, "mp", 3, 70);
        sim1.exp_mult = 1.625;
        //sim1.run_days(hide, 1, ks, 1, null, 0, true, 65, 14);
        //sim1.run(hide, 1, ks, 1, null, 0, true, 65);

        //sim1.run(ks, 1, null, 1, null, 0, true, 75);

        Simulation sim2 = new Simulation(10000, player, v4);
        sim2.setupPotions("hp", 3, 75, "mp", 3, 70);
        sim2.exp_mult = 1.625;
        //sim2.run(hide, 1, ks, 1, null, 0, true, 75);

        Assassin disilon = new Assassin(106, 48);

        //beech bow+9
        disilon.add_stats(38, 0, 0, 0, 38, 0, 0);
        //golden belt
        disilon.add_stats(21, 21, 21, 21, 21, 21, 0);
        //accessories
        disilon.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
        //leather +9
        disilon.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
        //gear
//        disilon.add_stats(111, 81, 27, 46, 137, 62, 0);
        disilon.enableSet("hit", "good", 9);
        disilon.setPassiveLvls(13, 14, 12, 14, 5, 4, 0, 1);
        disilon.prepare_lvl = 3;
        disilon.enablePassives(new String[]{"Drop Boost", "Speed Boost", "Poison Boost"});
        pa.setSkill(4, SkillMod.basic);
        smoke.setSkill(3, SkillMod.hithit);
        Simulation sim3 = new Simulation(10000, disilon, z11, 6);
        sim3.setupPotions("hp", 2, 85, "mp", 3, 70);
        sim3.exp_mult = 1.475;
//        sim3.run(smoke, 1, pa, 10, null, 65, true, 70);


        Assassin disilon_ks = new Assassin(160, 90);
        disilon_ks.add_stats(37.25, 0, 0, 0, 10.25, 11.25, 0);
        disilon.add_stats(0, 0, 0, 0, 51, 0, 0);
        disilon_ks.add_stats(21, 21, 21, 21, 21, 21, 0);
        disilon_ks.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
        disilon_ks.add_stats(0, 0, 0, 0, 52.5, 0, 0);
        disilon_ks.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
        disilon_ks.enableSet("hit", "good", 9);
//        disilon_ks.add_stats(20, 42.5, 0, 25, 7.2, 12.5, 150);
//        disilon_ks.enableSet("physdmg", "good", 0);
        disilon_ks.setPassiveLvls(14, 14, 12, 19, 5, 8, 0, 1);
        disilon_ks.prepare_lvl = 6;
        disilon_ks.enablePassives(new String[]{"Drop Boost", "Dagger Mastery", "Attack Boost"});

        fa.setSkill(4, SkillMod.basic);
        dp.setSkill(8, SkillMod.powpow);
        ks.setSkill(7, SkillMod.powpow);
        hide.setSkill(8, SkillMod.fast);

        Simulation sim3_ks = new Simulation(10000, disilon_ks, z11, 6);
        sim3_ks.setupPotions("hp", 3, 75, "mp", 3, 75);
        sim3_ks.exp_mult = 1.725;
//        sim3_ks.run(hide, 1, ks, 1, null, 1, true, 65);
        disilon_ks.clear_gear_stats();
        disilon_ks.add_stats(37.25, 0, 0, 0, 10.25, 11.25, 0);
        disilon_ks.add_stats(21, 21, 21, 21, 21, 21, 0);
        disilon_ks.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
        disilon_ks.add_stats(20, 42.5, 0, 25, 7.2, 12.5, 150);
        disilon_ks.enableSet("physdmg", "good", 0);
//        disilon_ks.add_crit(0.05);
//        sim3_ks.run(hide, 1, ks, 1, null, 1, true, 75);



        Sniper disilon_s = new Sniper(168, 75);
        disilon_s.add_stats(65.75, 94.25, 28.13, 51.88, 83, 45, 0);
        disilon_s.enableSet("hit", "good", 9);
        disilon_s.setPassiveLvls(14, 12, 11, 19, 9, 7, 0, 9, 6);
        disilon_s.prepare_lvl = 6;
        disilon_s.enablePassives(new String[]{"Hit Boost", "Drop Boost", "Ambush"});
        Simulation sim4 = new Simulation(10000, disilon_s, z10, 6);
        ss.setSkill(5, SkillMod.powpow);
        ar.setSkill(5, SkillMod.powpow);
        db.setSkill(4, SkillMod.powpow);
        mark.setSkill(2, SkillMod.hithit);
        charge.setSkill(4, SkillMod.powpow);
        sim4.setupPotions("mp", 3, 55, "hp", 3, 65);
        sim4.exp_mult = 1.55;
//        sim4.run(charge, 1, ss, 1, null, 1, true, 70);

        Sniper sniper62 = new Sniper(130, 78);
        sniper62.add_stats(80, 0, 0, 0, 80, 0, 0);
        sniper62.add_stats(21, 21, 21, 21, 21, 21, 0);
        sniper62.add_stats(6.75, 6.75, 7.13, 7.13, 0, 0, 0);
        sniper62.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
        sniper62.enableSet("hit", "good", 9);
        sniper62.setPassiveLvls(14, 12, 11, 15, 10, 9, 0, 9, 8);
        sniper62.prepare_lvl = 7;
        sniper62.enablePassives(new String[]{"Drop Boost", "Hit Boost", "Bow Mastery"});
        Simulation sim5 = new Simulation(10000, sniper62, z10, 5);
        sim5.setupPotions("hp", 3, 50, "mp", 3, 50);
        sim5.exp_mult = 1.55;
        charge.setSkill(4, SkillMod.fast);
        mark.setSkill(4, SkillMod.hithit);
        ss.setSkill(6, SkillMod.powpow);
        ar.setSkill(8, SkillMod.powpow);
//        sim5.run(mark, 1, charge, 1, ss, 3, false, 60);

        Pyromancer pyro = new Pyromancer(145, 75);
        pyro.add_stats(0, 0, 50, 0, 0, 0, 45);
        //golden belt
        pyro.add_stats(21, 21, 21, 21, 21, 21, 0);
        //accessories
        pyro.add_stats(10, 5, 10, 5, 0, 0, 0);
        //leather +9
//        pyro.add_stats(0, 66.5, 0, 23.75, 23.75, 23.75, 0);
//        pyro.enableSet("hit", "good", 9);
//        pyro.add_stats(0, 24, 12, 24, 12, 12);
        pyro.add_stats(0, 22.5, 20, 40, 7.5, 17.5, 150);
        pyro.enableSet("magicdmg", "good", 0);
        //iron +5
//        pyro.add_stats(0, 91.874, 0, 52.5, -11.25, -30);
//        pyro.fire_res = 0.80772;
        pyro.setPassiveLvls(15, 7, 14, 6, 9, 4);
        pyro.burn_mult = 1.05;
        pyro.add_eleblast();
        pyro.fire_res = 0.8128;
        pyro.enablePassives(new String[]{"Wand Mastery", "Fire Boost", "Fire Resist"});
        fball.setSkill(2, SkillMod.powpow);
        fpillar.setSkill(7, SkillMod.powpow);
        eblast.setSkill(5, SkillMod.fast);
        explosion.setSkill(5, SkillMod.damage);
        fa.setSkill(3, SkillMod.powpow);
        Simulation sim_pyro = new Simulation(10000, pyro, z12, 6);
        sim_pyro.setupPotions("hp", 3, 65, "mp", 3, 65);
        sim_pyro.exp_mult = 1.825;
//        sim_pyro.run(fa, 30, fpillar, 10, eblast, 1, false, 90);

        Cleric cleric = new Cleric(126, 30);
        cleric.add_stats(28, 118, 41, 89, 12, -9);
        cleric.dark_res = 0.117;
        cleric.setPassiveLvls(8, 2, 3, 2);
        cleric.enablePassives(new String[]{"Book Mastery", "Int Boost", "Res Boost"});
        cleric.add_holylight();
        heal.setSkill(1, SkillMod.powpow);
        hlight.setSkill(2, SkillMod.powpow);
        bless.setSkill(0, SkillMod.powpow);
        Simulation sim_cleric = new Simulation(10000, cleric, z9, 5);
        sim_cleric.setupPotions("hp", 3, 25, "mp", 3, 25);
        sim_cleric.exp_mult = 1.65;
        sim_cleric.run(heal, 70, hlight, 1, null, 1, false, 60);
//        sim_cleric.run(bless, 1, heal, 60, hlight, 1, false, 60);

        Assassin test1 = new Assassin(110, 43);
        test1.add_stats(107, 60, 25, 37, 95, 56);
        test1.setPassiveLvls(10, 0, 11, 13, 2, 2, 0, 2);
        test1.enablePassives(new String[]{"Speed Boost", "Poison Boost", "Dodge"});
        test1.enableSet("hit", "good", 0);
        pa.setSkill(4, SkillMod.basic);
        smoke.setSkill(3, SkillMod.hithit);
        test1.prepare_lvl = 9;
        Simulation sim_test = new Simulation(10000, test1, z11, 6);
        sim_test.setupPotions("hp", 2, 85, "mp", 2, 80);
        sim_test.exp_mult = 1.475;
        //sim_test.run(smoke, 1, pa, 10, null, 1, true, 95);
    }

}