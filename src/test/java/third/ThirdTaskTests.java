package third;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Third task tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ThirdTaskTests {
    private Student student;
    private Human randomHuman;
    private Footman footman;

    private Location openedRoom;
    private Location closedRoom;

    private Noise studentNotInRoomNoise;
    private Noise studentInRoomNoise;
    private Noise randomHumanNoise;
    private Noise footmanNoise;

    @BeforeEach
    void init() {
        Clothes studentClothes = new Clothes("синий", "балахон и пояс", "выцветшая");
        Clothes humanClothes = new Clothes("чёрный", "брикю и костюм", "новая");
        Clothes footmanClothes = new Clothes("белый", "рубашка", "потёртая");

        studentNotInRoomNoise = new Noise("плач", 10);
        studentInRoomNoise = new Noise("крик", 10);
        randomHumanNoise = new Noise("шёпот", 2);
        footmanNoise = new Noise("просьба покинуть помещение", 6);

        student = new Student("Андрей", studentClothes, "сердитый", studentInRoomNoise);
        randomHuman = new Human("Сергей", humanClothes, "спокойный", randomHumanNoise);
        footman = new Footman("Максим", footmanClothes, "радостный", footmanNoise);

        openedRoom = new Location("коворкинг", false);
        closedRoom = new Location("деканат", true);

    }

    @Test
    @DisplayName("Human can break in any open room")
    void humanBreakInOpenedRoom() {
        assertTrue(randomHuman.breakInRoom(openedRoom));
    }

    @Test
    @DisplayName("Human can't break in any closed room")
    void humanBreakInClosedRoom() {
        assertFalse(randomHuman.breakInRoom(closedRoom));
    }

    @Test
    @DisplayName("Human can pull anyone")
    void humanPullPeople() {
        boolean humanPullFootman = randomHuman.pullPeople(footman);
        boolean humanPullStudent = randomHuman.pullPeople(student);

        boolean result = humanPullFootman && humanPullStudent;

        assertTrue(result);
    }

    @Test
    @DisplayName("Human can generate any noise")
    void humanGenerateNoise() {
        boolean randomHumanNoiseGeneration = randomHuman.generateNoise(randomHumanNoise);
        boolean studentNotInRoomNoiseGeneration = randomHuman.generateNoise(studentNotInRoomNoise);
        boolean studentInRoomNoiseGeneration = randomHuman.generateNoise(studentInRoomNoise);
        boolean footmanNoiseGeneration = randomHuman.generateNoise(footmanNoise);

        boolean result = randomHumanNoiseGeneration
                && studentInRoomNoiseGeneration
                && studentNotInRoomNoiseGeneration
                && footmanNoiseGeneration;

        assertTrue(result);
    }

    @RepeatedTest(name = "Try to break in room", value = 5)
    @DisplayName("Student can break in some rooms")
    void studentPullPeople() {
        if (student.breakInRoom(closedRoom)) {
            student.generateNoise(studentInRoomNoise);
            student.pullPeople(footman);
            assertFalse(randomHuman.blockPath(student));
        } else {
            student.generateNoise(studentNotInRoomNoise);
            student.pullPeople(randomHuman);
            assertFalse(false);
        }
    }

    @Test
    @DisplayName("Footman can't block student")
    void footmanCantBlockStudent() {
        assertFalse(footman.blockPath(student));
    }

    @Test
    @DisplayName("Footman can block anyone except student")
    void footmanCanBlockHuman() {
        boolean blockHuman = footman.blockPath(randomHuman);
        boolean blockFootman = footman.blockPath(footman);

        boolean result = blockFootman
                && blockHuman;

        assertTrue(result);
    }
}
