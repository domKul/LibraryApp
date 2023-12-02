package pl.library.service.io;

import pl.library.model.Book;
import pl.library.model.LibraryUser;
import pl.library.model.Magazine;
import pl.library.model.Publication;

import java.util.Collection;
import java.util.stream.Stream;


public class ConsolPrint {


    public void readMagazine(Collection<Publication> publication) {
        long count = publication.stream()
                .filter(m -> m instanceof Magazine)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();
        if (count ==0){
            System.out.println("No publication found");
        }
    }

    public void readBook(Collection<Publication> publication) {
        long count = publication.stream()
                .filter(p -> p instanceof Book)
                .map(Publication::toString)
                .peek(this::printLine)
                .count();
        if (count == 0){
            System.out.println("No books found");
        }
    }

    public void readUsers(Collection<LibraryUser> libraryUsers){
        libraryUsers.stream()
                .map(LibraryUser::toString)
                .forEach(this::printLine);
    }

    public void printLine(String text){
        System.out.println(text);
    }

}
