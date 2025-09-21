package practice11;
//Обычный массив:
//Вход: [1, 2, 3, 4, 5] → Выход: 3.0.
//Среднее значение элементов массива: (1 + 2 + 3 + 4 + 5) / 5 = 3.0.

//Массив с одним элементом:
//Вход: [10] → Выход: 10.0.
//Среднее значение для одного элемента равно самому элементу.

//Пустой массив:
//Вход: [] → Выход: Исключение NoSuchElementException.
//Для пустого массива выбрасывается исключение, так как среднее значение вычислить невозможно.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AverageInArrayTest {
    private AverageInArray average;

    @BeforeEach
    void setUp(){
        average = new AverageInArray();
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения в обычном массиве")
    public void userCanFindAverageInArray(){
        int[] input = {1, 2, 3, 4, 5};
        Double output = 3.0;
        assertEquals(output, average.findAverage(input));
    }

    @Test
    @DisplayName("Проверка вычисления среднего значения в массиве из одного элемента")
    public void userCanFindAverageInOneElementArray(){
        int[] input = {10};
        Double output = 10.0;
        assertEquals(output, average.findAverage(input));
    }

    @Test
    @DisplayName("Проверка с пустым массивом - ожидаем NoSuchElementException")
    public void userCanNotFindAverageOfEmptyArray(){
        int[] input = {};
        assertThrows(NoSuchElementException.class, () ->average.findAverage(input));
    }
}
