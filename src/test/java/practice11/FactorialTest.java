package practice11;
//Базовый случай: factorial(0) → 1
//Обычные числа: factorial(1) → 1, factorial(5) → 120, factorial(7) → 5040
//Отрицательные числа: factorial(-3) → Должно выбрасывать IllegalArgumentException.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    void  setUp(){
        factorial = new Factorial();
    }

    @Test
    @DisplayName("Базовый случай: factorial(0) → 1")
    public void userCanCheckFactorialFrom0(){
        assertEquals(1, factorial.factorial(0));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "5, 120",
            "7, 5040"
    })
    @DisplayName("Проверка вычисления факториала обычных чисел")
    public void userCanCheckFactorialFromSimpleNumber(int input, int output){
        assertEquals(output, factorial.factorial(input));
    }

    @Test
    @DisplayName("Проверка с отрицательным числом - ожидаем IllegalArgumentException")
    public void userCanNotCheckFactorialFromNegative(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(-3));
    }
}
