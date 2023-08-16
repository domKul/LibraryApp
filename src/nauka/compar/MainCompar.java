package nauka.compar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

//        try {
//            Offer[] offers = OfferReader.readOffers("Offer.csv");
//            Arrays.sort(offers);
//            for (Offer offer : offers) {
//                System.out.println(offer);
//
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Brak pliku");
//        }


        List<?> arr = Arrays.asList(2,2,"2",2);
        sum(arr);
        String names = "ada ada ada";
        StringBuilder stringBuilder = new StringBuilder(names);
        names.split(" ");


    }

    //najmniejsza i najwieksza liczba
    public static String highAndLow(String numbers) {
        String[] numArray = numbers.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String num : numArray) {
            int n = Integer.parseInt(num);
            if (n < min) {
                min = n;
            }
            if (n > max) {
                max = n;
            }
        }

        return max + " " + min;
    }


    public static int sum(List<?> list){
        int sum = 0;
        for (Object o : list) {
            if(o instanceof String){
                sum += Integer.parseInt((String) o);
            }else if (o instanceof Integer){
                sum += (Integer) o;
            }
        }
        return  sum;

    }




}
