package practice11;
//[3, 5, 7, 2] → 7
//[1] → 1
//[-3, -5, -7, -2] → -2
//[] → выбрасывает NoSuchElementException
//null → выбрасывает NullPointerException

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxInArrayTest {
    private MaxInArray maxInArray;

    @BeforeEach
    void setUp(){
        maxInArray = new MaxInArray();
    }

    @Test
    @DisplayName("Поиск максимального значения в массиве положительных чисел")
    public void userCanFindMaxInPositiveArray(){
        int[] numbers = {3, 5, 7, 2};
        int actual = maxInArray.findMax(numbers);
        int expected = Arrays.stream(numbers).max().orElseThrow();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск максимального значения в массиве из одного числа")
    public void userCanFindMaxInOneElementArray(){
        int[] numbers = {1};
        int actual = maxInArray.findMax(numbers);
        int expected = Arrays.stream(numbers).max().orElseThrow();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск максимального значения в массиве из отрицательных чисел")
    public void userCanFindMaxInNegativesArray(){
        int[] numbers = {-3, -5, -7, -2};
        int actual = maxInArray.findMax(numbers);
        int expected = Arrays.stream(numbers).max().orElseThrow();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Поиск максимального числа в пустом массиве")
    public void userCanNotFindMaxInEmptyArray(){
        int[] numbers = {};
        assertThrows(NoSuchElementException.class, () -> maxInArray.findMax(numbers));
    }

    @Test
    @DisplayName("Поиск максимального числа в null")
    public void userCanNotFindMaxInNull(){
        assertThrows(NullPointerException.class, () -> maxInArray.findMax(null));
    }


}
