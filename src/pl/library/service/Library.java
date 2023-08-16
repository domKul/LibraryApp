package pl.library.service;

import pl.library.exception.PublicationAlreadyExistException;
import pl.library.exception.UserAlreadyExistException;
import pl.library.model.LibraryUser;
import pl.library.model.Publication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Library implements Serializable {
    private Map<String,Publication>publications = new HashMap<>();
    private Map<String, LibraryUser>users = new HashMap<>();

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public void addPublication(Publication publication){
       if(publications.containsKey(publication.getTitle())){
           throw new PublicationAlreadyExistException("Publication already exist" + publication.getTitle());
        }
        publications.put(publication.getTitle(),publication);
    }

    public void addUser(LibraryUser user){
        if(users.containsKey(user.getPesel())){
            throw new UserAlreadyExistException("Uzytkownik juz istnieje" + user.getPesel() );
        }
        users.put(user.getPesel(), user);
    }

    public boolean removePublication(Publication publication){
        if(publications.containsValue(publication)){
            publications.remove(publication.getTitle());
            return true;
        }
        return false;
    }


}
