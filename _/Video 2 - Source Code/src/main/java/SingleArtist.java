public class SingleArtist extends AbstractArtist {
    public static final String ARTIST_TYPE = "Single Artist";

    public SingleArtist(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SingleArtist{" +
                "albums=" + albums +
                ", name='" + name + '\'' +
                '}';
    }
}
