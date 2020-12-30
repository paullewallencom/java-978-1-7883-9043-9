public class StandardAlbum extends AbstractAlbum {
    public static final String RELEASE_TYPE = "Standard album";

    public StandardAlbum(String albumName) {
        super(albumName);
    }

    @Override
    public String toString() {
        return "StandardAlbum{" +
                "albumName='" + albumName + '\'' +
                ", songs=" + songs +
                '}';
    }
}
