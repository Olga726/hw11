package practice11;
//Обычный список:
//Вход: ["Java", "C++", "Go"] → Выход: [4, 3, 2].
//Каждая строка преобразуется в её длину: "Java" → 4, "C++" → 3, "Go" → 2.

//Пустой список:
//Вход: [] → Выход: [].
//Для пустого списка возвращается также пустой список.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtringsListToLengthTest {
    private StringsListToLength toLength;

    @BeforeEach
    void setUp(){
        toLength = new StringsListToLength();
    }

    @Test
    @DisplayName("Проверка преобразования обычного списка строк в список их длин")
    public void userCanModifyStrigsArrayToLengthArray(){
        List<String> input = List.of("Java", "C++", "Go");
        List<Integer> output = List.of(4, 3, 2);
        assertEquals(output, toLength.mapToLengths(input));
    }
    @Test
    @DisplayName("Проверка преобразования пустого списка - ожидаем пустой список")
    public void userCanModifyEmptyArrayToLengthArray(){
        List<String> input = List.of();
        List<Integer> output = List.of();
        assertEquals(output, toLength.mapToLengths(input));
    }

}
