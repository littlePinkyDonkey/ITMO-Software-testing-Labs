package third;

public class Human implements HumansAction {
    private String name;
    private Clothes clothes;
    private String mood;
    private Noise noise;

    public Human() {
    }
    public Human(String name, Clothes clothes, String mood, Noise noise) {
        this.name = name;
        this.clothes = clothes;
        this.mood = mood;
        this.noise = noise;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Clothes getClothes() {
        return clothes;
    }
    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }

    public Noise getNoise() {
        return noise;
    }
    public void setNoise(Noise noise) {
        this.noise = noise;
    }

    @Override
    public boolean breakInRoom(Place place) {
        if (!place.isClosed()) {
            System.out.println("Человек врывается в комнату\n");
            return true;
        }
        return false;
    }

    @Override
    public void pullPeople(Human human) {
        System.out.println("Человек расталкивает людей\n");
    }

    @Override
    public boolean blockPath(Human blockedHuman) {
        System.out.println("Человек пытается блокировать путь ворвавшемуся\n");
        return false;
    }

    @Override
    public void generateNoise(Noise noise) {
        System.out.printf("Человек издаёт %s\n", noise.toString());
    }

    @Override
    public String toString() {
        return "человек";
    }
}
