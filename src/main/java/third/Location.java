package third;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private String placeName;
    private boolean isClosed;

    @Override
    public String toString() {
        return this.placeName;
    }
}
