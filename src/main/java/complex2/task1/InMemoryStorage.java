package complex2.task1;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage implements UrlStorage {
    private static InMemoryStorage instance;
    private Map<String, String> storage = new ConcurrentHashMap<>();

    private InMemoryStorage() {
    }

    public static synchronized InMemoryStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryStorage();
        }
        return instance;
    }


    @Override
    public void save(String shortUrl, String originalUrl) {
        storage.put(shortUrl, originalUrl);
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        return storage.get(shortUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InMemoryStorage that = (InMemoryStorage) o;
        return Objects.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(storage);
    }

    @Override
    public String toString() {
        return "InMemoryStorage{" +
                "storage=" + storage +
                '}';
    }
}
