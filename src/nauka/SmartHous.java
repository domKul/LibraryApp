package nauka;

public class SmartHous {

    static double waterQuantity;
    double petrolQuantity;

    public SmartHous(double waterQuantity){
        this.waterQuantity=waterQuantity;
    }

    public void takeShower(){
        waterQuantity = waterQuantity - 48;
    }
    public void housInfo(){
        System.out.println("Stan wody to : " + waterQuantity);
    }
}
