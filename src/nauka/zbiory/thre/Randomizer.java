package nauka.zbiory.thre;

import pl.library.service.Library;

import java.util.*;

public class Randomizer {


    private final int MAX_ROLL = 49;
    public static final int MAX_NUMBERS = 6;


    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> lottoResult;

    public List<Integer> getLottoResult() {
        return lottoResult;
    }

    Scanner sc = new Scanner(System.in);

    void generate(){
        for (int i = 1; i < MAX_ROLL ; i++) {
            numbers.add(i);
        }
    }
    void randomize(){
        Collections.shuffle(numbers);
        lottoResult = numbers.subList(0,6);
    }

    int checkResult(List<Integer>playerNumbers){
        int found = 0;
        for (int i = 0; i <MAX_NUMBERS ; i++) {
            if (lottoResult.contains(playerNumbers.get(i))){
                found ++;
            }
        }
        return found;
    }








}
