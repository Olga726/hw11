package patterns.task2;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("INFO", "Успех!");
        logger.log("WARN", "предупреждение");
        logger.log("ERROR", "ошибка ввода");
    }
}
