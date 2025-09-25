package practice11;
//Обычная строка: "Hello world" → countWords() → 2.
//Строка с лишними пробелами: " Java is awesome " → countWords() → 3.
//Пустая строка: "" → countWords() → 0.
//Строка с пробелами: " " → countWords() → 0.
//null строка: null → Должно выбрасываться IllegalArgumentException.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordsCounterTest {
    private WordsCounter wordsCounter;

    @BeforeEach
    void setUp(){
        wordsCounter = new WordsCounter();
    }

    @ParameterizedTest
    @CsvSource({
            "Hello world, 2"
    })
    @DisplayName("Проверка подсчета количества слов в обычной строке")
    public void userCanCheckWordsQuantity(String input, int output) {
        assertEquals(output, wordsCounter.countWords(input));
    }

    @ParameterizedTest
    @CsvSource({
            "' Java is awesome ', 3"
    })
    @DisplayName("Проверка подсчета количества слов в строке с пробелами в начале и конце")
    public void userCanCheckWordsQuantityInStringWithSpaces(String input, int output) {
        assertEquals(output, wordsCounter.countWords(input));
    }

    @Test
    @DisplayName("Проверка подсчета количества слов в пустой строке - ожидаем 0")
    public void userCanCheckWordsQuantityInEmptyString(){
        int expected = 0;
        int actual = wordsCounter.countWords("");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка передачи null - ожидаем IllegalArgumentException")
    public void userCanNotCheckWordsQuantityInNull(){
        assertThrows(IllegalArgumentException.class, () -> wordsCounter.countWords(null));
    }

}
