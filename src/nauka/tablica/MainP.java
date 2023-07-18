package nauka.tablica;

public class MainP {

    public static void main(String[] args) {
        PersonDatabase personDatabase = new PersonDatabase();
        personDatabase.add(new Person("asdas", "adsad", "1234567"));
        personDatabase.add(new Person("asdas2", "adsad2", "12345678"));
        int size = personDatabase.size();
        System.out.println(size);
        personDatabase.get(0);
        personDatabase.remove(new Person("asdas", "adsad", "1234567"));
        int size1 = personDatabase.size();
        System.out.println(size1);
    }
}
