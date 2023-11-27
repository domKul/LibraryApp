package nauka.iterator;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PersonIterator {


    public static void main(String[] args) {
         Map<String, Person> persons = new TreeMap<>();

        Person person1 = new Person("adam", "kkk", 12);
        Person person2 = new Person("karol", "aaa", 12);
        Person person3 = new Person("dominik", "ccc", 12);

        persons.put(person1.getLastName(),person1);
        persons.put(person2.getLastName(),person2);
        persons.put(person3.getLastName(),person3);

        Iterator<Person> itr = persons.values().iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }







    }
}
