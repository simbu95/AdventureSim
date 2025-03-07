public class Equipment {
    String set;
    String slot;
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
