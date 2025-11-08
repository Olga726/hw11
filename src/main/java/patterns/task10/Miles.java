package patterns.task10;

public class Miles implements Distance {
    private double miles;

    public Miles(double miles) {
        this.miles = miles;
    }

    @Override
    public double getDistance() {
        return miles;
    }


    @Override
    public void showDistance() {
        System.out.println("miles: " + miles);
    }
}
