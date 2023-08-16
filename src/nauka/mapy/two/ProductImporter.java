package nauka.mapy.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProductImporter {

    static Map<String, TreeSet<Product>> readFile(String filename) throws FileNotFoundException {
        Map<String,TreeSet<Product>> productsMap = new HashMap<>();
        try(Scanner sc = new Scanner(new File(filename))){
            sc.nextLine();
            while(sc.hasNextLine()){
                String[] split = sc.nextLine().split(";");
                String category = split[0];
                Product product  = new Product(split[1],Double.parseDouble(split[2]));
                insertProductMap(productsMap, category, product);
            }
        }
        return productsMap;
    }

    private static void insertProductMap(Map<String, TreeSet<Product>> productsMap, String category, Product product) {
        if (productsMap.containsKey(category)){
            productsMap.get(category).add(product);
        }else{
            TreeSet<Product> categorySet = new TreeSet<>();
            categorySet.add(product);
            productsMap.put(category,categorySet);
        }
    }
}
