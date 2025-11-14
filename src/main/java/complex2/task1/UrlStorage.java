package complex2.task1;

public interface UrlStorage {
    void save(String originalUrl, String shortUrl);
    String getOriginalUrl(String shortUrl);
}
