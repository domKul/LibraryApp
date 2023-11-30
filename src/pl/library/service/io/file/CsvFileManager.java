package pl.library.service.io.file;

import pl.library.exception.ExportDataException;
import pl.library.exception.ImportDataException;
import pl.library.exception.InvalidDataException;
import pl.library.model.*;
import pl.library.service.Library;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager{

    private static final String FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME = "Library_Users.csv";
    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);
        
        return library;
    }

    private void importUsers(Library library) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createUserFromString)
                    .forEach(library::addUser);
        } catch (FileNotFoundException e) {
            throw new ImportDataException("No file " + USERS_FILE_NAME);
        } catch (IOException e) {
            throw new ImportDataException("IO exception error");
        }
    }

    private LibraryUser createUserFromString(String csvText) {
        String[] split = csvText.split(";");
        String firstName = split[0];
        String lastName = split[1];
        String pesel = split[2];
        return new LibraryUser(firstName, lastName, pesel);

    }

    private void importPublications(Library library) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(library::addPublication);
        } catch (FileNotFoundException e) {
            throw new ImportDataException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        exportPublications(library);
        exportUsers(library);
        

    }

    private void exportUsers(Library library) {
        Collection<LibraryUser> libraryUsers = library.getUsers().values();
        exportToCsv(libraryUsers, USERS_FILE_NAME);
    }

    private void exportPublications(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        exportToCsv(publications, FILE_NAME);
    }

    private<T extends  CsvConvertible> void exportToCsv(Collection<T> collection, String filename) {
        try(var fileWritter = new FileWriter(filename);
            var bufferderWritter = new BufferedWriter(fileWritter)) {
            for (T element : collection) {
                bufferderWritter.write(element.toCsv());
                bufferderWritter.newLine();
            }
        } catch (IOException e) {
            throw new ExportDataException("Cant save data to file" + filename);
        }
    }

}
