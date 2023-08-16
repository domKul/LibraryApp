package pl.library.service;

import pl.library.model.Book;
import pl.library.model.LibraryUser;
import pl.library.model.Magazine;
import pl.library.service.io.ConsolPrint;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private  ConsolPrint consolPrint;

    public DataReader(ConsolPrint consolPrint) {
        this.consolPrint = consolPrint;
    }

    public Book createBook() {
        consolPrint.printLine("Title:");
        String title = sc.nextLine();
        consolPrint.printLine("Author:");
        String author = sc.nextLine();
        consolPrint.printLine("Release Date:");
        int releaseDate = getInt();
        consolPrint.printLine("Pages");
        int pages = getInt();
        consolPrint.printLine("Publisher");
        String publisher = sc.nextLine();
        consolPrint.printLine("ISBN");
        String isbn = sc.nextLine();
        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine createMagazine() {
        consolPrint.printLine("Title: ");
        String title = sc.nextLine();
        consolPrint.printLine("Publisher:");
        String publisher = sc.nextLine();
        consolPrint.printLine("Year: ");
        int year = getInt();
        consolPrint.printLine("Month: ");
        int month = getInt();
        consolPrint.printLine("Day: ");
        int day = getInt();
        consolPrint.printLine("Language: ");
        String language = sc.nextLine();
        return new Magazine(title, publisher, year, month, day, language);
    }

    public int getInt() {
        try{
            return sc.nextInt();
        }finally {
            sc.nextLine();
        }
    }
    public LibraryUser createLibraryUser(){
        consolPrint.printLine("imie");
        String firstName = sc.nextLine();
        consolPrint.printLine("nazwisko");
        String lastName = sc.nextLine();
        consolPrint.printLine("pesel");
        String pesel = sc.nextLine();

        return new LibraryUser(firstName, lastName, pesel);
    }

    public String getString(){
        return sc.nextLine();
    }

    public void closeScanner() {
        sc.close();
    }


}
