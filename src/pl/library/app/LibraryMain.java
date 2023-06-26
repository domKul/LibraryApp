package pl.library.app;

public class LibraryMain {
    private static final String APP_VERSION = "Biblioteka v0.4";

    public static void main(String[] args) {

        LibraryControll libraryControll = new LibraryControll();
        System.out.println(APP_VERSION);
        libraryControll.controllLoop();







    }
}
