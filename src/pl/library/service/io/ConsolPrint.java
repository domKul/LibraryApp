package pl.library.service.io;

import pl.library.model.Book;
import pl.library.model.Magazine;
import pl.library.model.Publication;


public class ConsolPrint {


    public void readMagazine(Publication[] publication) {
        int countMagazine = 0;
        for (Publication pub : publication) {
            if (pub instanceof Magazine){
                printLine(pub.toString());
                countMagazine++;
            }
        }
        if (countMagazine ==0){
            System.out.println("No publication found");
        }
    }

    public void readBook(Publication[] publication) {
        int counterBook = 0;
        for (Publication pub : publication) {
            if (pub instanceof Book){
                printLine(pub.toString());
                counterBook++;
            }
        }
        if (counterBook == 0){
            System.out.println("No books found");
        }
    }

    public void printLine(String text){
        System.out.println(text);
    }

}
