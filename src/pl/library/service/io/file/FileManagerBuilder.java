package pl.library.service.io.file;

import pl.library.exception.NoSuchFielTypeException;
import pl.library.service.DataReader;
import pl.library.service.io.ConsolPrint;

public class FileManagerBuilder {

    private final ConsolPrint consolPrint;
    private final DataReader dataReader;

    public FileManagerBuilder(ConsolPrint consolPrint, DataReader dataReader) {
        this.consolPrint = consolPrint;
        this.dataReader = dataReader;
    }

    public FileMenager build(){
        consolPrint.printLine("Get file type");
        FileType fileType = getFileType();
        switch (fileType){
            case SERIAL -> {
                return new SerializableFileMenager();
            }default -> throw new NoSuchFielTypeException("Wrong file type");
        }
    }

    private FileType getFileType() {
        boolean typeOK = false;
        FileType result = null;
        do {
            printType();
             String type = dataReader.getString().toUpperCase();
            try{
               result = FileType.valueOf(type);
               typeOK = true;
            }catch (IllegalArgumentException e ){
                consolPrint.printLine("Wrong data type");
            }

        }while (!typeOK);
        return result;
    }

    private void printType(){
        for (FileType value : FileType.values()) {
            consolPrint.printLine(value.name());
        }

    }
}
