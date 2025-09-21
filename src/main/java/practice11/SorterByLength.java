package practice11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SorterByLength {
    public List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}
