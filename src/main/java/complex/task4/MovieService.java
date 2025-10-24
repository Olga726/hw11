package complex.task4;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MovieService <T extends Number> {
    private Map<Movie, List<Rating<? extends Number>>> map = new ConcurrentHashMap<>();

    public synchronized void addRate(Movie movie, Rating <T> rate){
        if (movie == null || rate == null || rate.getRate() == null) {
            throw new IllegalArgumentException("Фильм и оценка не могут быть null");
        }

        double doubleRate = rate.getRate().doubleValue();
        if(doubleRate<1.0 || doubleRate>10.0) {
            throw new IllegalArgumentException("Оценка не может быть меньше 1 и больше 10");
        }
        map.putIfAbsent(movie, new CopyOnWriteArrayList<>());
        map.get(movie).add(rate);
    }

    public double getAverage(Movie movie){
        List<Rating<? extends Number>> listRating = map.get(movie);
        return listRating.stream()
                .mapToDouble(r ->r.getRate().doubleValue())
                .average()
                .orElse(0.0);
    }

    public Map<Movie, Double> sortByAverageRating(){
        return map.keySet().stream()
                .sorted(Comparator
                        .comparingDouble((Movie m) -> getAverage(m))
                        .reversed()
                        .thenComparing(Movie::getName)
                )
                .collect(Collectors.toMap(
                        movie -> movie,
                        this::getAverage,
                        (a, b) ->a,
                        LinkedHashMap::new
                ));


    }




}
