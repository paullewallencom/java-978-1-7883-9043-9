import org.apache.commons.csv.CSVRecord;

import java.util.Arrays;
import java.util.List;

public class SongInformation {
    private final String songTitle;
    private final Integer releaseYear;
    private final Integer rating;
    private final Author author;
    public static final String[] CSV_FILE_HEADERS
            = new String[]{"songTitle", "releaseYear", "rating", "author"};

    public SongInformation(String songTitle, Integer releaseYear, Integer rating, Author author) {
        this.songTitle = songTitle;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.author = author;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Integer getRating() {
        return rating;
    }

    public Author getAuthor() {
        return author;
    }

    public static SongInformation fromCsvRecord(CSVRecord csvRecord) {
        String songTitle = csvRecord.get("songTitle");
        int releaseYear = Integer.parseInt(csvRecord.get("releaseYear"));
        int rating = Integer.parseInt(csvRecord.get("rating"));
        Author author = new Author(csvRecord.get("author"));
        return new SongInformation(songTitle, releaseYear, rating, author);
    }

    public List<String> toCsvRow() {
        return Arrays.asList(songTitle,
                Integer.toString(releaseYear),
                Integer.toString(rating),
                author.getName());
    }

    @Override
    public String toString() {
        return "SongInformation{" +
                "songTitle='" + songTitle + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongInformation that = (SongInformation) o;

        if (songTitle != null ? !songTitle.equals(that.songTitle) : that.songTitle != null) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        return author != null ? author.equals(that.author) : that.author == null;
    }

    @Override
    public int hashCode() {
        int result = songTitle != null ? songTitle.hashCode() : 0;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
