package nauka;

public class TimeConverter {

    public int hToM(int hour){
        return hour * 60;
    }

    public int minToSec(int min){
        return min * 60;
    }

    public int secToMili(int sec){
        return sec * 1000;
    }
}
