package pl.library.service.io.file;

import pl.library.exception.ExportDataException;
import pl.library.exception.ImportDataException;
import pl.library.exception.InvalidDataException;
import pl.library.exception.NoSuchFielTypeException;
import pl.library.model.Book;
import pl.library.model.Magazine;
import pl.library.model.Publication;
import pl.library.service.Library;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager{

    private static final String FILE_NAME = "Library.csv";
    @Override
    public Library importData() {
        Library library = new Library();
        try (Scanner fileReader = new Scanner(new File(FILE_NAME))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new ImportDataException("No file " + FILE_NAME);
        }
        return library;
    }

    private Publication createObjectFromString(String line) {
        String[] split = line.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)){
            return createBook(split);
        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataException("unknown publication" + type);
    }

    private Publication createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazine(title, publisher, year, month, day, language);
    }

    private Publication createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, author, year, pages, publisher, isbn);
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
