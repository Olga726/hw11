package practice11;
//Обычный список:
//Вход: ["Java", "C", "Python"] → Выход: ["C", "Java", "Python"].
//Список с одинаковыми длинами:
//Вход: ["aa", "bb", "cc"] → Выход: ["aa", "bb", "cc"].
//Пустой список:
//Вход: [] → Выход: [] (пустой список).

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedByLengthTest {
    private SorterByLength sorterByLength;

    @BeforeEach
    void setUp(){
        sorterByLength = new SorterByLength();
    }

    @Test
    @DisplayName("Проверка сортировки по длине элементов обычного списка")
    public void userCanCheckListSorting(){
        List<String> input = List.of("Java", "C", "Python");
        List<String> output = List.of("C", "Java", "Python");
        assertEquals(output, sorterByLength.sortByLength(input));
    }

    @Test
    @DisplayName("Проверка сортировки списка с элементами одинаковой длины")
    public void userCanCheckListOfEqualsElementLengthSorting(){
        List<String> input = List.of("cc", "aa", "bb");
        List<String> output = List.of("cc", "aa", "bb");
        assertEquals(output, sorterByLength.sortByLength(input));
    }

    @Test
    @DisplayName("Проверка пустого списка")
    public void userCanCheckEmptyListLengthSorting(){
        List<String> input = List.of();
        List<String> output = List.of();
        assertEquals(output, sorterByLength.sortByLength(input));
    }


}
