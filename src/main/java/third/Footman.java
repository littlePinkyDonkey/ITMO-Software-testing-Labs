package third;

public class Footman extends Human {

    public Footman() {
        super();
    }
    public Footman(String name, Clothes clothes, String mood, Noise noise) {
        super(name, clothes, mood, noise);
    }

    @Override
    public boolean blockPath(Human blockedHuman) {
        System.out.printf("Лакей пытается заблокировать: %s\n", blockedHuman.toString());

        if (blockedHuman.toString().equals("студент")) {
            System.out.println("Поптыка провалена\n");
            return false;
        }

        System.out.println("Поптыка завершилась успехом\n");
        return true;
    }

    @Override
    public void generateNoise(Noise noise) {
        System.out.printf("Лакей издаёт %s\n", noise.toString());
    }

    @Override
    public String toString() {
        return "лакей";
    }
}
