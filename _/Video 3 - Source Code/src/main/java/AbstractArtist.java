import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArtist implements Artist {
    protected List<Album> albums = new ArrayList<Album>();
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    public AbstractArtist(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void addAlbum(Album album) {
        album.setArtist(this);
        albums.add(album);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractArtist that = (AbstractArtist) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
