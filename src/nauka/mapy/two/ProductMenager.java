package nauka.mapy.two;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class ProductMenager {

    public static void main(String[] args) {
        try {
            Map<String, TreeSet<Product>> productsMap = ProductImporter.readFile("productList.csv");
            String categoty = readCategoryFromUser();
            printCategory(productsMap, categoty);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku");
        }
    }

    private static void printCategory(Map<String, TreeSet<Product>> productsMap, String categoty) {
        TreeSet<Product> products = productsMap.get(categoty);
        if(products == null){
            System.out.println("Brak productow");
        }else{
            printAll(products);
            printAvg(products);
            highAndLowPrice(products);
        }
    }

    private static void highAndLowPrice(TreeSet<Product> products) {
        System.out.println("Najwyzsza cena" + products.last());
        System.out.println("Najnizsza cena " + products.first());
    }

    private static void printAvg(TreeSet<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        double avg = sum / products.size();
        System.out.println("srednia " + avg);
    }



    private static void printAll(TreeSet<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }


    private static String readCategoryFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwe category");
        return sc.nextLine();
    }
}
