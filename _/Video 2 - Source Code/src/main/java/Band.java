public class Band extends AbstractArtist {
    public static final String ARTIST_TYPE = "Band";

    public Band(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Band{" +
                "name='" + name + '\'' +
                '}';
    }


}
