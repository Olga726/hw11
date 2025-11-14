package complex2.task3;

public class Main {
    public static void main(String[] args) {
        BookBuilder builder = new BookBuilder();
        Book book1 = builder
                .setDescription("A historical novel")
                .setTitle("War and peace")
                .setAuthor("Leo Tolstoy")
                .build();

        BookProxy proxy1 = new BookProxy(book1);
        System.out.println(proxy1.getBookcontent());
        System.out.println(proxy1.getBookcontent());

        System.out.println(book1);

        Book book2 = builder
                .setDescription("Dystopia")
                .setTitle("1984")
                .setAuthor("George Orwell")
                .build();

        BookProxy proxy2 = new BookProxy(book2);
        System.out.println(proxy2.getBookcontent());


    }
}
