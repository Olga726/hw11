package practice11;
//Без дубликатов:
//Вход: [1, 2, 3, 4, 5] → Выход: false.
//Массив не содержит повторяющихся элементов, поэтому результат будет false.

//С дубликатами:
//Вход: [1, 2, 2, 3] → Выход: true.
//В массиве присутствуют одинаковые элементы, в данном случае 2, поэтому метод должен вернуть true.

//Пустой массив:
//Вход: [] → Выход: false.
//Пустой массив не может содержать дубликатов, поэтому метод возвращает false.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayDuplicateCheckerTest {
    private ArrayDuplicatesChecker duplicatesChecker;

    @BeforeEach
    void setUp(){
        duplicatesChecker = new ArrayDuplicatesChecker();
    }

    @Test
    @DisplayName("Проверка массива без дубликатов")
    public void userCanCheckArrayWithoutDuplicates(){
        int[] input = {1, 2, 3, 4, 5};
        assertFalse(duplicatesChecker.hasDuplicates(input));
    }

    @Test
    @DisplayName("Проверка массива с дубликатами")
    public void userCanCheckArrayWithDuplicates(){
        int[] input = {1, 2, 2, 3, 4, 5};
        assertTrue(duplicatesChecker.hasDuplicates(input));
    }

    @Test
    @DisplayName("Проверка пустого массива")
    public void userCanCheckEmptyArray(){
        int[] input = {};
        assertFalse(duplicatesChecker.hasDuplicates(input));
    }

}
