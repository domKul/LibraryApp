package nauka;

public class MetricConverter {

    public double metrToCent(double meters){
        return meters * 100;
    }
    public double metrToMilimetr(double meters){
        return meters * 1000;
    }

    public double centToMetr(double cent){
        return cent / 100;
    }
    public double miliToDouble(double mili){
        return mili / 1000;
    }
}
