package practice11;

import java.util.Arrays;

public class AverageInArray {
    public double findAverage(int[] numbers) {
        return Arrays.stream(numbers).average().orElseThrow();
    }
}
