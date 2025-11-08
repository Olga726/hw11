package patterns.task2;

public class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String level, String message) {
        String str = String.format("[%s] %s: %s", java.time.LocalDateTime.now(), level, message);
        System.out.println(str);
    }


}
