package practice11;

import java.util.Arrays;

public class MaxInArray {
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
}
