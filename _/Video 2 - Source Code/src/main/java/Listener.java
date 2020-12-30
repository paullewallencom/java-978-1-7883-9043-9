import java.util.ArrayList;
import java.util.List;

public class Listener {
    private List<Song> listenedToSong = new ArrayList<Song>();
    private List<Playlist> playlists = new ArrayList<>();

    public List<Song> getListenedToSong() {
        return listenedToSong;
    }

    public void addListenedToSong(Song listenedToSong) {
        this.listenedToSong.add(listenedToSong);
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
