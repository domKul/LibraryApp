package nauka.lambda;

import java.util.*;

public class ReferenceMain {

    private static List<String> manes = new ArrayList<>();


    public static void main(String[] args) {
      manes.add("Marcin");
manes.add("Rafał");
        manes.add("Paweł");
        manes.add("Robert");
        manes.add("Adam");

        manes.sort(String::compareToIgnoreCase);
        System.out.println(manes);

    }


}
