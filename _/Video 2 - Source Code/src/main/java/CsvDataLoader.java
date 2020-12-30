import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class CsvDataLoader {

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/resources/music.csv";

        Reader in = new FileReader(fileName);
        Iterable<CSVRecord> records = CSVFormat.EXCEL
                .withFirstRecordAsHeader()
                .parse(in);
        Map<String, Artist> artists = new HashMap<>();
        for (CSVRecord record : records) {
            String artistName = record.get("Artist");
            String albumName = record.get("Album");
            String songName = record.get("Song");

            artists.putIfAbsent(artistName, new SingleArtist(artistName));
            Artist artist = artists.get(artistName);
            int indexOfAlbum = artist.getAlbums().indexOf(new StandardAlbum(albumName));
            Song song = new Song(songName);

            if(indexOfAlbum != -1) { //Album already exists
                Album album = artist.getAlbums().get(indexOfAlbum);
                album.addSong(song);
            } else { //Album does not exist
                Album album = new StandardAlbum(albumName);
                album.addSong(song);
                artist.addAlbum(album);
            }


        }
        System.out.println("artists = " + artists);
    }
}
