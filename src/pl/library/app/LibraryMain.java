package pl.library.app;

import java.util.ArrayList;

public class LibraryMain {
    private static final String APP_VERSION = "Biblioteka v1.0";

    public static void main(String[] args) {
        LibraryControll libraryControll = new LibraryControll();
        System.out.println(APP_VERSION);
        libraryControll.controllLoop();
    }
}
