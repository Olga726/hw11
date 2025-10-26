package complex.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserValidatorChecker {
    private UserValidator userValidator;
    private User user1ValidAge;
    private User user2ValidAge;

    private User user1InvalidName;
    private User user2InvalidName;
    private User user3InvalidName;

    private User user1InvalidAge;
    private User user2InvalidAge;

    private User user3InvalidEmail;
    private User user4InvalidEmail;
    private User user5InvalidEmail;
    private User user6InvalidEmail;
    private User user7InvalidEmail;
    private User user8InvalidEmail;
    private User user9InvalidEmail;

    private User user1InvalidEmail;
    private User user2InvalidEmail;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator(true);
        user1ValidAge = new User("Ann", 18, "ann@mail.com");
        user2ValidAge = new User("Nill", 100, "n@mail.com");

        user1InvalidName = new User("ann", 18, "ann@mail.com");
        user2InvalidName = new User(null, 18, "ann@mail.com");
        user3InvalidName= new User("", 18, "ann@mail.com");

        user1InvalidAge = new User("Ann", 17, "ann@mail.com");
        user2InvalidAge = new User("Kat", 101, "k@mail.com");

        user1InvalidEmail = new User("Mary", 30, null);
        user2InvalidEmail = new User("Mary", 30, "");
        user3InvalidEmail = new User("Poll", 99, "this is string");
        user4InvalidEmail = new User("Polina", 19, "@mail.ru");
        user5InvalidEmail = new User("Julia", 30, "name@");
        user6InvalidEmail = new User("Mary", 30, "name@mail");
        user7InvalidEmail = new User("Mary", 30, "name@mail.c");
        user8InvalidEmail = new User("Mary", 30, "name@.com");
        user9InvalidEmail = new User("Mary", 30, "name@mail@mail.com");


    }

    @Test
    public void checkValidBorderAgeUser() {
        assertEquals("валидация успешна", userValidator.validate(user1ValidAge));
        assertEquals("валидация успешна", userValidator.validate(user2ValidAge));
    }

    @Test
    public void checkValidationUnabled() {
        userValidator.setValidationEnabled(false);
        assertEquals("валидация не включена", userValidator.validate(user1ValidAge));
    }

    @Test
    public void checkNameStartsLowercase() {
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user1InvalidName));
        assertEquals("Имя должно начинаться с заглавной буквы", ex1.getMessage());
    }

    @Test
    public void checkNullNameValidation() {
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user2InvalidName));
        assertEquals("Имя не может быть пустым", ex1.getMessage());
    }

    @Test
    public void checkEmptyStringNameValidation() {
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user3InvalidName));
        assertEquals("Имя не может быть пустым", ex1.getMessage());
    }

    @Test
    public void checkInvalidAgeValiadtion(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user1InvalidAge));
        assertEquals("Возраст должен быть от 18 до 100 лет", ex1.getMessage());

        InvalidUserException ex2 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user2InvalidAge));
        assertEquals("Возраст должен быть от 18 до 100 лет", ex2.getMessage());
    }

    @Test
    public void checkNullEmailValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user1InvalidEmail));
        assertEquals("email не указан", ex1.getMessage());
    }

    @Test
    public void checkEmptyEmailValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user2InvalidEmail));
        assertEquals("email не указан", ex1.getMessage());
    }

    @Test
    public void checkInvalidStringEmailValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user3InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutLocalPartValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user4InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutAtValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user4InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutDomainValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user5InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutDomainDotPartValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user6InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutDomainAfterDotPartValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user7InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithoutDomainBeforeDotPartValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user8InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }

    @Test
    public void checkInvalidEmailWithSeveralAtValidation(){
        InvalidUserException ex1 = assertThrows(InvalidUserException.class, () -> userValidator.validate(user9InvalidEmail));
        assertEquals("Невалидный email", ex1.getMessage());
    }


}
