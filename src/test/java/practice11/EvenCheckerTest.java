package practice11;
//Чётные числа:
//Вход: 4 → Выход: true.
//Число делится на 2 без остатка, значит, оно чётное.
//Нулевое значение:
//Вход: 0 → Выход: true.
//Ноль — чётное число, так как он делится на 2.
//Отрицательные числа:
//Вход: -4 → Выход: true.
//Отрицательное чётное число также делится на 2 без остатка, поэтому результат будет true.

//Нечётные числа:
//Вход: 5 → Выход: false.
//Число не делится на 2 без остатка, значит, оно нечётное.
//Отрицательные числа:
//Вход: -3 → Выход: false.
//Отрицательное нечётное число не делится на 2 без остатка, поэтому результат будет false.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenCheckerTest {
    private EvenChecker evenChecker;

    @BeforeEach
    void setUp(){
        evenChecker = new EvenChecker();
    }

    @ParameterizedTest
    @CsvSource({
            "0, true",
            "4, true",
            "-4, true"
    })
    @DisplayName("Проверка нуля, положительного четного числа, отрицательного четного числа")
    public void userCanCheckEven(Integer number, boolean result){
        assertEquals(result, evenChecker.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
            "5, false",
            "-5, false"
    })
    @DisplayName("Проверка положительного нечетного числа, отрицательного нечетного числа")
    public void userCanCheckNotEven(Integer number, boolean result){
        assertEquals(result, evenChecker.isEven(number));
    }


}
