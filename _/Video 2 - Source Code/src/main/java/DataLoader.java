import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataLoader {
    public static Set<Artist> loadData() throws IOException {
        Map<String, Artist> artists = new HashMap<>();
        Map<String, Album> albums = new HashMap<>();

        List<String> linesInArtistsFile = Files.readAllLines(Paths.get("src/main/resources/artists.txt"));
        for (String line : linesInArtistsFile) {
            String[] lineElements = line.split(" ");
            String artistName = lineElements[0];
            String albumName = lineElements[1];

            artists.putIfAbsent(artistName, new SingleArtist(artistName));

            Album album = new StandardAlbum(albumName);
            artists.get(artistName).addAlbum(album);
            albums.put(albumName, album);
        }

        List<String> linesInSongsFile = Files.readAllLines(Paths.get("src/main/resources/songs.txt"));
        for (String line : linesInSongsFile) {
            String[] lineElements = line.split(" ");
            String albumName = lineElements[0];
            String songName = lineElements[1];

            Album album = albums.get(albumName);
            album.addSong(new Song(songName));
        }
        return new HashSet<>(artists.values());
    }

    public static void main(String[] args) {
        try {
            Set<Artist> artists = loadData();
            System.out.println("artists = " + artists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
