package third;

public class Student extends Human {
    private String university = "Krysmanski";
    private Place newPlace = null;

    public Student() {
        super();
    }
    public Student(String name, Clothes clothes, String university, String mood, Noise noise) {
        super(name, clothes, mood, noise);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    public Place getNewPlace() {
        return newPlace;
    }
    public void setNewPlace(Place newPlace) {
        this.newPlace = newPlace;
    }

    @Override
    public boolean breakInRoom(Place place) {
        double breakInProbability = Math.random();

        if (breakInProbability <= 0.5) {
            System.out.printf("Студент врывается: %s\n", place.toString());
            this.newPlace = place;
            return true;
        }

        return false;
    }

    @Override
    public void pullPeople(Human human) {
        if (newPlace != null) {
            System.out.printf("Студент толкает: %s\n", human.toString());
        }
    }

    @Override
    public void generateNoise(Noise noise) {
        if (newPlace == null) {
            System.out.printf("Студент издаёт %s\n", noise.toString());
        }
    }

    @Override
    public String toString() {
        return "студент";
    }
}
