package complex.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceChecker {
    private MovieService movieService;
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    @BeforeEach
    void setUp() {
        movieService = new MovieService();
        movie1 = new Movie("Avatar", "Cameron");
        movie2 = new Movie("Matrix", "Wachovski");
        movie3 = new Movie("Solaris", "Tarkovski");
    }

    @Test
    public void checkAddRateWithValidValues() {
        assertDoesNotThrow(() -> movieService.addRate(movie1, new Rating(1.0)));
        assertDoesNotThrow(() -> movieService.addRate(movie1, new Rating(1.1)));
        assertDoesNotThrow(() -> movieService.addRate(movie1, new Rating(10)));
    }

    @Test
    public void checkAddRateWithInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> movieService.addRate(movie1, new Rating<>(0.99)));
        assertThrows(IllegalArgumentException.class, () -> movieService.addRate(movie1, new Rating<>(10.01)));
        assertThrows(IllegalArgumentException.class, () -> movieService.addRate(null, new Rating<>(10.01)));
        assertThrows(IllegalArgumentException.class, () -> movieService.addRate(movie1, null));
    }

    @Test
    public void checkGetAverage(){
        movieService.addRate(movie1, new Rating<>(1));
        movieService.addRate(movie1, new Rating<>(9.9f));
        assertEquals(5.45, movieService.getAverage(movie1), 0.0001);
        movieService.addRate(movie2, new Rating<>(1.1));
        assertEquals(1.1, movieService.getAverage(movie2), 0.0001);
    }

    @Test
    public void checkSortByAverageRating(){
        movieService.addRate(movie1, new Rating<>(1));
        movieService.addRate(movie1, new Rating<>(9.9f));

        movieService.addRate(movie2, new Rating<>(1));
        movieService.addRate(movie2, new Rating<>(9.9f));

        movieService.addRate(movie3, new Rating<>(1.1));
        movieService.addRate(movie3, new Rating<>(9.9f));

        Map<Movie, Double> map = movieService.sortByAverageRating();
        List<Movie> sortedList = new ArrayList<>(map.keySet());

        assertEquals(movie3, sortedList.getFirst());
        assertEquals(movie1, sortedList.get(1)); //если одинаковый среднйи рейтинг -сортировка по названию
        assertEquals(movie2, sortedList.get(2));

    }
}