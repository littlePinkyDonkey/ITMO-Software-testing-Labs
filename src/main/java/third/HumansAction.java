package third;

public interface HumansAction {

    boolean breakInRoom(Place place);

    void pullPeople(Human human);

    boolean blockPath(Human blockedHuman);

    void generateNoise(Noise noise);
}
