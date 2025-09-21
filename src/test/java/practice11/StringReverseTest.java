package practice11;
// "hello" → "olleh"
//"Java" → "avaJ"
//"" → ""
//"a" → "a"
//null → null
//"12345" → "54321"

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringReverseTest {
    private StringReverse stringReverse;

    @BeforeEach
    void setUp(){
        stringReverse = new StringReverse();
    }

    @ParameterizedTest
    @CsvSource({
            "hello, olleh",
            "Java, avaJ",
            "'', ''",
            "a, a",
            "12345, 54321"
    })
    @DisplayName("Проверка разворота строк, включая пустую строку, один символ и числовую строку")
    public void userCanCheckStringReverse(String input, String output){
        assertEquals(output, stringReverse.reverse(input));
    }

    @Test
    @DisplayName("Проверка передачи null вместо строки")
    public void userCanCheckNullReverse(){
        assertEquals(null,stringReverse.reverse(null));
    }
}
