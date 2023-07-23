package nauka.compar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class OfferReader {
     private static final int OFFERS_IN_FILE = 10;

     static Offer[] readOffers(String fileName) throws FileNotFoundException {
         Offer[] fromFile = new Offer[OFFERS_IN_FILE];
         try(Scanner scanner = new Scanner(new File(fileName))){
             scanner.nextLine();
             for (int i = 0; i < OFFERS_IN_FILE; i++) {
                 fromFile[i] = offerCreate(scanner.nextLine());
             }
         }
         return fromFile;
     }

    private static Offer offerCreate(String s) {
        String[] split = s.split(";");
        return new Offer(split[0],Double.parseDouble(split[1]),Double.parseDouble(split[2]));
    }


}
