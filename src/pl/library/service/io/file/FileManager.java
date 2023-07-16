package pl.library.service.io.file;

import pl.library.service.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
