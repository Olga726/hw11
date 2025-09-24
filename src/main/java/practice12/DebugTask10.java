package practice12;
//Код должен удалять элементы списка, но выбрасывает ConcurrentModificationException.

import java.util.*;
public class DebugTask10 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        names.removeIf(name ->name.startsWith("A"));
        System.out.println(names);
        }
    }

