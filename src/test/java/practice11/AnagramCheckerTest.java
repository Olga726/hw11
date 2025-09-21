package practice11;
//Анаграммы:
//Вход: "listen", "silent" → Выход: true.
//Строки являются анаграммами, так как после сортировки символов они совпадают.

//Не анаграммы:
//Вход: "java", "python" → Выход: false.
//Строки не являются анаграммами, так как их символы не совпадают после сортировки.

//null:
//Вход: null, "word" → Выход: false.
//Если одна из строк равна null, метод возвращает false.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnagramCheckerTest {
    private AnagramChecker anagramChecker;

    @BeforeEach
    void setUp(){
        anagramChecker = new AnagramChecker();
    }

    @Test
    @DisplayName("Проверка анаграмм")
    public void userCanValidateAnagram(){
        String inputString = "listen";
        String anagram = "silent";
        assertTrue(anagramChecker.isAnagram(inputString, anagram));
    }

    @Test
    @DisplayName("Проверка не анаграмм")
    public void userCanValidateNotAnagram(){
        String inputString = "java";
        String anagram = "python";
        assertFalse(anagramChecker.isAnagram(inputString, anagram));
    }

    @Test
    @DisplayName("Проверка случая когда одна из строк null - ожидаем false")
    public void userCanNotValidateNull(){
        String inputString = null;
        String anagram = "word";
        assertFalse(anagramChecker.isAnagram(inputString, anagram));
    }


}
