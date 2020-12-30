import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CliDataLoader {

    public static Set<Artist> loadData() throws IOException {
        Map<String, Artist> artists = new HashMap<>();
        Map<String, Album> albums = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your command. Type 'exit' to quit: ");
        String nextLine = scanner.nextLine();

        while(true) {
            if("exit".equalsIgnoreCase(nextLine)) {
                break; //Will exit the while loop
            }

            String prefix = nextLine.split(" ")[0];
            if("artist".equalsIgnoreCase(prefix)) {
                extractArtistAndAlbum(artists, albums, nextLine);
            } else if ("album".equalsIgnoreCase(prefix)) {
                extractAlbumAndSong(albums, nextLine);
            }
            nextLine = scanner.nextLine();
        }

        return new HashSet<>(artists.values());
    }

    private static void extractAlbumAndSong(Map<String, Album> albums, String line) {
        String[] lineElements = line.split(" ");
        String albumName = lineElements[1];
        String songName = lineElements[2];

        Album album = albums.get(albumName);
        album.addSong(new Song(songName));
    }

    private static void extractArtistAndAlbum(Map<String, Artist> artists, Map<String, Album> albums, String line) {
        String[] lineElements = line.split(" ");
        String artistName = lineElements[1];
        String albumName = lineElements[2];

        artists.putIfAbsent(artistName, new SingleArtist(artistName));

        Album album = new StandardAlbum(albumName);
        artists.get(artistName).addAlbum(album);
        albums.put(albumName, album);
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
