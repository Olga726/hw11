package practice11;

import java.util.List;
import java.util.stream.Collectors;

public class StringsListToLength {
    public List<Integer> mapToLengths(List<String> words) {
        return words.stream().map(String::length).collect(Collectors.toList());
    }
}
