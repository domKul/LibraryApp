package nauka.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RandomLambdaMain {

    public static void main(String[] args) {
        Random r = new Random();

        List<Integer>randomNumbers = new ArrayList<>();

        generate(randomNumbers,10,()->r.nextInt(1000));
        consumer(randomNumbers,x-> System.out.print(x + " "));
        System.out.println();
        findList(randomNumbers,x->x % 2  ==0);
        consumer(randomNumbers,x-> System.out.print(x + " "));

    }

    private static <T> void generate (List<T> list,int toGenerate, Supplier<T> supplier){
        for (int i = 0; i < toGenerate; i++) {
            list.add(supplier.get());

        }
    }

    private static <T> void consumer(List<T>list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }
    private static <T> void findList(List<T>list, Predicate<T> predicate){
        Iterator<T> it = list.iterator();
        while (it.hasNext()){
            T tmp = it.next();
             if (predicate.test(tmp)){
                 it.remove();
             }
        }
    }
}
