package complex2.task1;

public class UrlShortenerService {
    private UrlStorage storage;
    private ShortenerFactory shortenerFactory;

    public UrlShortenerService(ShortenerFactory shortenerFactory, UrlStorage storage) {
        this.shortenerFactory = shortenerFactory;
        this.storage = storage;
    }

    public String shortenUrl(String url) {
        return shortenerFactory.shorten(url);
    }


    public String expandUrl(String shortUrl) {
        return storage.getOriginalUrl(shortUrl);
    }
}
