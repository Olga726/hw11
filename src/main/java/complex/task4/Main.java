package complex.task4;

public class Main {
    public static void main(String[] args) {

        MovieService service = new MovieService();
        Movie mov1 = new Movie("film1", "dir1");
        Movie mov2 = new Movie("film2", "dir2");
        Movie mov3 = new Movie("film3", "dir3");

        service.addRate(mov1, new Rating<>(9.9));
        service.addRate(mov2, new Rating<>(1.0));
        service.addRate(mov2, new Rating<>(5.0));
        service.addRate(mov3, new Rating<>(10.0));

        System.out.println(service.sortByAverageRating());

    }
}
