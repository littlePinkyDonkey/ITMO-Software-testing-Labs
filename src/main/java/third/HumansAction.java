package third;

public interface HumansAction {

    boolean breakInRoom(Location location);

    boolean pullPeople(Human human);

    boolean blockPath(Human blockedHuman);

    boolean generateNoise(Noise noise);
}
