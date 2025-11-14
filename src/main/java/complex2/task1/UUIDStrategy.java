package complex2.task1;

import java.util.UUID;

public class UUIDStrategy implements ShorteningStrategy {
    @Override
    public String shortenUrl(String originalUrl) {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
