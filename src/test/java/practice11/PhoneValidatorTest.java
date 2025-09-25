package practice11;
//Корректные номера:
//"+1 1234567890" → true.
//"+44 9876543210" → true.
//"+999 1111111111" → true.

//Некорректные номера:
//"12345" → false.
//"invalid" → false.
//"+1 abcdefghij" → false.
//"+1234 1234567890" (слишком длинный код страны) → false.
//"+1 123" (недостаточно цифр) → false.
//"" (пустая строка) → false.

//null номер:
//null → Должно выбрасываться IllegalArgumentException.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {
    private PhoneValidator phoneValidator;

    @BeforeEach
    void setUp(){
        phoneValidator = new PhoneValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+1 1234567890",
            "+44 9876543210",
            "+999 1111111111"
    })
    @DisplayName("Проверка валидных номеров")
    public void userCanChechValidPhone(String phone){
        assertTrue(phoneValidator.isValidPhoneNumber(phone));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "12345",
            "invalid",
            "+1 abcdefghij",
            "+1234 1234567890", //слишком длинный код страны
            "+1 123",           //недостаточно цифр
            ""                  //пустая строка
    })
    @DisplayName("Проверка невалидных номеров, в том числе не цифровые значения, слишком длинный код," +
            "недостаточное количсетво цифр, пустой строки")
    public void userCanChechInvalidPhone(String phone){
        assertFalse(phoneValidator.isValidPhoneNumber(phone));
    }

    @Test
    @DisplayName("Проверка передачи null - ожидаем IllegalArgumentException")
    public void userCanNotValidateNullPhone(){
        assertThrows(IllegalArgumentException.class, () -> phoneValidator.isValidPhoneNumber(null));
    }

}
