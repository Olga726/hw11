package practice11;
//"hello" → 2
//"java" → 2
//"AEIOU" → 5

//"" → 0

//"bcdfg" → 0

//null → выброс IllegalArgumentException

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VowelsCounterTest {
    private VowelsCounter vowelsCounter;

    @BeforeEach
    void setUp(){
        vowelsCounter = new VowelsCounter();
    }

    @ParameterizedTest
    @CsvSource({
          "hello, 2",
          "java, 2",
          "AEIOU, 5"
    })
    @DisplayName("Проверка строк с гласными")
    public void userCanCheckVowelsInString(String str, int vowels){
        assertEquals(vowels, vowelsCounter.countVowels(str));
    }

    @Test
    @DisplayName("Проверка пустой строки")
    public void userCanNotCheckVowelsInEmptyString(){
        assertEquals(0, vowelsCounter.countVowels(""));
    }

    @Test
    @DisplayName("Проверка строки без гласных")
    public void userCanNotCheckVowelsInStringWithoutVowels(){
        assertEquals(0, vowelsCounter.countVowels("bcdfg"));
    }

    @Test
    @DisplayName("Проверка null")
    public void userCanNotCheckVowelsInNull(){
        assertThrows(IllegalArgumentException.class, () -> vowelsCounter.countVowels(null));
    }

}
