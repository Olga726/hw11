package practice11;
//Обычная строка с разделителями:
//Вход: "Java,Python,C++", разделитель: "," → Выход: ["Java", "Python", "C++"].
//Строка будет разделена на три части по запятой.

//Пустая строка с разделителем:
//Вход: "", разделитель: "," → Выход: [""].
//Если строка пуста, возвращается массив с единственным пустым элементом.

//Строка без разделителя:
//Вход: "word", разделитель: "," → Выход: ["word"].
//Если разделитель отсутствует, то возвращается массив с одним элементом — самой строкой.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringToPartsTest {
    private StringToParts stringToParts;

    @BeforeEach
    void setUp(){
        stringToParts = new StringToParts();
    }

    @Test
    @DisplayName("Проверка преобразования обычной строки с разделителями в массив строк")
    public void userCanModifyStringToWordsArray(){
        String input = "Java,Python,C++";
        String[] output = {"Java", "Python", "C++"};
        assertArrayEquals(output, stringToParts.splitString(input, ","));

    }

    @Test
    @DisplayName("Проверка преобразования массива из пустой строки - ожидаем массив с пустым элементом")
    public void userCanModifyEmptyStringToWordsArray(){
        String input = "";
        String[] output = {""};
        assertArrayEquals(output, stringToParts.splitString(input, ","));

    }

    @Test
    @DisplayName("Проверка преобразования массива без разделителя - ожидаем массив из одного элемента")
    public void userCanModifyStringWithoutDelimiterToWordsArray(){
        String input = "word and world";
        String[] output = {"word and world"};
        assertArrayEquals(output, stringToParts.splitString(input, ","));

    }

}
