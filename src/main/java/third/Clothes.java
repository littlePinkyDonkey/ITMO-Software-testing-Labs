package third;

public class Clothes {
    private String color;
    private String clothesName;
    private String clothesQuality;

    public Clothes() {
    }
    public Clothes(String color, String clothesName, String clothesQuality) {
        this.color = color;
        this.clothesName = clothesName;
        this.clothesQuality = clothesQuality;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getClothesName() {
        return clothesName;
    }
    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getClothesQuality() {
        return clothesQuality;
    }
    public void setClothesQuality(String clothesQuality) {
        this.clothesQuality = clothesQuality;
    }

    @Override
    public String toString() {
        return this.clothesName;
    }
}
