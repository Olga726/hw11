package complex.task2;

public class UserValidator {
    private boolean validationEnabled;

    public UserValidator(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    public void setValidationEnabled(boolean validationEnabled) {
        this.validationEnabled = validationEnabled;
    }

    public boolean isValidationEnabled() {
        return validationEnabled;
    }

    public String validate(User user){
        if(!validationEnabled){
            return "валидация не включена";
        } else if (user.getName() ==null ||user.getName().isEmpty())
            throw new InvalidUserException("Имя не может быть пустым");
        else if (Character.isLowerCase(user.getName().charAt(0)))
            throw new InvalidUserException("Имя должно начинаться с заглавной буквы");
        else if (user.getAge()<18 ||user.getAge()>100)
            throw new InvalidUserException("Возраст должен быть от 18 до 100 лет");
        else if (user.getEmail()==null ||user.getEmail().isEmpty()) {
            throw new InvalidUserException("email не указан");
        } else if (!user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"))
            throw new InvalidUserException("Невалидный email");
        else return "валидация успешна";

    }
}
