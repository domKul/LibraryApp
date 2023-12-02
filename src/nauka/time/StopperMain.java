package nauka.time;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class StopperMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nacisnij enter zeby zacac");
        sc.nextLine();
        Instant now1 = Instant.now();

        System.out.println("enter zeby zatrzymac");

        sc.nextLine();
        Instant now2 = Instant.now();
        Duration between = Duration.between(now1, now2);
        System.out.println("czas miedzy startem a koncem to " + between.getSeconds());



    }
}
