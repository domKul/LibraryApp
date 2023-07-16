package pl.library.service;

import pl.library.model.Book;
import pl.library.model.Magazine;
import pl.library.model.Publication;
import pl.library.service.io.ConsolPrint;

import java.io.Serializable;


public class Library implements Serializable {


    private static final int MAX_PUBLICATIONS = 100;
    private int publicationNumber;

    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    private  ConsolPrint consolPrint;



    public Library() {
    }

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationNumber];
        for (int i = 0; i < result.length; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addPublication(Publication publication){
        if (publicationNumber >= MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("No empty place");
        }
        publications[publicationNumber] = publication;
        publicationNumber++;


    }


}
