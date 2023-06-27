package pl.library.service.io.file;

import pl.library.exception.ExportDataException;
import pl.library.exception.ImportDataException;
import pl.library.service.Library;

import java.io.*;


public class SerializableFileMenager implements FileMenager {

    public static final String FILE_NAME = "Library.l";
    @Override
    public Library importData() {
        try(
                FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ){
            return (Library) objectInputStream.readObject();
        }catch (IOException e){
            throw new ImportDataException("read file problem " + e.getMessage());
        }catch (ClassNotFoundException e ){
            throw new ImportDataException("Wrong data in fail");
        }
    }

    @Override
    public void exportData(Library library) {
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ){
            objectOutputStream.writeObject(library);
        }catch (FileNotFoundException e){
            throw new ExportDataException("No file found" + FILE_NAME);
        }catch (IOException e){
            throw new ExportDataException("Problem with save data");
        }

    }
}
