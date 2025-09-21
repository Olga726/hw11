package practice11;
//Обычный список:
//Вход: [1, 2, 3, 4, 5, 6] → Выход: [2, 4, 6].
//Список без чётных чисел:
//Вход: [1, 3, 5] → Выход: [] (пустой список).
//Пустой список:
//Вход: [] → Выход: [] (пустой список).

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterEvenTest {
    private FilterEven filterEven;

    @BeforeEach
    void setUp(){
        filterEven = new FilterEven();
    }

    @Test
    @DisplayName("Проверка фильтрации обычного списка с четными и нечетными")
    public void userCanCheckEvenFilter(){
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> output = List.of(2, 4, 6);
        assertEquals(output, filterEven.filterEvenNumbers(input));
    }

    @Test
    @DisplayName("Проверка фильтрации списка без четных чисел")
    public void userCanFilterWithoutEvenList(){
        List<Integer> input = List.of(1, 3, 5);
        List<Integer> output = List.of();
        assertEquals(output, filterEven.filterEvenNumbers(input));
    }

    @Test
    @DisplayName("Проверка фильтрации пустого списка - ожидаем []")
    public void userCanFilterEmptyList(){
        List<Integer> input = List.of();
        List<Integer> output = List.of();
        assertEquals(output, filterEven.filterEvenNumbers(input));
    }



}
