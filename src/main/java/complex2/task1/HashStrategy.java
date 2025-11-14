package complex2.task1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.security.MessageDigest.getInstance;

public class HashStrategy implements ShorteningStrategy {
    @Override
    public String shortenUrl(String originalUrl) {
        try {
            MessageDigest md = getInstance("MD5");
            byte[] digest = md.digest(originalUrl.getBytes());
            StringBuilder shortUrl = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                shortUrl.append(String.format("%02x", digest[i]));
            }
            return shortUrl.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
