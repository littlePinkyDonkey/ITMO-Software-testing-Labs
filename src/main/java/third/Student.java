package third;

import lombok.Data;

@Data
public class Student extends Human {
    private String university = "Krysmanski";
    private Location newLocation = null;

    public Student(String name, Clothes clothes, String mood, Noise noise) {
        super(name, clothes, mood, noise);
    }

    @Override
    public boolean breakInRoom(Location location) {
        double breakInProbability = Math.random();

        if (!location.isClosed() || breakInProbability <= 0.5) {
            System.out.printf("Студент в одежде: %s врывается: %s\n", super.getClothes().toString(),
                    location.toString());
            this.newLocation = location;
            return true;
        }

        return false;
    }

    @Override
    public boolean pullPeople(Human human) {
        if (newLocation != null) {
            System.out.printf("Студент толкает: %s\n", human.toString());
            return true;
        } else {
            System.out.println("Студенту некого толкать\n");
            return false;
        }
    }

    @Override
    public boolean generateNoise(Noise noise) {
        System.out.printf("Студент издаёт звук: %s\n", noise.getNoiseName());
        return true;
    }

    @Override
    public String toString() {
        return "студент";
    }
}
