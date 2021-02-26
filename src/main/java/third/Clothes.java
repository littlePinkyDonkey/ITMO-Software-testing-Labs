package third;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Clothes {
    private String color;
    private String clothesName;
    private String clothesQuality;

    @Override
    public String toString() {
        return this.clothesName;
    }
}
