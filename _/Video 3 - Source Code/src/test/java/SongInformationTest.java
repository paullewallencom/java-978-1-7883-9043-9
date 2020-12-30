import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SongInformationTest {
    @Test
    public void fromCsvRecord() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        FileReader fileReader = new FileReader("src/test/resources/songInformation.csv");
        Iterable<CSVRecord> csvRecords = new CSVParser(fileReader, csvFormat);

        List<SongInformation> recordList = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            SongInformation songInformation = SongInformation.fromCsvRecord(csvRecord);
            recordList.add(songInformation);
        }
        fileReader.close();

        assertEquals(2, recordList.size());
        assertEquals("Author 1", recordList.get(0).getAuthor().getName());
        assertEquals("First song", recordList.get(0).getSongTitle());
        assertEquals("Second song", recordList.get(1).getSongTitle());
    }

    @Test
    public void toCsvRow() throws Exception {
        SongInformation songInformation = new SongInformation("Test song",
                2017,
                10,
                new Author("Test Author"));
        SongInformation songInformation2 = new SongInformation("Test song 2",
                2017,
                10,
                new Author("Test Author"));

        FileWriter fileWriter = new FileWriter("src/test/resources/outputSongInformation.csv");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader(SongInformation.CSV_FILE_HEADERS);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        csvPrinter.printRecord(songInformation.toCsvRow());
        csvPrinter.printRecord(songInformation2.toCsvRow());
        csvPrinter.close();
        fileWriter.close();

        //Test the contents
        List<String> fileLines = Files.readAllLines(Paths.get("src/test/resources/outputSongInformation.csv"));
        assertEquals(3, fileLines.size());
        assertEquals("songTitle,releaseYear,rating,author", fileLines.get(0));
        assertEquals("Test song,2017,10,Test Author", fileLines.get(1));
        assertEquals("Test song 2,2017,10,Test Author", fileLines.get(2));
    }

}