package third;

public class Noise {
    private String noiseName;
    private int loud;

    public Noise() {
    }
    public Noise(String noiseName, int loud) {
        this.noiseName = noiseName;
        this.loud = loud;
    }

    public String getNoiseName() {
        return noiseName;
    }
    public void setNoiseName(String noiseName) {
        this.noiseName = noiseName;
    }

    public int getLoud() {
        return loud;
    }
    public void setLoud(int loud) {
        this.loud = loud;
    }

    @Override
    public String toString() {
        return this.noiseName;
    }
}
