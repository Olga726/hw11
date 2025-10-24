package complex.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorChecker {
    private UserValidator validator;
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    private User user6;
    private User user7;
    private User user8;
    private User user9;
    private User user10;
    private User user11;

    @BeforeEach
    void setUp(){
        validator = new UserValidator(true);
        user1 = new User("Bob", 18, "smth@mail.ru");
        user2 = new User(null, 21, "smth@mail.ru");
        user3 = new User("", 21, "smth@mail.ru");
        user4 = new User("mary", 21, "smth@mail.ru");
        user5 = new User("Poll", 100, "po@mail.ru");
        user6 = new User("Maria", 17, "smth@mail.ru");
        user7 = new User("Poll", 101, "po@mail.ru");
        user8 = new User("Maria", 19, "bad@.com");
        user9 = new User("Poll", 99, "no-at-symbol");
        user10 = new User("Poll", 50, "@missing-user.com");
        user11 = new User("Poll", 50, "user@domain");
    }

    @Test
    public void checkValidationEnabled(){
        assertEquals("валидация успешна", validator.validate(user1));
    }

    @Test
    public void checkValidationUnabled(){
        validator.setValidationEnabled(false);
        assertEquals("валидация не включена", validator.validate(user1));
    }

    @Test
    public void checkNullNameValidation() {
        InvalidUserException ex = assertThrows(InvalidUserException.class, () -> validator.validate(user2));
        assertEquals("Имя не может быть пустым", ex.getMessage());
    }

    @Test
    public void checkEmptyNameValidation() {
        InvalidUserException ex = assertThrows(InvalidUserException.class, ()->validator.validate(user3));
        assertEquals("Имя не может быть пустым", ex.getMessage());
    }

    @Test
    public void checkNameStartsLowerCaseValidation(){
        InvalidUserException ex = assertThrows(InvalidUserException.class, ()->validator.validate(user4));
        assertEquals("Имя должно начинаться с заглавной буквы", ex.getMessage());
    }

    @Test
    public void checkAgeBorderValuesValidation(){
        assertEquals("валидация успешна", validator.validate(user1));
        assertEquals("валидация успешна", validator.validate(user5));
    }

    @Test
    public void checkAgeUnderBorderValuesValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () ->validator.validate(user6));
        assertEquals("Возраст должен быть от 18 до 100 лет", ex1.getMessage());
        InvalidUserException ex2 = assertThrows(InvalidUserException.class, () ->validator.validate(user7));
        assertEquals("Возраст должен быть от 18 до 100 лет", ex2.getMessage());
    }

    @Test
    public void checkInvalidEmailValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () ->validator.validate(user8));
        assertEquals("Невалидный email", ex1.getMessage());
        InvalidUserException ex2 = assertThrows(InvalidUserException.class, () ->validator.validate(user9));
        assertEquals("Невалидный email", ex2.getMessage());
        InvalidUserException ex3 = assertThrows(InvalidUserException.class, () ->validator.validate(user10));
        assertEquals("Невалидный email", ex3.getMessage());
        InvalidUserException ex4 = assertThrows(InvalidUserException.class, () ->validator.validate(user11));
        assertEquals("Невалидный email", ex4.getMessage());
    }
}
