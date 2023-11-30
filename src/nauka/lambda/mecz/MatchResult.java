package nauka.lambda.mecz;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class MatchResult {
    private String gospodarz;
    private String gosc;
    private int bramkiGospodarz;
    private int bramkiGosc;

    public MatchResult(String gospodarz, String gosc, int bramkiGospodarz, int bramkiGosc) {
        this.gospodarz = gospodarz;
        this.gosc = gosc;
        this.bramkiGospodarz = bramkiGospodarz;
        this.bramkiGosc = bramkiGosc;
    }

    public void printAllResultsSorted(Stream<MatchResult> matchResultStraam){
        matchResultStraam.sorted(
                Comparator.comparing(MatchResult::getGoalsDifference).reversed()
        ).forEach(System.out::println);
    }
    int getGoalsDifference(){
        return bramkiGospodarz - bramkiGosc;
    }

    public String getGospodarz() {
        return gospodarz;
    }

    public void setGospodarz(String gospodarz) {
        this.gospodarz = gospodarz;
    }

    public String getGosc() {
        return gosc;
    }

    public void setGosc(String gosc) {
        this.gosc = gosc;
    }

    public int getBramkiGospodarz() {
        return bramkiGospodarz;
    }

    public void setBramkiGospodarz(int bramkiGospodarz) {
        this.bramkiGospodarz = bramkiGospodarz;
    }

    public int getBramkiGosc() {
        return bramkiGosc;
    }

    public void setBramkiGosc(int bramkiGosc) {
        this.bramkiGosc = bramkiGosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult druzyna = (MatchResult) o;
        return bramkiGospodarz == druzyna.bramkiGospodarz && bramkiGosc == druzyna.bramkiGosc && Objects.equals(gospodarz, druzyna.gospodarz) && Objects.equals(gosc, druzyna.gosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gospodarz, gosc, bramkiGospodarz, bramkiGosc);
    }

    @Override
    public String toString() {
        return "gospodarz" + gospodarz  + "- gosc= " + gosc + "(" + bramkiGospodarz + bramkiGosc + ')';
    }
}
