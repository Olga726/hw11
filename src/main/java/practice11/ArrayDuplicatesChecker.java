package practice11;

import java.util.Arrays;

public class ArrayDuplicatesChecker {
    public boolean hasDuplicates(int[] numbers) {
        return Arrays.stream(numbers).distinct().count() != numbers.length;
    }
}
