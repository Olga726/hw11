package complex.task2;

public class Main {
    public static void main(String[] args) {


        User user1 = new User("Vasya", 18, "v@vv.com");
        User user2 = new User("don", 17, ".com");
        User user3 = new User("Son", 17, ".com");
        User user4 = new User("Sonny", 100, ".com");

        UserValidator validator = new UserValidator(false);
        validator.setValidationEnabled(true);
        validator.validate(user4);

    }
}