package patterns.task10;

public class MilesToKilometersAdapter implements Distance {
    private Distance distance;

    public MilesToKilometersAdapter(Distance distance) {
        this.distance = distance;
    }

    @Override
    public double getDistance() {
        if (distance instanceof Miles) {
            return distance.getDistance() * 1.60934;
        }
        return distance.getDistance();
    }

    @Override
    public void showDistance() {
        if (distance instanceof Miles) {
            System.out.printf("converting %s miles to kilometers: %s%n", distance.getDistance(), getDistance());
        } else if (distance instanceof Kilometers) {
            distance.showDistance();
        }
    }
}
