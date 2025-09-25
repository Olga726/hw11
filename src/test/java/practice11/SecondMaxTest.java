package practice11;
//Обычный массив: [3, 5, 7, 2] → findSecondMax() → 5
//Массив с одинаковыми числами: [4, 4, 4, 4] → Должно выбрасываться NoSuchElementException.
//Один элемент: [8] → Должно выбрасываться NoSuchElementException.
//Пустой массив: [] → Должно выбрасываться NoSuchElementException.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondMaxTest {
    private SecondMax secondMax;

    @BeforeEach
    void setUp(){
        secondMax = new SecondMax();
    }

    @Test
    @DisplayName("Поиск второго по величине элемента в обычном массиве")
    public void userCanFindSecondMaxInArray(){
        int[] input = {3, 5, 7, 2};
        int output = 5;
        assertEquals(output, secondMax.findSecondMax(input));
    }

    @Test
    @DisplayName("Поиск второго по величине элемента в массиве из одинаковых значений - ожидаем NoSuchElementException")
    public void userCanNotFindSecondMaxInEqualsArray(){
        int[] input = {4, 4, 4, 4};
        assertThrows(NoSuchElementException.class, () -> secondMax.findSecondMax(input));
    }

    @Test
    @DisplayName("Поиск второго по величине элемента в массиве из одного значения - ожидаем IllegalArgumentException")
    public void userCanNotFindSecondMaxInOneElementArray(){
        int[] input = {8};
        assertThrows(NoSuchElementException.class, () -> secondMax.findSecondMax(input));
    }

    @Test
    @DisplayName("Поиск второго по величине элемента в пустом массиве - ожидаем IllegalArgumentException")
    public void userCanNotFindSecondMaxInEmptyArray(){
        int[] input = {};
        assertThrows(NoSuchElementException.class, () -> secondMax.findSecondMax(input));
    }


}
