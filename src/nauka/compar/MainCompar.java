package nauka.compar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

public class MainCompar {
    public static void main(String[] args) {
//        Integer[] numbers ={12, 13, 13 ,1, 2, 3, 5, 4, 9, 66, 15, 15, 10, 17, 19, 7, 8 };
//
//        System.out.println(Arrays.toString(numbers));
//        Arrays.sort(numbers);
//
//        System.out.println("sortowanie");
//
//        System.out.println(Arrays.toString(numbers));
//        Arrays.sort(numbers, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return  o2.compareTo(o1);
//            }
//        });
//        System.out.println(Arrays.toString(numbers));
//

        try {
            Offer[] offers = OfferReader.readOffers("Offer.csv");
            Arrays.sort(offers);
            for (Offer offer : offers) {
                System.out.println(offer);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku");
        }


    }



}
