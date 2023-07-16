package pl.library.app;

import pl.library.exception.ExportDataException;
import pl.library.exception.ImportDataException;
import pl.library.exception.WrongNumberException;
import pl.library.model.Book;
import pl.library.model.Publication;
import pl.library.service.Library;
import pl.library.model.Magazine;
import pl.library.service.DataReader;
import pl.library.service.io.ConsolPrint;
import pl.library.service.io.file.FileManagerBuilder;
import pl.library.service.io.file.FileManager;

import java.util.InputMismatchException;


public class LibraryControll {

    private ConsolPrint consolPrint = new ConsolPrint();
    private DataReader dataReader = new DataReader(consolPrint);
    private Library library ;
    private final FileManager fileManager;

     LibraryControll() {
       fileManager = new FileManagerBuilder(consolPrint,dataReader).build();
       try{
           library = fileManager.importData();
       }catch (ImportDataException e){
           consolPrint.printLine(e.getMessage());
           consolPrint.printLine("New data loaded");
           library = new Library();
       }
    }

    private void startAppInfo(){
        for (Choice value : Choice.values()) {
            System.out.println(value);

        }
    }

     void controllLoop(){
        Choice option;
        do {
            startAppInfo();
            option =    getChoice();
            switch(option){
                case SAVE_BOOK -> saveBook();
                case READ_BOOK -> readBookList();
                case SAVE_MAGAZINE -> saveMagazine();
                case READ_MAGAZINE -> readMagazineList();
                case EXIT -> exit();
                default -> consolPrint.printLine("Wrong Number");
            }
        }while (option != Choice.EXIT);

    }

    private Choice getChoice(){
        boolean ok = false;
        Choice choice = null;
        while(!ok){
            try{
                choice = Choice.createfromNumber(dataReader.getInt());
                ok = true;
            }catch (WrongNumberException e){
                consolPrint.printLine(e.getMessage());
            }catch (InputMismatchException e){
                consolPrint.printLine( "only numbers can by type");
            }
        }
        return choice;
    }

    private void exit() {
         try{
             fileManager.exportData(library);
             consolPrint.printLine("Data exported");
         }catch (ExportDataException e) {
             consolPrint.printLine(e.getMessage());
         }
       consolPrint.printLine("Good Bye");
        dataReader.closeScanner();
    }

    private void readBookList() {
        Publication[] get =library.getPublications();
        consolPrint.readBook(get);

    }
    private void readMagazineList() {
        Publication[] get =library.getPublications();
        consolPrint.readMagazine(get);
    }

    private void saveBook() {
        try{
            Book book = dataReader.createBook();
            library.addPublication(book);
        }catch (InputMismatchException e){
            consolPrint.printLine(" wrong data type");
        }
    }
    private void saveMagazine() {
        try {
            Magazine magazine = dataReader.createMagazine();
            library.addPublication(magazine);
        }catch (InputMismatchException e ){
            consolPrint.printLine(" wrong data type");
        }
    }

   private enum Choice {
        EXIT(0," for EXIT"),
        READ_BOOK(1," for read list of books"),
        SAVE_BOOK(2," for save book in list"),
        SAVE_MAGAZINE(3," for save magazine in list"),
        READ_MAGAZINE(4, " for read magazine in list");

        private final int number;
        private final String description;

        Choice(int number, String description) {
            this.number = number;
            this.description = description;
        }

        public int getNumber() {
            return number;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }

        static Choice createfromNumber(int number) throws WrongNumberException{
            try {
                return Choice.values()[number];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new WrongNumberException("Wrong number");
            }

        }
    }
}
