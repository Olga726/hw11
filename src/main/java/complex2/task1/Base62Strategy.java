package complex2.task1;

public class Base62Strategy implements ShorteningStrategy{
    private static final String BASE62SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String shortenUrl(String originalUrl) {
        int hash = Math.abs(originalUrl.hashCode());
        StringBuilder shortUrl = new StringBuilder();
        while(hash>0) {
            shortUrl.append(BASE62SYMBOLS.charAt(hash%62));
            hash /=62;
        }
        return shortUrl.reverse().toString();
    }
}
