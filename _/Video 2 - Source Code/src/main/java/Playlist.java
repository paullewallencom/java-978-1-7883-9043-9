import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Playlist {
    private final Listener owner;
    private Set<Song> songs = new LinkedHashSet<>();

    public Playlist(Listener owner) {
        this.owner = owner;
    }

    public Listener getOwner() {
        return owner;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        song.addPlaylistItAppearsOn(this);
        this.songs.add(song);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "owner=" + owner +
                ", songs=" + songs +
                '}';
    }
}
