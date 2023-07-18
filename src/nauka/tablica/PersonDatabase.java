package nauka.tablica;

import java.util.Arrays;

public class PersonDatabase {

    private final static int INITIOAL_CAPACITY = 1;
    Person[] pesrons = new Person[INITIOAL_CAPACITY];

    private int emptyPlace;

    public void add(Person p){
        if (p == null){
            throw new NullPointerException("peeson cannot be  null");
        }
        if (emptyPlace == pesrons.length){
            pesrons = Arrays.copyOf(pesrons, pesrons.length *2);
        }
        pesrons[emptyPlace] = p;
        emptyPlace++;
    }
    public void remove(Person p){
        if (p == null){
            throw new NullPointerException("peeson cannot be  null");
        }
        final int notFound = -1;
        int foundIndex = notFound;
        for (int i = 0; i < emptyPlace && foundIndex == notFound; i++) {
            if (p.equals(pesrons[i])){
                foundIndex = i;
            }
        }
        if (foundIndex != notFound){
            System.arraycopy(pesrons,foundIndex + 1,pesrons, foundIndex, pesrons.length - foundIndex - 1);
            emptyPlace --;
            pesrons[emptyPlace] = null;
        }
    }

    public Person get(int index){
        if (index >= emptyPlace || emptyPlace < 0)
            throw new ArrayIndexOutOfBoundsException("!!!");
        return pesrons[index];
    }

    public int size(){
        return emptyPlace;

    }
}
