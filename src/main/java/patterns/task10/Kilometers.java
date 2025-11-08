package patterns.task10;

public class Kilometers implements Distance {
    private double kms;

    public Kilometers(double kms) {
        this.kms = kms;
    }

    @Override
    public double getDistance() {
        return kms;
    }

    @Override
    public void showDistance() {
        System.out.println("kilometers: " + kms);
    }
}
