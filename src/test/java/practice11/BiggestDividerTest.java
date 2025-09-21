package practice11;
//Обычные числа:
//Вход: 24, 36 → Выход: 12.
//Наибольший общий делитель между 24 и 36 равен 12.

//Простые числа:
//Вход: 101, 103 → Выход: 1.
//Простые числа всегда имеют НОД равный 1, так как они не делятся друг на друга.

//Нулевое значение:
//Вход: 0, 10 → Выход: 10.
//Когда одно из чисел равно 0, НОД всегда равен другому числу (в данном случае 10).

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiggestDividerTest {
    private BiggestDivider divider;

    @BeforeEach
    void setUp(){
        divider = new BiggestDivider();
    }

    @Test
    @DisplayName("Проверка нахождения общего делителя для обычных чисел")
    public void userCanCheckGCD(){
        int a = 24;
        int b = 36;
        int output = 12;
        assertEquals(output, divider.gcd(a, b));
    }

    @Test
    @DisplayName("Проверка нахождения общего делителя для простых чисел - ожидаем 1")
    public void userCanCheckGCDSimpleNumbers(){
        int a = 101;
        int b = 103;
        int output = 1;
        assertEquals(output, divider.gcd(a, b));
    }

    @Test
    @DisplayName("Проверка нахождения общего делителя для чисел, когда одно из них 0 - ожидаем второе число")
    public void userCanCheckGCDOneIsZero(){
        int a = 10;
        int b = 0;
        int output = 10;
        assertEquals(output, divider.gcd(a, b));
    }

}
