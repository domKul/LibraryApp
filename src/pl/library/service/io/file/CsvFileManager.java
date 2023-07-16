package pl.library.service.io.file;

import pl.library.exception.ExportDataException;
import pl.library.exception.NoSuchFielTypeException;
import pl.library.model.Publication;
import pl.library.service.Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileManager implements FileManager{

    private static final String FILE_NAME = "Library.csv";
    @Override
    public Library importData() {
        return null;
    }

    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try(var fileWritter = new FileWriter(FILE_NAME);
         var bufferderWritter = new BufferedWriter(fileWritter)) {
            for (Publication publication : publications) {
                bufferderWritter.write(publication.toCsv());
                bufferderWritter.newLine();
            }
        } catch (IOException e) {
            throw new ExportDataException("Cant save data to file" + FILE_NAME);
        }

    }
}
