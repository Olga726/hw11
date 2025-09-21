package practice11;
//Корректный JSON:
//Вход: "{"key":"value"}" → Выход: true.
//Строка является валидным JSON, так как она представляет собой объект с ключом key и значением value.

//Некорректный JSON:
//Вход: "invalid json" → Выход: false.
//Строка не является валидным JSON, так как она не соответствует никакому стандарту (например, отсутствуют кавычки, неправильный формат).

//null:
//Вход: null → Выход: false.
//При передаче null метод должен вернуть false, так как нельзя создать JSON из null.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonObjectCheckerTest {
    private JsonObjectChecker checker;

    @BeforeEach
    void setUp(){
        checker = new JsonObjectChecker();
    }

    @Test
    @DisplayName("Проверка корректного json")
    public void userCanValidateJson(){
        String input = "{\"key\":\"value\"}";
        assertTrue(checker.isValidJson(input), "ожидаем true, json корректный");
    }

    @Test
    @DisplayName("Проверка некорректного json")
    public void userCanValidateNotCorrectJson(){
        String input = "invalid json";
        assertFalse(checker.isValidJson(input), "ожидаем false, json некорректный");
    }

    @Test
    @DisplayName("Проверка передачи null")
    public void userCanValidateNullJson(){
        assertFalse(checker.isValidJson(null), "ожидаем false, json null");
    }
}
