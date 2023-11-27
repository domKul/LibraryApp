package nauka.zbiory.thre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Randomizer lottoGame = new Randomizer();

        lottoGame.generate();
        lottoGame.randomize();
        List<Integer> integers = playerNums();
        int i = lottoGame.checkResult(integers);
        System.out.println("Twoje liczby to " + integers);
        System.out.println("wynik losowania to " + lottoGame.getLottoResult());
        System.out.println("liczba trafien " + i);


    }

    private  static List<Integer>playerNums(){
        List<Integer>playerInput = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Randomizer.MAX_NUMBERS; i++) {
            System.out.println("Podaj liczbe  od 1 do 49");
            int input = sc.nextInt();
            playerInput.add(input);
        }
        sc.close();
        return playerInput;
    }
}
