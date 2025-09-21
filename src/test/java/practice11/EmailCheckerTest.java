package practice11;
//Корректные email: "test@example.com", "user.name@domain.co", "a@b.cc" → true
//Некорректные email: "bad@.com", "no-at-symbol", "@missing-user.com", "user@domain" → false
//Пустая строка: "" → false
//null: null → false

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailCheckerTest {
    private EmailChecker emailChecker;

    @BeforeEach
    void setUp(){
        emailChecker = new EmailChecker();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "test@example.com", "user.name@domain.co", "a@b.cc"
    })
    @DisplayName("Проверка корректных email")
    public void userCanCheckValidEmail(String str){
        assertTrue(emailChecker.isValidEmail(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "bad@.com", "no-at-symbol", "@missing-user.com", "user@domain"
    })
    @DisplayName("Проверка некорректных email")
    public void userCanCheckNotValidEmail(String str){
        assertFalse(emailChecker.isValidEmail(str));
    }

    @Test
    @DisplayName("Проверка передачи пустой строки")
    public void userCanNotCheckEmptyEmail(){
        assertFalse(emailChecker.isValidEmail(""));
    }

    @Test
    @DisplayName("Проверка передачи null")
    public void userCanNotCheckNullEmail(){
        assertFalse(emailChecker.isValidEmail(null));
    }

}
