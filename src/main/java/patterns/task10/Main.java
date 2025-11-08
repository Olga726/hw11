package patterns.task10;

public class Main {
    public static void main(String[] args) {
        Distance distance = new Miles(1000.00);
        MilesToKilometersAdapter adapter = new MilesToKilometersAdapter(distance);
        adapter.showDistance();

        Distance distance1 = new Kilometers(200.00);
        MilesToKilometersAdapter adapter1 = new MilesToKilometersAdapter(distance1);
        adapter1.showDistance();
    }
}
