package patterns.task1;

public class ConfigurationManager {
    private String dbUrl;
    private String userName;
    private String password;
    private String fileFolderPath;
    private String logLevel;
    private String logPath;


    private ConfigurationManager() {
    }

    private static class Holder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setDbConf(String dbUrl, String userName, String password) {
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;
    }

    public void setFileFolderPath(String fileFolderPath) {
        this.fileFolderPath = fileFolderPath;
    }

    public void setLogConf(String logPath, String logLevel) {
        this.logLevel = logLevel;
        this.logPath = logPath;
    }

    @Override
    public String toString() {
        return "ConfigurationManager{" +
                "dbUrl='" + dbUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fileFolderPath='" + fileFolderPath + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", logPath='" + logPath + '\'' +
                '}';
    }
}



