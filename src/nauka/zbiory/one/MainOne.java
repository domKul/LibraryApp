package nauka.zbiory.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class MainOne {
    public static void main(String[] args) {
        final String txtName = "namespl.txt";

        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        try(Scanner sc = new Scanner(new File(txtName))){
            while(sc.hasNextLine()){
                set.add(sc.nextLine());
            }
            System.out.println(set.size());
            System.out.println(set.first());
            System.out.println(set.last());

        }catch(FileNotFoundException e){
            System.out.println("Wrong file name " + txtName);

        }

    }
}
