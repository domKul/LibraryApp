package pl.library.service.io.file;

import pl.library.exception.NoSuchFielTypeException;
import pl.library.service.DataReader;
import pl.library.service.io.ConsolPrint;

public class FileManagerBuilder {

    private  ConsolPrint consolPrint;
    private  DataReader dataReader;


    public FileManagerBuilder(ConsolPrint printer, DataReader reader) {
        this.consolPrint = printer;
        this.dataReader = reader;
    }

    public FileManager build() {
        consolPrint.printLine("Wybierz format danych:");
        FileType fileType = getFileType();
        switch (fileType) {
            case SERIAL:
                return new SerializableFileManager();
            case CSV:
                return new CsvFileManager();
            default:
                throw new NoSuchFielTypeException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType() {
        boolean typeOk = false;
        FileType result = null;
        do {
            printTypes();
            String type = dataReader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                typeOk = true;
            } catch (IllegalArgumentException e) {
                consolPrint.printLine("Nieobsługiwany typ danych, wybierz ponownie.");
            }
        } while (!typeOk);

        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            consolPrint.printLine(value.name());
        }
    }
}
