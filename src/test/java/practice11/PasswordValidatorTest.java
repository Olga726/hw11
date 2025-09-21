package practice11;
//Корректный пароль:
//Вход: "Password1" → Выход: true.
//Пароль имеет длину больше 8 символов, содержит хотя бы одну заглавную букву и одну цифру.

//Пароль, который слишком короткий:
//Вход: "pass" → Выход: false.
//Пароль слишком короткий, не соответствует минимальной длине.

//Пароль с отсутствием цифры или заглавной буквы:
//Вход: "password" → Выход: false.
//Пароль не содержит ни цифры, ни заглавной буквы.

//Null пароль:
//Вход: null → Выход: false.
//Метод должен корректно обработать null и вернуть false.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest {
    private PasswordValidator validator;

    @BeforeEach
    void setUp(){
        validator = new PasswordValidator();
    }

    @Test
    @DisplayName("Проверка валидного пароля")
    public void userCanValidatePassword(){
        String input = "Password1";
        assertTrue(validator.isValidPassword(input));
    }

    @Test
    @DisplayName("Проверка слишком короткого пароля")
    public void userCanValidateTooShortPassword(){
        String input = "pass";
        assertFalse(validator.isValidPassword(input));
    }

    @Test
    @DisplayName("Проверка пароля с отсутствием цифры или заглавной буквы")
    public void userCanCheckNotValidPassword(){
        String input = "password";
        assertFalse(validator.isValidPassword(input));
    }

    @Test
    @DisplayName("Проверка передачи null")
    public void userCanNotCheckNull(){
        assertFalse(validator.isValidPassword(null));
    }
}
