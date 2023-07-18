package pl.library.service;

import pl.library.model.Publication;

import java.io.Serializable;
import java.util.Arrays;


public class Library implements Serializable {


    private static final int INITIOAL_CAPACITY = 1;
    private int publicationNumber;

    private Publication[] publications = new Publication[INITIOAL_CAPACITY];


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
        if (publicationNumber == publications.length){
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationNumber] = publication;
        publicationNumber++;


    }

    public boolean removePublication(Publication publication){
        final int notFound = -1;
        int found = notFound;
        int i = 0;
        while (i < publicationNumber && found == notFound){
            if (publication.equals(publications[i])){
                found = i;
            }else {
                i++;
            }
        }
        if (found != notFound){
            System.arraycopy(publications, found + 1, publications, found, publications.length - found -1);
            publicationNumber--;
            publications[publicationNumber] = null;
            return true;
        }
        return false;
    }


}
