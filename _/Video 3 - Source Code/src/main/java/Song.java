import java.util.*;

public class Song {
    private final String name;
    private Map<Author, SongInformation> songInformation = new HashMap<Author, SongInformation>();
    private Album album;
    private List<Listener> listeners = new ArrayList<Listener>();
    private List<Playlist> appearsOnPlaylists = new ArrayList<>();

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SongInformation getSongInformation(Author author) {
        return songInformation.get(author);
    }

    public Collection<SongInformation> getAllSongInformation() {
        return songInformation.values();
    }

    public void addInformation(SongInformation songInformation) {
        this.songInformation.put(songInformation.getAuthor(), songInformation);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    public void listen(Listener listeners) {
        listeners.addListenedToSong(this);
        this.listeners.add(listeners);
    }

    public List<Playlist> getAppearsOnPlaylists() {
        return appearsOnPlaylists;
    }

    public void addPlaylistItAppearsOn(Playlist playlist) {
        this.appearsOnPlaylists.add(playlist);
    }

    public static Song comparePopularity(Song song1, Song song2) {
        int listenersForFirstSong = song1.getListeners().size();
        int listenersForSecondSong = song2.getListeners().size();

        if(listenersForFirstSong > listenersForSecondSong) {
            return song1;
        } else {
            return song2;
        }
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", songInformation=" + songInformation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (name != null ? !name.equals(song.name) : song.name != null) return false;
        return album != null ? album.equals(song.album) : song.album == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (album != null ? album.hashCode() : 0);
        return result;
    }
}
