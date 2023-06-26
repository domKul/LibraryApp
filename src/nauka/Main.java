package nauka;

import java.util.Scanner;

public class Main {

    public static boolean isPalindrom(String tt){
        tt = tt.replaceAll("\\s+","").toLowerCase();
        for (int i = 0; i < tt.length(); i++) {
            char z = tt.charAt(i);
            char zd = tt.charAt(tt.length() -1 -i);

            if (z != zd){
                return false;
            }
        }
        return true;
    }

    public static void printFibonacciSequence(int n) {
        long prev1 = 0;
        long prev2 = 1;

        System.out.print(prev1 + " ");

        for (int i = 1; i < n; i++) {
            System.out.print(prev2 + " ");

            long next = prev1 + prev2;
            prev1 = prev2;
            prev2 = next;
        }
    }

    public static long fibonacci(long n){
        if (n==1 || n==2){
            return 1;
        }
        return fibonacci(n -1) + fibonacci(n - 2);
    }


    public static void sumaWczytana() {
        int next = 0;
        int sum = 0;

        Scanner sc = new Scanner(System.in);

        while ((next = sc.nextInt()) <=100) {
            sum += next;
        }

            if ( sum % 2 == 0) {
                System.out.println( sum +"parzysta");
            }else {
                System.out.println( sum +"nieparzysta");
            }


    }

    public static void main(String[] args) {

        sumaWczytana();





    }
}
