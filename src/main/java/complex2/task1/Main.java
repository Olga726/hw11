package complex2.task1;

public class Main {
    public static void main(String[] args) {
        ShortenerFactory factory = new ShortenerFactory();
        UrlStorage storage = InMemoryStorage.getInstance();

        UrlShortenerService service = new UrlShortenerService(factory, storage);
        factory.setShorteningStrategy(new HashStrategy());
        String originalUrl1 = "www.thisisoriginal.org";
        String shortUrl1 = service.shortenUrl(originalUrl1);
        storage.save(shortUrl1, originalUrl1);
        System.out.println("short url: " + shortUrl1);
        System.out.println("original url: " + service.expandUrl(shortUrl1));

        factory.setShorteningStrategy(new Base62Strategy());
        String shortUrl2 = service.shortenUrl(originalUrl1);
        storage.save(shortUrl2, originalUrl1);
        System.out.println("short url: " + shortUrl2);
        System.out.println("original url: " + service.expandUrl(shortUrl2));

        factory.setShorteningStrategy(new UUIDStrategy());
        String originalUrl2 = "www.thisisoriginal2.org";
        String shortUrl3 = service.shortenUrl(originalUrl2);
        storage.save(shortUrl3, originalUrl2);
        System.out.println("short url: " + shortUrl3);
        System.out.println("original url: " + service.expandUrl(shortUrl3));

        System.out.println(storage);


    }
}
