import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MyAppTest {
    @Test
    public void testMethod() {
        Song song = new Song("My favourite songs");

        Author author1 = new Author("First Author's name");
        SongInformation songInformation = new SongInformation("Title 1", 2017, 10, author1);

        Author author2 = new Author("Second Author's name");
        SongInformation songInformation2 = new SongInformation("Title 1 (Studio Version)", 2017, 10, author2);

        song.addInformation(songInformation);
        song.addInformation(songInformation2);

        Song song2 = new Song("Second track on this album");

        SongInformation songInformation3 = new SongInformation("Track 2", 2017, 8, author1);
        song2.addInformation(songInformation3);

        StandardAlbum standardAlbum = new StandardAlbum("My favourite album");
        standardAlbum.addSong(song);
        SingleArtist singleArtist = new SingleArtist("Singer name");
        singleArtist.addAlbum(standardAlbum);

        Album album2 = new StandardAlbum("Second album");
        album2.addSong(new Song("Song on second album"));

        String expectedToString = "SingleArtist{albums=[StandardAlbum{albumName='My favourite album', songs=[Song{name='My favourite songs', songInformation={Author{name='First Author's name'}=SongInformation{songTitle='Title 1', releaseYear=2017, rating=10, author=Author{name='First Author's name'}}, Author{name='Second Author's name'}=SongInformation{songTitle='Title 1 (Studio Version)', releaseYear=2017, rating=10, author=Author{name='Second Author's name'}}}}]}], name='Singer name'}";
        Assert.assertEquals(expectedToString, singleArtist.toString());
    }
}
