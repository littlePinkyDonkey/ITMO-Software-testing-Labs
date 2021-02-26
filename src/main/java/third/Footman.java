package third;

public class Footman extends Human {

    public Footman(String name, Clothes clothes, String mood, Noise noise) {
        super(name, clothes, mood, noise);
    }

    @Override
    public boolean blockPath(Human blockedHuman) {
        System.out.printf("Лакей пытается заблокировать: %s %s\n", blockedHuman.toString(), blockedHuman.getName());

        if (blockedHuman.toString().equals("студент")) {
            System.out.println("Поптыка провалена\n");
            return false;
        }

        System.out.println("Поптыка завершилась успехом\n");
        return true;
    }

    @Override
    public boolean generateNoise(Noise noise) {
        System.out.printf("Лакей издаёт %s\n", noise.toString());
        return true;
    }

    @Override
    public String toString() {
        return "лакей";
    }
}
