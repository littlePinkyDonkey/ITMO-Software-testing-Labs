package third;

public class Place {
    private String placeName;
    private boolean isClosed;

    public Place() {
    }
    public Place(String placeName, boolean isClosed) {
        this.placeName = placeName;
        this.isClosed = isClosed;
    }

    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return this.placeName;
    }
}
