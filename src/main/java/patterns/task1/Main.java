package patterns.task1;

public class Main {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        config.setFileFolderPath("disk/folder");
        config.setLogConf("app/log", "INFO");
        config.setDbConf("db:\\url", "user1", "123456");
        System.out.println(config);
    }
}
