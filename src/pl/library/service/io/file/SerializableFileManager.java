package pl.library.service.io.file;

import pl.library.exception.ExportDataException;
import pl.library.exception.ImportDataException;
import pl.library.service.Library;

import java.io.*;


public class SerializableFileManager implements FileManager {

    public static final String FILE_NAME = "Library.l";
    @Override
    public void exportData(Library library) {
        try (FileOutputStream fileOuptu = new FileOutputStream(FILE_NAME);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOuptu);
             ){
            objectOutputStream.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new ExportDataException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new ExportDataException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }

    @Override
    public Library importData() {
        try (FileInputStream fileInput = new FileInputStream(FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
             ) {
            return (Library) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new ImportDataException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new ImportDataException("Błąd odczytu pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new ImportDataException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }
}
