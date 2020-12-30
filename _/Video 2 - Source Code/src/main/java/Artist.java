import java.util.List;

public interface Artist {
    List<Album> getAlbums();
    void addAlbum(Album album);
    String getName();
}
