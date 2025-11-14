package complex2.task1;

public class ShortenerFactory {
    private ShorteningStrategy strategy;

    public void setShorteningStrategy(ShorteningStrategy strategy) {
        this.strategy = strategy;
    }

    public String shorten(String originalUrl) {
        return strategy.shortenUrl(originalUrl);
    }
}
