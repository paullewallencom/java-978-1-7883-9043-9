public class EPAlbum extends AbstractAlbum {
    public final static String RELEASE_TYPE = "EP";

    public EPAlbum(String albumName) {
        super(albumName);
    }

    @Override
    public String toString() {
        return "EPAlbum{" +
                "albumName='" + albumName + '\'' +
                ", songs=" + songs +
                '}';
    }
}
