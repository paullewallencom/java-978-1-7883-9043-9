import java.util.List;

public interface Album {
    List<Song> getSongs();
    Song getSong(int id);
    void addSong(Song song);
    void setArtist(Artist artist);
    Artist getArtist();

    static Album comparePopularity(Album album1, Album album2) {
        int album1Popularity = 0;
        int album2Popularity = 0;
        for (Song song : album1.getSongs()) {
            album1Popularity = album1Popularity + song.getListeners().size();
        }
        for (Song song : album2.getSongs()) {
            album2Popularity = album2Popularity + song.getListeners().size();
        }

        if(album1Popularity > album2Popularity) {
            return album1;
        } else {
            return album2;
        }
    }
}
