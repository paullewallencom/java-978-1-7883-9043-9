import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAlbum implements Album {
    protected List<Song> songs = new ArrayList<Song>();
    private Artist artist;
    protected String albumName;

    public AbstractAlbum(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Song getSong(int id) {
        return songs.get(id);
    }

    public void addSong(Song song) {
        song.setAlbum(this);
        this.songs.add(song);
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractAlbum that = (AbstractAlbum) o;

        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        return albumName != null ? albumName.equals(that.albumName) : that.albumName == null;
    }

    @Override
    public int hashCode() {
        int result = artist != null ? artist.hashCode() : 0;
        result = 31 * result + (albumName != null ? albumName.hashCode() : 0);
        return result;
    }
}
